package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class UserPage {
    WebDriver driver;
    WebDriverWait wait;

    private final By askTheCommunityBtnPath = By.cssSelector("[data-cy='cy-askQuestion']");
    private final By createTipBtnPath = By.cssSelector("[data-cy='cy-createauserTip']");
    private final By browseBtnPath = By.cssSelector("[data-cy='cy-browse']");
    private final By searchBtnPath = By.cssSelector("[data-cy='cy-search']");
    private final By loungeLibelPath = By.xpath("//span[@class='localnav-menu-item rollout-menu-title'][normalize-space()='Lounge']");
    private final By mySubscriptionsBtnPath = By.cssSelector("[data-cy='My Subscriptions']");
    private final By profileBtn = By.cssSelector("[class='profile']");
    private final By moreBtn = By.cssSelector("[class='localnav-menu-link icon icon-after icon-chevrondown']");
    private final By loungeBtnPath = By.xpath("//div[@class='rollout-column']//a[@class='localnav-menu-link'][normalize-space()='Lounge Announcements']");

    public enum Button {
        Browse,
        Search,
        AskTheCommunity,
        CreateTip,
        Lounge
    }

    private final Map<Button, By> paths = new EnumMap<>(Button.class);
    {
        paths.put(Button.Browse, browseBtnPath);
        paths.put(Button.Search, searchBtnPath);
        paths.put(Button.AskTheCommunity, askTheCommunityBtnPath);
        paths.put(Button.CreateTip, createTipBtnPath);
        paths.put(Button.Lounge, loungeLibelPath);
    }

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

    public boolean buttonIsDisplayed(Button button) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(paths.get(button))).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickMoreBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(moreBtn)).click();
    }

    public void clickLoungeBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(moreBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loungeBtnPath)).click();
    }
}
