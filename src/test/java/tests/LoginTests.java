package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginPositiveTest(){
        app.getHelperUser().login("aksiomamedved@gmail.com","AlexMed123!");
        Assert.assertTrue(app.getHelperUser().isLogged());
    }
}
