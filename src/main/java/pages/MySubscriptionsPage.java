package pages;

import org.openqa.selenium.By;
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

}
