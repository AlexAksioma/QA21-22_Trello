package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginPositiveTest(){
        app.getHelperUser().login("aksiomamedved@gmail.com","AlexMed123!");
        app.getHelperUser().takeScreenshot();
        Assert.assertTrue(app.getHelperUser().isLogged());
    }
}
