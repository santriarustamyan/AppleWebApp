package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserPage {
    WebDriver driver;
    WebDriverWait wait;

    private final By askTheCommunityBtnPath = By.cssSelector("[data-cy='cy-askQuestion']");
    private final By createTipBtnPath = By.cssSelector("[data-cy='cy-createauserTip']");
    private final By browseBtnPath = By.cssSelector("[data-cy='cy-browse']");
    private final By searchBtnPath = By.cssSelector("[data-cy='cy-search']");
    private final By mySubscriptionsBtnPath = By.cssSelector("[data-cy='My Subscriptions']");
    private final By loungeLibelPath = By.xpath("//span[@class='localnav-menu-item rollout-menu-title'][normalize-space()='Lounge']");
    private final By profileBtn = By.cssSelector("[class='profile']");
    private final By moreBtn = By.cssSelector("[class='localnav-menu-link icon icon-after icon-chevrondown']");
    private final By loungeBtnPath = By.xpath("//div[@class='rollout-column']//a[@class='localnav-menu-link'][normalize-space()='Lounge Announcements']");

    public UserPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public boolean mySubscriptionsBtnIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileBtn)).click();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mySubscriptionsBtnPath)).isDisplayed();
    }

    public void clickMySubscriptionsBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(mySubscriptionsBtnPath)).click();
    }

    public boolean browseBtnIsDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(browseBtnPath)).isDisplayed();
    }

    public boolean searchBtnIsDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchBtnPath)).isDisplayed();
    }

    public boolean askTheCommunityBtnIsDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(askTheCommunityBtnPath)).isDisplayed();
    }

    public boolean createTipBtnIsDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(createTipBtnPath)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean loungeLibelIsDisplayed() {
        try {
            driver.findElement(moreBtn).click();
            return wait.until(ExpectedConditions.visibilityOfElementLocated(loungeLibelPath)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickLoungeBtn() {
        driver.findElement(moreBtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loungeBtnPath)).click();
    }

}


