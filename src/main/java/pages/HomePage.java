package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;
    private final By logInBtnPath = By.cssSelector("[class='localnav-button button button-reduced popup-action-button']");
    private final By browseBtnPath = By.cssSelector("[class='localnav-menu-link'][href='/browse']");
    private final By searchBtnPath = By.cssSelector("[class='localnav-menu-link'][href='/search']");
    private final By closePopUpAlertPath = By.cssSelector("[class='icon icon-close close-notificaiton']");
    private final By searchInputTextFieldPath = By.id("askaquestion");

    public enum Button {
        LogIn,
        Browse,
        Search,
        ClosePopUpAlert
    }

    private final Map<HomePage.Button, By> paths = new EnumMap<>(HomePage.Button.class);

    {
        paths.put(HomePage.Button.LogIn, logInBtnPath);
        paths.put(HomePage.Button.Browse, browseBtnPath);
        paths.put(HomePage.Button.Search, searchBtnPath);
        paths.put(HomePage.Button.ClosePopUpAlert, closePopUpAlertPath);
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void switchTab(int tab) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tab));
    }

    public void clickButton(Button button) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(paths.get(button))).click();
        } catch (Exception ignored) {
        }
    }

    public void setSearchTextInput(String searchText) {
        wait.until(ExpectedConditions.elementToBeClickable(searchInputTextFieldPath)).sendKeys(searchText);
        wait.until(ExpectedConditions.elementToBeClickable(searchInputTextFieldPath)).sendKeys(Keys.ENTER);
    }

}
