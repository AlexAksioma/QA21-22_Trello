package tests;

import manager.TestNgListener;
import models.UserDTO;
import net.bytebuddy.description.modifier.MethodManifestation;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
@Listeners(TestNgListener.class)

public class ProfileTests extends TestBase{

//    UserDTO user = UserDTO.builder()
//            .email("aksiomamedved@gmail.com")
//            .password("AlexMed123!")
//            .build();

    @BeforeClass
    public void login() {
        logger.info("login with email --> " + user.getEmail() + " password --> " + user.getPassword());
        app.getHelperUser().loginDTO(user);
    }

    @Test
    public void changeAvatarPositiveTest(Method method){
        //logger.info("start method --> "+method.getName());
        app.getHelperProfile().changeAvatar();
        Assert.assertTrue(app.getHelperProfile().isTextInElementPresentByWait_Avatar_added());
    }

    @Test
    public void changeAvatarNegativeTest_txtFile(Method method){
        //logger.info("start method --> "+method.getName());
        app.getHelperProfile().changeAvatarNegative_txtFile();
        Assert.assertTrue(app.getHelperProfile().isTextInElementPreset_Try_again());
    }

    @AfterMethod
    public void afterTest(){
        logger.info("start after method ------------------------------");
        if(app.getHelperProfile().isTextInElementPreset_Try_again())
            app.getHelperProfile().clickCansel();
        app.getHelperProfile().returnToHomePage();
        logger.info("stop after method ------------------------------");
    }
}
