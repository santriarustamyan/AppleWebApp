package pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.EnumMap;
import java.util.Map;

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


    public enum Button {
        SubCommunityButton,
        AuthorNameButton2,
        AuthorNameButton1,
        PopupUserName,
        FilteredByText,
        UserTipsButton,
        DiscussionsButton,
        IPhoneButton,
        IPadButton,
        CommunityButton,
        PopupClose,
        SolvedQuestionsButton,
        UnsolvedQuestionsButton,
        ThreadName
    }

    private final Map<BrowsePage.Button, By> paths = new EnumMap<>(BrowsePage.Button.class);

    {
        paths.put(BrowsePage.Button.SubCommunityButton, subCommunityBtnPath);
        paths.put(BrowsePage.Button.AuthorNameButton2, authorNameBtn2Path);
        paths.put(BrowsePage.Button.AuthorNameButton1, authorNameBtn1Path);
        paths.put(BrowsePage.Button.PopupUserName, popupUserNamePath);
        paths.put(BrowsePage.Button.FilteredByText, filteredByTextPath);
        paths.put(BrowsePage.Button.UserTipsButton, userTipsBtnPath);
        paths.put(BrowsePage.Button.DiscussionsButton, discussionsBtnPath);
        paths.put(BrowsePage.Button.IPhoneButton, iPhoneBtnPath);
        paths.put(BrowsePage.Button.IPadButton, iPadBtnPath);
        paths.put(BrowsePage.Button.CommunityButton, communityBtnPath);
        paths.put(BrowsePage.Button.PopupClose, popupClosePath);
        paths.put(BrowsePage.Button.SolvedQuestionsButton, solvedQuestionsBtnPath);
        paths.put(BrowsePage.Button.UnsolvedQuestionsButton, unsolvedQuestionsBtnPath);
        paths.put(BrowsePage.Button.ThreadName, threadNamePath);
    }


    public BrowsePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void clickButton(Button button) {
        wait.until(ExpectedConditions.elementToBeClickable(paths.get(button))).click();
    }

    public String getButtonText(Button button) {
        return wait.until(ExpectedConditions.elementToBeClickable(paths.get(button))).getText();
    }


    public void waitButtonVisibility() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(topicHeadingPath));
    }


    private By pagePerBtnPath(String pageCount) {
        return By.cssSelector("[aria-label='" + pageCount + " per page']");
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

    public void clickAppleWatchBtn() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight/8)");
        Thread.sleep(4000);
        wait.until(ExpectedConditions.elementToBeClickable(appleWatchBtnPath)).click();
        wait.until(ExpectedConditions.elementToBeClickable(topicHeadingPath));
        Thread.sleep(4000);
    }

}
