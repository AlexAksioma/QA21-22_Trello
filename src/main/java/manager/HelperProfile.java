package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class HelperProfile extends HelperBase{
    public HelperProfile(WebDriver driver) {
        super(driver);
    }

    By buttonManageAccount = By.xpath("//a[@data-testid='manage-account-link']");

    By textProfileAndVisibility = By.xpath("//h1");

    By profilePhoto = By.xpath("//div[@data-test-selector='profile-hover-info']");

    By buttonChangeProfile = By.xpath("//button[@data-testid='change-avatar']");

    By buttonUploadPhoto = By.id("image-input");

    By buttonUpload = By.xpath("//button[@type='submit']");
    public void changeAvatar() {
        clickBase(buttonHeaderMemberMenu);
        clickBase(buttonManageAccount);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.textToBePresentInElementLocated(textProfileAndVisibility,"Profile and visibility"));
        clickBase(profilePhoto);
        clickBase(buttonChangeProfile);
        //pause(5);
        driver.findElement(buttonUploadPhoto)
                .sendKeys("C:\\QA_Auto_Projects\\QA_21_22\\QA21-22_Trello\\src\\test\\resources\\qa_yellow.png"); //add photo
        clickBase(buttonUpload);
        System.out.println("--> "+driver.findElement(buttonUpload).getCssValue("text-align"));

    }
}
