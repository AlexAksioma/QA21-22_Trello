package tests;

import manager.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {
    static ApplicationManager app = new ApplicationManager();

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setup(){
        app.init();
    }

    @AfterSuite
    public void tearDown(){
       // app.stop();
    }

}
