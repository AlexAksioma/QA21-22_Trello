package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperBoard extends HelperBase{
    public HelperBoard(WebDriver driver) {
        super(driver);
    }

    By buttonCreateNewBoard = By.xpath("//span[text()='Create new board']");
    By inputBoardTitle = By.xpath("//input[@data-testid='create-board-title-input']");

    By buttonCreateBoard = By.xpath("//button[@data-testid='create-board-submit-button']");

    By textBoardTitle = By.xpath("//h1[@data-testid='board-name-display']");

    By buttonBoards = By.xpath("//a[@data-testid='open-boards-link']"); //data-testid="open-boards-link"

    By dots = By.xpath("//button[@aria-label='Show menu']");

    By buttonCloseBoard = By.xpath("//a[@class='board-menu-navigation-item-link board-menu-navigation-item-link-v2 js-close-board']");

    By buttonCloseConfirm = By.xpath("//input[@value='Close']");

    By buttonDeleteBoard = By.xpath("//button[@data-testid='close-board-delete-board-button']");
    By buttonDeleteBoardConfirm = By.xpath("//button[@data-testid='close-board-delete-board-confirm-button']");

    //========================================]

    By listBoard = By.xpath("//h3[text()='YOUR WORKSPACES']/..//ul/li");
    List<WebElement> listBoardElLi = driver.findElements(listBoard);


    public void createNewBoard(String boardTitle) {
        clickBase(buttonCreateNewBoard);
        typeBase(inputBoardTitle, boardTitle);
        //pause(2);
        //clickBase(buttonCreateBoard);
        clickBaseWait(buttonCreateBoard,5);

    }
    public boolean isBoardTitlePresent(String text){
        return isTextInElementEquals(textBoardTitle, text);
    }

    public void clickButtonBoards(){
        clickBase(buttonBoards);
    }

    public void deleteBoard(String boardTitle) {
        pause(3);
        clickBoardsOnTitle(boardTitle);
        //clickBase(dots);
        clickBaseWait(dots, 5);
        clickBase(buttonCloseBoard);
        clickBase(buttonCloseConfirm);
        clickBase(buttonDeleteBoard);
        clickBase(buttonDeleteBoardConfirm);
    }

    private void clickBoardsOnTitle(String boardTitle) {
        driver.navigate().refresh();
        //String xPathBoardTitle = "//a[@href='/b/hsnwZRdF/"+boardTitle.toLowerCase()+"']";
        String xPathBoardTitle = "//div[@title='"+boardTitle+"']";
        System.out.println(xPathBoardTitle);
        //clickBase(By.xpath(xPathBoardTitle));
    }


    public boolean isTextInElementPresentByWait_boardTitle(String boardTitle, int time) {
        return isTextInElementPresentByWait(textBoardTitle, boardTitle, time);
    }


    public boolean isElementPresent_buttonBoards() {
        return  isElementPresent(buttonBoards);
    }
}
