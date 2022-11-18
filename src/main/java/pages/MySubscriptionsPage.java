package pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class MySubscriptionsPage {

    WebDriver driver;
    WebDriverWait wait;
    private final By nameProfilePath = By.cssSelector("a[class='author'] > span:nth-child(1)");
    private final By userTipsBtnPath = By.cssSelector("a[data-filter-id='filterUserTips']");
    private final By filterBtnPath = By.cssSelector("[class='open-filters-button']");
    private final By filteredByTextPath = By.cssSelector("[class='filtered-by-text']");
    private final By authorNameBtn1Path = By.cssSelector("tr:nth-child(2) > th > article > div.topic-meta > [data-action='topic-author']");
    private final By topicsCommunityBtnPath = By.cssSelector("[data-action='topics-community']");
    private final By topicsThreadBtnPath = By.cssSelector("[data-action='topics-thread']");
    private final By topicsLatestActivityBtnPath = By.cssSelector("[data-action='topics-latest-activity']");
    private final By topicsCommunitySpanBtnPath = By.cssSelector("[data-action='topics-community'] span");
    private final By topicsThreadBtnSpanPath = By.cssSelector("[data-action='topics-thread'] span");
    private final By topicsLatestActivitySpanBtnPath = By.cssSelector("[data-action='topics-latest-activity'] span");
    private final By peopleBtnPath = By.cssSelector("a[data-filter-id='filterPeople']");


    public MySubscriptionsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By pagePerBtnPath(String pageCount) {
        return By.cssSelector("[aria-label='" + pageCount + " per page']");
    }

    public void clickFirstProfileLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameProfilePath)).click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public String getProfileName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(nameProfilePath)).getText();
    }

    public void checkPerPageButton(String count) {
        String activeCountPerPagePath = "per-page-count active-per-page";
        By userNamePath = By.cssSelector("[class='user-profile-name']");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(pagePerBtnPath(count))).click();
        driver.navigate().to("https://discussions.apple.com/profile/" + driver.findElement(userNamePath).getText() + "/subscriptions?page=1&perPage=" + count);
        String getAttributeName = wait.until(ExpectedConditions.visibilityOfElementLocated(pagePerBtnPath(count))).getAttribute("class");
        Assert.isTrue(getAttributeName.equals(activeCountPerPagePath), "per page button no active");
    }

    public void clickFilterBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(filterBtnPath)).click();
    }

    public void clickUserTipBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(userTipsBtnPath)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(authorNameBtn1Path));
    }

    public String getTextSearchingResult() {
        return wait.until(ExpectedConditions.elementToBeClickable(filteredByTextPath)).getText();
    }

    public void clickPeopleBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(topicsCommunityBtnPath));
        wait.until(ExpectedConditions.elementToBeClickable(peopleBtnPath)).click();
    }
    public void clickTopicsCommunityBtnText() {
        wait.until(ExpectedConditions.elementToBeClickable(topicsCommunityBtnPath)).click();
        wait.until(ExpectedConditions.elementToBeClickable(topicsCommunityBtnPath));
    }

    public void clickTopicsThreadBtnText() {
        wait.until(ExpectedConditions.elementToBeClickable(topicsThreadBtnPath)).click();
        wait.until(ExpectedConditions.elementToBeClickable(topicsThreadBtnPath));
    }

    public void clickTopicsLatestActivityBtnText() {
        wait.until(ExpectedConditions.elementToBeClickable(topicsLatestActivityBtnPath)).click();
        wait.until(ExpectedConditions.elementToBeClickable(topicsLatestActivityBtnPath));
    }

    public String getTopicsCommunityBtnSpanText() {
        return wait.until(ExpectedConditions.elementToBeClickable(topicsCommunitySpanBtnPath)).getAttribute("class");
    }

    public String getTopicsThreadBtnSpanText() {
        return wait.until(ExpectedConditions.elementToBeClickable(topicsThreadBtnSpanPath)).getAttribute("class");
    }

    public String getTopicsLatestActivitySpanBtnText() {
        return wait.until(ExpectedConditions.elementToBeClickable(topicsLatestActivitySpanBtnPath)).getAttribute("class");
    }

}
