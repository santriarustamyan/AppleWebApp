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
    private final By closePopUpAlertPath = By.cssSelector("[class='icon icon-close close-notificaiton']");

    private By pagePerBtnPath(String pageCount) {
        return By.cssSelector("[aria-label='" + pageCount + " per page']");
    }

    public MySubscriptionsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickFirstProfileLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(closePopUpAlertPath)).click();
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

}
