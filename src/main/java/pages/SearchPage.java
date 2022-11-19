package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.EnumMap;
import java.util.Map;

public class SearchPage {

    WebDriver driver;
    WebDriverWait wait;
    private final By searchTextFieldPath = By.id("search");
    private final By searchBtnPath = By.cssSelector("[class='button button-primary search-button hide-mobile']");
    private final By filteredByTextPath = By.cssSelector("[class='filtered-by-text']");
    private final By filterBtnPath = By.cssSelector("[class='open-filters-button']");
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
    private final By topicThreadHeadingPath = By.cssSelector("[class='topics-heading']");
    private final By peopleAvatarPath = By.cssSelector("[class='post-author-profile author-user']");
    private final By searchByAuthorTextFieldPath = By.cssSelector("[aria-label='Search by author']");
    private final By nextBtnPath = By.cssSelector("[class='next-page icon icon-standalone icon-chevronright']");
    private final By previousBtnPath = By.cssSelector("[class='previous-page icon icon-standalone icon-chevronleft']");
    private final By pageNumberPath = By.cssSelector("[class='page-number']");
    private final By nameReplyToBtnPath = By.cssSelector("[class='topics-table-row thread']:nth-child(2) > .topics-table-row-details > article > a");
    private final By authorNameBtn2Path = By.cssSelector("tr:nth-child(2) > td.topics-table-row-latest-activity > div > a.author");
    private final By subCommunityBtnPath = By.cssSelector("tr:nth-child(2) > th > article > div.topic-meta > a.community-link");
    private final By authorNameBtn1Path = By.cssSelector("tr:nth-child(2) > th > article > div.topic-meta > [data-action='topic-author']");
    private final By popupUserNamePath = By.id("user-profile-popup-title");
    private final By popupClosePath = By.cssSelector("[class='modal-close-button']");
    private final By askTheCommunityBtnPath = By.cssSelector("[data-action='search-ask-community']");




    public enum Button {
        SubCommunityButton,
        AuthorNameButton2,
        AuthorNameButton1,
        PopupUserName,
        NameReplyToButton,
        FilteredByText,
        UserTipsButton,
        DiscussionsButton,
        TimeButton,
        DayButton,
        IPhoneButton,
        IPadButton,
        CommunityButton,
        FilterButton,
        PeopleButton,
        AuthorButton,
        SearchButton,
        NextButton,
        PreviousButton,
        PopupClose,
        ThreadHeadingText,
        AskTheCommunityButton
    }

    private final Map<SearchPage.Button, By> paths = new EnumMap<>(SearchPage.Button.class);

    {
        paths.put(SearchPage.Button.SubCommunityButton, subCommunityBtnPath);
        paths.put(SearchPage.Button.AuthorNameButton2, authorNameBtn2Path);
        paths.put(SearchPage.Button.AuthorNameButton1, authorNameBtn1Path);
        paths.put(SearchPage.Button.PopupUserName, popupUserNamePath);
        paths.put(SearchPage.Button.NameReplyToButton, nameReplyToBtnPath);
        paths.put(SearchPage.Button.FilteredByText, filteredByTextPath);
        paths.put(SearchPage.Button.UserTipsButton, userTipsBtnPath);
        paths.put(SearchPage.Button.DiscussionsButton, discussionsBtnPath);
        paths.put(SearchPage.Button.TimeButton, timeBtnPath);
        paths.put(SearchPage.Button.DayButton, dayBtnPath);
        paths.put(SearchPage.Button.IPhoneButton, iPhoneBtnPath);
        paths.put(SearchPage.Button.IPadButton, iPadBtnPath);
        paths.put(SearchPage.Button.CommunityButton, communityBtnPath);
        paths.put(SearchPage.Button.FilterButton, filterBtnPath);
        paths.put(SearchPage.Button.PeopleButton, peopleBtnPath);
        paths.put(SearchPage.Button.AuthorButton, authorBtnPath);
        paths.put(SearchPage.Button.SearchButton, searchBtnPath);
        paths.put(SearchPage.Button.NextButton, nextBtnPath);
        paths.put(SearchPage.Button.PreviousButton, previousBtnPath);
        paths.put(SearchPage.Button.PopupClose, popupClosePath);
        paths.put(SearchPage.Button.AskTheCommunityButton, askTheCommunityBtnPath);
        paths.put(SearchPage.Button.ThreadHeadingText, topicThreadHeadingPath);

    }

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickButton(Button button) {
        wait.until(ExpectedConditions.elementToBeClickable(paths.get(button))).click();
    }

    public String getButtonText(Button button) {
        return wait.until(ExpectedConditions.elementToBeClickable(paths.get(button))).getText();
    }

    public void setSearchText(String searchText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchTextFieldPath)).sendKeys(searchText);
    }

    public boolean buttonIsDisplayed(SearchPage.Button button) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(paths.get(button))).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickSolvedBtn() throws InterruptedException {
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

    public void clickAppleWatchBtn() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight/8)");
        Thread.sleep(4000);
        wait.until(ExpectedConditions.elementToBeClickable(appleWatchBtnPath)).click();
        wait.until(ExpectedConditions.elementToBeClickable(topicThreadHeadingPath));
        Thread.sleep(4000);
    }

    public boolean searchByAuthorBtnIsVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchByAuthorTextFieldPath)).isDisplayed();
    }

    public void peopleAvatar() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(peopleAvatarPath));
        } catch (Exception ignored) {
        }
    }

    public String getPageNumberName() throws InterruptedException {
        Thread.sleep(4000);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageNumberPath)).getText();
    }

    public void waitButtonVisibility() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(topicThreadHeadingPath));
    }

}
