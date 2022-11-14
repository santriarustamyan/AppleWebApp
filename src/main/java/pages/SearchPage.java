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
    private final By searchByAuthorBtn = By.cssSelector("[aria-label='Search by author']");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void setSearchText() {
        driver.findElement(searchTextFieldPath).sendKeys("Apple");
    }

    public void clickSearchBtn() {
        driver.findElement(searchBtnPath).click();
    }

    public void clickDiscussionsBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(discussionsBtnPath)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(topicHeadingPath)).click();

    }

    public void clickSolvedBtn() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(closePopUpAlertPath)).click();

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
        driver.findElement(communityBtnPath).click();
        driver.findElement(iPhoneBtnPath).click();
    }

    public void clickIpadBtn() {
        driver.findElement(communityBtnPath).click();
        driver.findElement(iPadBtnPath).click();
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
        driver.findElement(filterBtnPath).click();
    }

    public void clickPeopleBtn() {
        driver.findElement(peopleBtnPath).click();
    }

    public void clickAuthorBtn() {
        driver.findElement(authorBtnPath).click();
    }

    public boolean searchByAuthorBtnIsVisible() {
       return driver.findElement(searchByAuthorBtn).isDisplayed();
    }

    public void clickTimeBtn() {
        driver.findElement(timeBtnPath).click();
        driver.findElement(dayBtnPath).click();
    }

    public void peopleAvatar() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(peopleAvatarPath));
        } catch (Exception e) {
        }
    }



    public void clickResetBtn() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(resetBtnPath)).click();
        } catch (Exception e) {
        }
    }

    public String getTextSearchingResult() {
        return wait.until(ExpectedConditions.elementToBeClickable(filteredByTextPath)).getText();
    }

}
