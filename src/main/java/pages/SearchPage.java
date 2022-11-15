package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {

    WebDriver driver;
    WebDriverWait wait;
    private final By searchTextFieldPath = By.id("search");
    private final By searchBtnPath = By.cssSelector("[class='button button-primary search-button hide-mobile']");
    private final By filteredByTextPath = By.cssSelector("[class='filtered-by-text']");
    private final By closePopUpAlertPath = By.cssSelector("[class='icon icon-close close-notificaiton']");
    private final By filterBtnPath = By.cssSelector("[class='open-filters-button']");
    private final By resetBtnPath = By.cssSelector("[class='reset-filters-button']");
    private final By discussionsBtnPath = By.cssSelector("a[data-filter-id='filterDiscussions']");
    private final By userTipsBtnPath = By.cssSelector("a[data-filter-id='filterUserTips']");
    private final By peopleBtnPath = By.cssSelector("a[data-filter-id='filterPeople']");
    private final By typeBtnPath = By.cssSelector("div[class='filters-layout-desktop-filters hide-mobile open'] button[aria-label='Type filters Choose one']");
    private final By solvedQuestionsBtnPath = By.cssSelector(".filter-link[href='?type=filterAnswered']");
    private final By unsolvedQuestionsBtnPath = By.cssSelector("a[data-filter-id='filterOpen']");
    private final By communityBtnPath = By.cssSelector("[data-filter-group-id='community']");
    private final By iPhoneBtnPath = By.cssSelector("a[data-filter-id='2043020']");
    private final By iPadBtnPath = By.cssSelector("a[data-filter-id='2039020']");
    private final By appleWatchBtnPath = By.cssSelector("a[data-filter-id='3061020']");
    private final By authorBtnPath = By.cssSelector("[data-filter-group-id='author']");
    private final By timeBtnPath = By.cssSelector("[data-filter-group-id='time']");
    private final By dayBtnPath = By.cssSelector("a[data-filter-id='day']");
    private final By topicHeadingPath = By.cssSelector("[class='topics-heading']");
    private final By peopleAvatarPath = By.cssSelector("[class='post-author-profile author-user']");
    private final By searchByAuthorTextFieldPath = By.cssSelector("[aria-label='Search by author']");
    private final By nextBtnPath = By.cssSelector("[class='next-page icon icon-standalone icon-chevronright']");
    private final By previousBtnPath = By.cssSelector("[class='previous-page icon icon-standalone icon-chevronleft']");
    private final By pageNumberPath = By.cssSelector("[class='page-number']");
    private final By nameReplyToBtnPath = By.cssSelector("[class='topics-table-row thread']:nth-child(2) > .topics-table-row-details > article > a");
    private final By authorNameBtn2Path = By.cssSelector("tr:nth-child(2) > td.topics-table-row-latest-activity > div > a.author");
    private final By whereThreadInBtnPath = By.cssSelector("tr:nth-child(2) > th > article > div.topic-meta > a.community-link");
    private final By authorNameBtn1Path = By.cssSelector("tr:nth-child(2) > th > article > div.topic-meta > [data-action='topic-author']");
    private final By popupUserNamePath = By.id("user-profile-popup-title");
    private final By popupClosePath = By.cssSelector("[class='modal-close-button']");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void setSearchText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchTextFieldPath)).sendKeys("Apple");
    }

    public void clickSearchBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(searchBtnPath)).click();
    }

    public void clickDiscussionsBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(discussionsBtnPath)).click();
        wait.until(ExpectedConditions.elementToBeClickable(topicHeadingPath)).click();

    }

    public void clickSolvedBtn() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(closePopUpAlertPath)).click();
        wait.until(ExpectedConditions.elementToBeClickable(typeBtnPath)).click();
        Thread.sleep(4000);
        wait.until(ExpectedConditions.elementToBeClickable(solvedQuestionsBtnPath)).click();
    }

    public void clickUnSolvedBtn() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight/8)");
        Thread.sleep(4000);
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

    public void clickFilterBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(filterBtnPath)).click();
    }

    public void clickPeopleBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(peopleBtnPath)).click();
    }

    public void clickAuthorBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(authorBtnPath)).click();
    }

    public boolean searchByAuthorBtnIsVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchByAuthorTextFieldPath)).isDisplayed();
    }

    public void clickTimeBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(timeBtnPath)).click();
        wait.until(ExpectedConditions.elementToBeClickable(dayBtnPath)).click();
    }

    public void peopleAvatar() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(peopleAvatarPath));
        } catch (Exception ignored) {
        }
    }

    public void clickResetBtn() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(resetBtnPath)).click();
        } catch (Exception ignored) {
        }
    }

    public String getTextSearchingResult() {
        return wait.until(ExpectedConditions.elementToBeClickable(filteredByTextPath)).getText();
    }

    public void clickNextBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(closePopUpAlertPath)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(nextBtnPath)).click();
    }

    public String getPageNumberName() throws InterruptedException {
        Thread.sleep(4000);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageNumberPath)).getText();
    }

    public void clickPreviousBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(previousBtnPath)).click();
    }

    public void clickReplyToBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(nameReplyToBtnPath)).click();
    }

    public String getReplyToBtnName() {
        return wait.until(ExpectedConditions.elementToBeClickable(nameReplyToBtnPath)).getText();
    }

    public void clickAuthorNameBtn1() {
        wait.until(ExpectedConditions.elementToBeClickable(authorNameBtn1Path)).click();
    }

    public String getAuthorNameBtn1() {
        return wait.until(ExpectedConditions.elementToBeClickable(authorNameBtn1Path)).getText();
    }

    public String getPopupUserName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(popupUserNamePath)).getText();
    }

    public void clickPopupCloseBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(popupClosePath)).click();
    }

    public void clickAuthorNameBtn2() {
        wait.until(ExpectedConditions.elementToBeClickable(authorNameBtn2Path)).click();
    }

    public String getAuthorNameBtn2() {
        return wait.until(ExpectedConditions.elementToBeClickable(authorNameBtn2Path)).getText();
    }

    public void clickWhereInThreadBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(whereThreadInBtnPath)).click();
    }

    public String getWhereInThreadBtnName() {
        return wait.until(ExpectedConditions.elementToBeClickable(whereThreadInBtnPath)).getText();
    }

}
