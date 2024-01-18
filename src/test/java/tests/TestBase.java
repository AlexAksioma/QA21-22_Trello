package tests;

import manager.ApplicationManager;
import manager.TestNgListener;
import models.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.lang.reflect.Method;
@Listeners(TestNgListener.class)

public class TestBase {
    static ApplicationManager app = new ApplicationManager();

    Logger logger = LoggerFactory.getLogger(TestBase.class);
    UserDTO user = UserDTO.builder()
            .email("aksiomamedved@gmail.com")
            .password("AlexMed123!")
            .build();

    @BeforeSuite
    public void setup(){
        app.init();
    }

    @AfterSuite
    public void tearDown(){
       // app.stop();
    }

}
