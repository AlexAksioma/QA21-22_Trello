package tests;

import dataproviders.DataProviderBoard;
import manager.TestNgListener;
import models.BoardDTO;
import models.UserDTO;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Random;

@Listeners(TestNgListener.class)

public class BoardTests extends TestBase {

//    UserDTO user = UserDTO.builder()
//            .email("aksiomamedved@gmail.com")
//            .password("AlexMed123!")
//            .build();

    @BeforeClass
    public void login() {
        logger.info("login with email --> " + user.getEmail() + " password --> " + user.getPassword());
        app.getHelperUser().loginDTO(user);
    }

//    @Test
//    public void createNewBoardPositiveTest(Method method) {
//        int i = new Random().nextInt(1000) + 1000;
//        String boardTitle = "board" + i;
//        app.getHelperBoard().createNewBoard(boardTitle);
//        logger.info("method --> " + method.getName() + " with data board title --> " + boardTitle);
//        //Assert.assertTrue(app.getHelperBoard().isBoardTitlePresent(boardTitle));
//        Assert.assertTrue(app.getHelperBoard().isTextInElementPresentByWait_boardTitle(boardTitle, 5));
//    }

//    @Test
//    public void createNewBoardPositiveTest_Lombok(Method method) {
//        int i = new Random().nextInt(1000) + 1000;
//        BoardDTO board = BoardDTO.builder()
//                .boardTitle("boardDto" + i)
//                .build();
//        app.getHelperBoard().createNewBoard(board.getBoardTitle());
//        logger.info("method --> " + method.getName() + " with data board title --> " + board.getBoardTitle());
//        Assert.assertTrue(app.getHelperBoard().isBoardTitlePresent(board.getBoardTitle()));
//    }
    //==================================== dataProvider
    @Test(dataProvider = "dataProvider_createNewBoardPositiveTest_DP", dataProviderClass = DataProviderBoard.class)
    public void createNewBoardPositiveTest_DP(BoardDTO board, Method method) {
        app.getHelperBoard().createNewBoard(board.getBoardTitle());
        logger.info("method --> " + method.getName() + " with data board title --> " + board.getBoardTitle());
        Assert.assertTrue(app.getHelperBoard().isBoardTitlePresent(board.getBoardTitle()));
    }

//    @Test
//    public void deleteBoardPositiveTest(Method method) {
//        int i = new Random().nextInt(1000) + 1000;
//        BoardDTO board = BoardDTO.builder()
//                .boardTitle("boardDto" + i)
//                .build();
//        app.getHelperBoard().createNewBoard(board.getBoardTitle()); //create new board
//        logger.info("method --> " + method.getName() + " with data board title --> " + board.getBoardTitle());
//        app.getHelperBoard().clickButtonBoards();
//        //=================================================
//        app.getHelperBoard().deleteBoard(board.getBoardTitle());
//    }

    @Test(dataProvider = "dataProvider_deleteBoardPositiveTest_DP", dataProviderClass = DataProviderBoard.class)
    public void deleteBoardPositiveTest_DP(BoardDTO board, Method method) {
        app.getHelperBoard().createNewBoard(board.getBoardTitle()); //create new board
        logger.info("method --> " + method.getName() + " with data board title --> " + board.getBoardTitle());
        app.getHelperBoard().clickButtonBoards();
        //=================================================
        app.getHelperBoard().deleteBoard(board.getBoardTitle());
    }

    @Test
    public void deleteAllBoardsTest() {
        //logger.info("start method deleteAllBoards =======================================");
        app.getHelperBoard().deleteElementList();
    }


    @AfterMethod
    public void afterMethod() {
        logger.info("start after method ------------------------------");
        if (app.getHelperBoard().isElementPresent_buttonBoards())
            app.getHelperBoard().clickButtonBoards();
        logger.info("stop after method -------------------------------");
    }

//    @AfterClass
//    public void logout(){
//        app.getHelperUser().logout();
//    }
}
