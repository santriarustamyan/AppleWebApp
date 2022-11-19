package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.EnumMap;
import java.util.Map;

public class SubCommunityPage {
    WebDriver driver;
    WebDriverWait wait;
    private final By communityNamePath = By.cssSelector("[data-action='drop-down-button-text']");
    private final By authorIconBtnPath = By.cssSelector("article:nth-child(4) > a");
    private final By authorNameBtnPath = By.cssSelector("article:nth-child(4) > div > div > div.asked-by > a");
    private final By popupUserNamePath = By.id("user-profile-popup-title");
    private final By popupClosePath = By.cssSelector(" div:nth-child(19) > div:nth-child(1) > div:nth-child(1) > button:nth-child(2) > span:nth-child(1)");
    private final By threadNamePath = By.id("community-post-0-title");
    private final By searchInputTextFieldPath = By.id("askaquestion");

    public enum Button {
        CommunityName,
        AuthorIcon,
        AuthorName,
        PopupUserName,
        PopupClose,
        ThreadName
    }

    private final Map<SubCommunityPage.Button, By> paths = new EnumMap<>(SubCommunityPage.Button.class);

    {
        paths.put(SubCommunityPage.Button.CommunityName, communityNamePath);
        paths.put(SubCommunityPage.Button.AuthorIcon, authorIconBtnPath);
        paths.put(SubCommunityPage.Button.AuthorName, authorNameBtnPath);
        paths.put(SubCommunityPage.Button.PopupUserName, popupUserNamePath);
        paths.put(SubCommunityPage.Button.PopupClose, popupClosePath);
        paths.put(SubCommunityPage.Button.ThreadName, threadNamePath);
    }


    public SubCommunityPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getButtonText(Button button) {
        return wait.until(ExpectedConditions.elementToBeClickable(paths.get(button))).getText();
    }

    public void clickButton(Button button) {
        wait.until(ExpectedConditions.elementToBeClickable(paths.get(button))).click();
    }

    public void setSearchTextInput(String searchText) {
        wait.until(ExpectedConditions.elementToBeClickable(searchInputTextFieldPath)).sendKeys(searchText);
        wait.until(ExpectedConditions.elementToBeClickable(searchInputTextFieldPath)).sendKeys(Keys.ENTER);
    }

}
