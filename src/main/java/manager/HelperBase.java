package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HelperBase {
    WebDriver driver;
    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }
    By buttonHeaderMemberMenu = By.xpath("//button[@data-testid='header-member-menu-button']");

    private WebElement findElementBase(By locator){
        //System.out.println(locator);
        return driver.findElement(locator);
    }

    private List<WebElement> findElementsBase(By locator){
        //System.out.println(locator);
        return driver.findElements(locator);
    }

    public void pause(int time){
        try {
            Thread.sleep(time* 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickBase(By locator){
        WebElement element = findElementBase(locator);
        element.click();
    }

    public void clickBaseWait(By locator, int time){
        WebDriverWait wait = new WebDriverWait(driver, time);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        }catch (Exception e){

        }
    }
    public void typeBase(By locator, String text){
        WebElement element = findElementBase(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public boolean isElementPresent(By locator){       //return list.size() > 0
        return !findElementsBase(locator).isEmpty();
    }

    public boolean isTextInElementEquals(By locator, String text){
        WebElement element = findElementBase(locator);
        return element.getText().equals(text);
    }
    public  boolean isTextInElementPresentByWait(By locator, String text, int time){
        return new WebDriverWait(driver, time)
                .until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }


}
