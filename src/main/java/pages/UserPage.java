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
        LoungeLibel,
        MySubscriptions,
        More,
        Profile,
        Lounge
    }

    private final Map<Button, By> paths = new EnumMap<>(Button.class);
    {
        paths.put(Button.Browse, browseBtnPath);
        paths.put(Button.Search, searchBtnPath);
        paths.put(Button.AskTheCommunity, askTheCommunityBtnPath);
        paths.put(Button.CreateTip, createTipBtnPath);
        paths.put(Button.LoungeLibel, loungeLibelPath);
        paths.put(Button.MySubscriptions, mySubscriptionsBtnPath);
        paths.put(Button.More, moreBtn);
        paths.put(Button.Profile, profileBtn);
        paths.put(Button.Lounge, loungeBtnPath);
    }

    public UserPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean buttonIsDisplayed(Button button) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(paths.get(button))).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickButton(Button button){
        wait.until(ExpectedConditions.visibilityOfElementLocated(paths.get(button))).click();
    }

}
