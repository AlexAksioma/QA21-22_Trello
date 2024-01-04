package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver driver;

    HelperUser helperUser;

    HelperBoard helperBoard;

    HelperProfile helperProfile;

    public void init(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://trello.com/home");
        helperUser = new HelperUser(driver);
        helperBoard = new HelperBoard(driver);
        helperProfile = new HelperProfile(driver);

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
    }

}
