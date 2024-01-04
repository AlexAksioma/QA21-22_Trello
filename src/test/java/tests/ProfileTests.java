package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProfileTests extends TestBase{

    @BeforeClass
    public void login() {
        app.getHelperUser().login("aksiomamedved@gmail.com", "AlexMed123!");
    }

    @Test
    public void changeAvatarPositiveTest(){
        app.getHelperProfile().changeAvatar();
    }
}
