package tests;

import manager.ApplicationManager;
import manager.TestNgListener;
import models.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import utils.ConfigProperties;

import java.lang.reflect.Method;
@Listeners(TestNgListener.class)

public class TestBase {
    static ApplicationManager app = new ApplicationManager();

    Logger logger = LoggerFactory.getLogger(TestBase.class);
//    UserDTO user = UserDTO.builder()
//            .email("aksiomamedved@gmail.com")
//            .password("AlexMed123!")
//            .build();
    UserDTO user = UserDTO.builder()
        .email(ConfigProperties.getProperties("email"))
        .password(ConfigProperties.getProperties("password"))
        .build();

    @BeforeSuite(alwaysRun = true)
    public void setup(){
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown(){
       // app.stop();
    }

}
