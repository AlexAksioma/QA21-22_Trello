package tests;

import net.bytebuddy.description.modifier.MethodManifestation;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ProfileTests extends TestBase{

    @BeforeClass
    public void login() {
        app.getHelperUser().login("aksiomamedved@gmail.com", "AlexMed123!");
    }

    @Test
    public void changeAvatarPositiveTest(Method method){
        logger.info("start method --> "+method.getName());
        app.getHelperProfile().changeAvatar();
        Assert.assertTrue(app.getHelperProfile().isTextInElementPresentByWait_Avatar_added());
    }

    @Test
    public void changeAvatarNegativeTest_txtFile(Method method){
        logger.info("start method --> "+method.getName());
        app.getHelperProfile().changeAvatarNegative_txtFile();
        Assert.assertTrue(app.getHelperProfile().isTextInElementPreset_Try_again());
    }

    @AfterMethod
    public void afterTest(){
        if(app.getHelperProfile().isTextInElementPreset_Try_again())
            app.getHelperProfile().clickCansel();
        app.getHelperProfile().returnToHomePage();
    }
}
