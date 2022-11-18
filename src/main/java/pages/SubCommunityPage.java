package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SubCommunityPage {
    WebDriver driver;
    WebDriverWait wait;
    private final By communityNamePath = By.cssSelector("[data-action='drop-down-button-text']");
    private final By authorIconBtnPath = By.cssSelector("article:nth-child(4) > a");
    private final By authorNameBtnPath = By.cssSelector("article:nth-child(4) > div > div > div.asked-by > a");
    private final By popupUserNamePath = By.id("user-profile-popup-title");
    private final By popupClosePath = By.cssSelector(" div:nth-child(19) > div:nth-child(1) > div:nth-child(1) > button:nth-child(2) > span:nth-child(1)");
    private final By threadNamePath = By.id("community-post-0-title");

    public SubCommunityPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getCommunityName() {
        return wait.until(ExpectedConditions.elementToBeClickable(communityNamePath)).getText();
    }

    public String getAuthorNameBtn() {
        return wait.until(ExpectedConditions.elementToBeClickable(authorNameBtnPath)).getText();
    }
    public void clickAuthorIconBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(authorIconBtnPath)).click();
    }
    public void clickAuthorNameBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(authorNameBtnPath)).click();
    }

    public String getPopupUserName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(popupUserNamePath)).getText();
    }

    public void clickPopupCloseBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(popupClosePath)).click();
    }

    public void clickThreadLink() {
        wait.until(ExpectedConditions.elementToBeClickable(threadNamePath)).click();
    }
    public String getThreadName() {
        return wait.until(ExpectedConditions.elementToBeClickable(threadNamePath)).getText();
    }
}



