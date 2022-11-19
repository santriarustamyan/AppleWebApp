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

    public enum Button {
        NameProfile,
        FilterButton,
        UserTipsButton,
        TopicsCommunityButton,
        TopicsThreadButton,
        TopicsLatestActivityButton,
        AuthorNameButton1,
        FilteredByText,
        TopicsCommunitySpanButton,
        TopicsThreadButtonSpan,
        TopicsLatestActivitySpanButton
    }

    private final Map<MySubscriptionsPage.Button, By> paths = new EnumMap<>(MySubscriptionsPage.Button.class);

    {
        paths.put(MySubscriptionsPage.Button.NameProfile, nameProfilePath);
        paths.put(MySubscriptionsPage.Button.FilterButton, filterBtnPath);
        paths.put(MySubscriptionsPage.Button.UserTipsButton, userTipsBtnPath);
        paths.put(MySubscriptionsPage.Button.TopicsCommunityButton, topicsCommunityBtnPath);
        paths.put(MySubscriptionsPage.Button.TopicsThreadButton, topicsThreadBtnPath);
        paths.put(MySubscriptionsPage.Button.TopicsLatestActivityButton, topicsLatestActivityBtnPath);
        paths.put(MySubscriptionsPage.Button.AuthorNameButton1, authorNameBtn1Path);
        paths.put(MySubscriptionsPage.Button.FilteredByText, filteredByTextPath);
        paths.put(MySubscriptionsPage.Button.TopicsCommunitySpanButton, topicsCommunitySpanBtnPath);
        paths.put(MySubscriptionsPage.Button.TopicsThreadButtonSpan, topicsThreadBtnSpanPath);
        paths.put(MySubscriptionsPage.Button.TopicsLatestActivitySpanButton, topicsLatestActivitySpanBtnPath);
    }

    public MySubscriptionsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickButton(Button button) {
        wait.until(ExpectedConditions.elementToBeClickable(paths.get(button))).click();
    }

    public String getButtonText(Button button) {
        return wait.until(ExpectedConditions.elementToBeClickable(paths.get(button))).getText();
    }

    public void waitButtonClickable(Button button) {
        wait.until(ExpectedConditions.elementToBeClickable(paths.get(button)));
    }

    public String getButtonAttributeText(Button button, String nameAttribute) {
        return wait.until(ExpectedConditions.elementToBeClickable(paths.get(button))).getAttribute(nameAttribute);
    }

    private By pagePerBtnPath(String pageCount) {
        return By.cssSelector("[aria-label='" + pageCount + " per page']");
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

}
