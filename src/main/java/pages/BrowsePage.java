package pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class BrowsePage {
    WebDriver driver;
    WebDriverWait wait;
    private final By threadNamePath = By.cssSelector("[class='topic-title-link '][data-analytics-index='0']");
    private final By filteredByTextPath = By.cssSelector("[class='filtered-by-text']");
    private final By discussionsBtnPath = By.cssSelector("a[data-filter-id='filterDiscussions']");
    private final By userTipsBtnPath = By.cssSelector("a[data-filter-id='filterUserTips']");
    private final By solvedQuestionsBtnPath = By.cssSelector(".filter-link[href='?type=filterAnswered']");
    private final By unsolvedQuestionsBtnPath = By.cssSelector("a[data-filter-id='filterOpen']");
    private final By communityBtnPath = By.cssSelector("[data-filter-group-id='community']");
    private final By iPhoneBtnPath = By.cssSelector("a[data-filter-id='2043020']");
    private final By iPadBtnPath = By.cssSelector("a[data-filter-id='2039020']");
    private final By appleWatchBtnPath = By.cssSelector("a[data-filter-id='3061020']");
    private final By topicHeadingPath = By.cssSelector("[class='topics-heading']");
    private final By authorNameBtn1Path = By.cssSelector("tr:nth-child(2) > th > article > div.topic-meta > [data-action='topic-author']");
    private final By popupUserNamePath = By.id("user-profile-popup-title");
    private final By popupClosePath = By.cssSelector("[class='modal-close-button']");
    private final By authorNameBtn2Path = By.cssSelector("tr:nth-child(2) > td.topics-table-row-latest-activity > div > a.author");
    private final By subCommunityBtnPath = By.cssSelector("tr:nth-child(2) > th > article > div.topic-meta > a.community-link");


    public BrowsePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By pagePerBtnPath(String pageCount) {
        return By.cssSelector("[aria-label='" + pageCount + " per page']");
    }

    public void clickThreadLink() {
        driver.findElement(threadNamePath).click();
    }

    public String getThreadName() {
        return driver.findElement(threadNamePath).getText();
    }

    public void checkPerPageButton(String count) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        wait.until(ExpectedConditions.visibilityOfElementLocated(pagePerBtnPath(count))).click();
        driver.navigate().to("https://discussions.apple.com/browse/?page=1&perPage=" + count);

        String getAttributeName = wait.until(ExpectedConditions.visibilityOfElementLocated(pagePerBtnPath(count))).getAttribute("class");
        String activeCountPerPagePath = "per-page-count active-per-page";
        Assert.isTrue(getAttributeName.equals(activeCountPerPagePath), "per page button no active");
    }

    public void clickDiscussionsBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(discussionsBtnPath)).click();
        wait.until(ExpectedConditions.elementToBeClickable(topicHeadingPath));
    }

    public void clickSolvedBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(solvedQuestionsBtnPath)).click();
    }

    public void clickUnSolvedBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(unsolvedQuestionsBtnPath)).click();
    }

    public void clickIPhoneBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(communityBtnPath)).click();
        wait.until(ExpectedConditions.elementToBeClickable(iPhoneBtnPath)).click();
    }

    public void clickIpadBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(communityBtnPath)).click();
        wait.until(ExpectedConditions.elementToBeClickable(iPadBtnPath)).click();
    }

    public void clickUserTipBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(topicHeadingPath));
        wait.until(ExpectedConditions.elementToBeClickable(userTipsBtnPath)).click();
    }

    public void clickAppleWatchBtn() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight/8)");
        Thread.sleep(4000);
        wait.until(ExpectedConditions.elementToBeClickable(appleWatchBtnPath)).click();
        wait.until(ExpectedConditions.elementToBeClickable(topicHeadingPath));
        Thread.sleep(4000);
    }

    public String getTextSearchingResult() {
        return wait.until(ExpectedConditions.elementToBeClickable(filteredByTextPath)).getText();
    }
    public String getPopupUserName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(popupUserNamePath)).getText();
    }
    public void clickPopupCloseBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(popupClosePath)).click();
    } public String getAuthorNameBtn1() {
        return wait.until(ExpectedConditions.elementToBeClickable(authorNameBtn1Path)).getText();
    }
    public void clickAuthorNameBtn1() {
        wait.until(ExpectedConditions.elementToBeClickable(authorNameBtn1Path)).click();
    }
    public void clickAuthorNameBtn2() {
        wait.until(ExpectedConditions.elementToBeClickable(authorNameBtn2Path)).click();
    }

    public String getAuthorNameBtn2() {
        return wait.until(ExpectedConditions.elementToBeClickable(authorNameBtn2Path)).getText();
    }
    public void clickSubCommunityBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(subCommunityBtnPath)).click();
    }

    public String getSubCommunityBtnName() {
        return wait.until(ExpectedConditions.elementToBeClickable(subCommunityBtnPath)).getText();
    }

}
