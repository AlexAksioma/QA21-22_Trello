package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class CreateNewBoardTests extends TestBase{

    @BeforeClass
    public void login(){
        app.getHelperUser().login("aksiomamedved@gmail.com","AlexMed123!");
    }

    @Test
    public void createNewBoardPositiveTest(){
        int i = new Random().nextInt(1000)+1000;
        String boardTitle = "board"+i;
        app.getHelperBoard().createNewBoard(boardTitle);
        Assert.assertTrue(app.getHelperBoard().isBoardTitlePresent(boardTitle));
    }
}
