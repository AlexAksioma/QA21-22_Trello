package tests;

import models.BoardDTO;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class BoardTests extends TestBase {

    @BeforeClass
    public void login() {
        app.getHelperUser().login("aksiomamedved@gmail.com", "AlexMed123!");
    }

    @Test
    public void createNewBoardPositiveTest() {
        int i = new Random().nextInt(1000) + 1000;
        String boardTitle = "board" + i;
        app.getHelperBoard().createNewBoard(boardTitle);
        //Assert.assertTrue(app.getHelperBoard().isBoardTitlePresent(boardTitle));
        Assert.assertTrue(app.getHelperBoard().isTextInElementPresentByWait_boardTitle(boardTitle, 5));
    }

    @Test
    public void createNewBoardPositiveTest_Lombok() {
        int i = new Random().nextInt(1000) + 1000;
        BoardDTO board = BoardDTO.builder()
                .boardTitle("boardDto" + i)
                .build();
        app.getHelperBoard().createNewBoard(board.getBoardTitle());
        Assert.assertTrue(app.getHelperBoard().isBoardTitlePresent(board.getBoardTitle()));
    }

    @Test
    public void deleteBoardPositiveTest(){
        int i = new Random().nextInt(1000) + 1000;
        BoardDTO board = BoardDTO.builder()
                .boardTitle("boardDto" + i)
                .build();
        app.getHelperBoard().createNewBoard(board.getBoardTitle()); //create new board
        app.getHelperBoard().clickButtonBoards();
        //=================================================
        app.getHelperBoard().deleteBoard(board.getBoardTitle());
    }

//    @AfterMethod
//    public void afterMethod() {
//        app.getHelperBoard().clickButtonBoards();
//    }

//    @AfterClass
//    public void logout(){
//        app.getHelperUser().logout();
//    }
}
