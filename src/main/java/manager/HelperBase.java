package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperBase {
    WebDriver driver;
    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    public void pause(int time){
        try {
            Thread.sleep(time* 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickBase(By locator){
        WebElement element = driver.findElement(locator);
        element.click();
    }
}
