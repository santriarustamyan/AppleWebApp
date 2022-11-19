package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    private final By logInBtnPath = By.cssSelector("[class='localnav-button button button-reduced popup-action-button']");
    private final By browseBtnPath = By.cssSelector("[class='localnav-menu-link'][href='/browse']");
    private final By searchBtnPath = By.cssSelector("[class='localnav-menu-link'][href='/search']");
    private final By closePopUpAlertPath = By.cssSelector("[class='icon icon-close close-notificaiton']");
    private final By searchInputTextFieldPath = By.id("askaquestion");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickSwitchTab(int tab) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tab));
    }

    public void clickBtnLogIn() {
        wait.until(ExpectedConditions.elementToBeClickable(logInBtnPath)).click();
    }

    public void clickBtnBrows() {
        wait.until(ExpectedConditions.elementToBeClickable(browseBtnPath)).click();
    }

    public void clickBtnSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(searchBtnPath)).click();
    }

    public void setSearchTextInput(String searchText) {
        wait.until(ExpectedConditions.elementToBeClickable(searchInputTextFieldPath)).sendKeys(searchText);
        wait.until(ExpectedConditions.elementToBeClickable(searchInputTextFieldPath)).sendKeys(Keys.ENTER);
    }

    public void clickClosePopupBtn() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(closePopUpAlertPath)).click();
        } catch (Exception ignored) {
        }
    }


}

