package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver driver;

    HelperUser helperUser;

    HelperBoard helperBoard;

    HelperProfile helperProfile;

    public Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    String url = "https://trello.com/home";

    public void init(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(url);
        helperUser = new HelperUser(driver);
        helperBoard = new HelperBoard(driver);
        helperProfile = new HelperProfile(driver);

        logger.info("URL --> " +url+"start testing --> "+ LocalDate.now());
    }

    public HelperUser getHelperUser(){
        return helperUser;
    }
    public HelperBoard getHelperBoard(){
        return helperBoard;
    }

    public HelperProfile getHelperProfile(){
        return  helperProfile;
    }
    public void stop(){
        //driver.close();
        driver.quit();
        logger.info("stop testing --> "+LocalDate.now());
    }

}
