package pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;

public class BrowsPage {
    WebDriver driver;
    WebDriverWait wait;
    private final By threadNamePath = By.cssSelector("[class='topic-title-link '][data-analytics-index='0']");

    private By pagePerBtnPath(String pageCount) {
        return By.cssSelector("[aria-label='" + pageCount + " per page']");
    }

    public BrowsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickThreadLinkAndSwitchTab() {
        driver.findElement(threadNamePath).click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
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

}
