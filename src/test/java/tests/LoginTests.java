package tests;

import manager.TestNgListener;
import models.UserDTO;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
@Listeners(TestNgListener.class)

public class LoginTests extends TestBase{

    @Test(enabled = false)
    public void loginPositiveTest(Method method){
//        UserDTO user = UserDTO.builder()
//                .email("aksiomamedved@gmail.com")
//                .password("AlexMed123!")
//                .build();
        long startTime = System.currentTimeMillis();
        //app.getHelperUser().login("aksiomamedved@gmail.com","AlexMed123!");
        app.getHelperUser().login(user.getEmail(), user.getPassword());
        logger.info("method --> " +method.getName()+" email --> "+user.getEmail()+" password --> "+user.getPassword());
        //app.getHelperUser().takeScreenshot();
        logger.info("method duration --> "+(startTime-System.currentTimeMillis()));
        Assert.assertTrue(app.getHelperUser().isLogged());
    }
}
