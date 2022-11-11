package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogInPage {

    WebDriver driver;
    WebDriverWait wait;

    private final By appleIDTextFieldPath = By.id("account_name_text_field");
    private final By passwordTextFieldPath = By.cssSelector("[class='form-textbox-input ']");
    private final By nextBtnPath = By.cssSelector("[class='shared-icon icon_sign_in']");
    private final By otherOptionsBtnPath = By.cssSelector("[class='button button-secondary first  nav-cancel pull-right']");
    private final By dontUpgradeBtnPath = By.cssSelector("[class='button button-secondary first  nav-cancel pull-right']");

    private final By widgetIFramePath = By.id("aid-auth-widget-iFrame");
    private final By repairFramePath = By.id("repairFrame");

    public LogInPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void fillInLogin(String login) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(appleIDTextFieldPath)).clear();
        driver.findElement(appleIDTextFieldPath).sendKeys(login);
        driver.findElement(nextBtnPath).click();
    }

    public void fillInPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTextFieldPath)).clear();
        driver.findElement(passwordTextFieldPath).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(nextBtnPath)).click();
    }

    public void clickOtherOptionBtn() {
        driver.switchTo().frame(wait.until(ExpectedConditions.visibilityOfElementLocated(repairFramePath)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(otherOptionsBtnPath)).click();
    }

    public void clickDontUpgradeBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dontUpgradeBtnPath)).click();
    }

    public void login(String login, String password) {
        driver.switchTo().frame(wait.until(ExpectedConditions.visibilityOfElementLocated(widgetIFramePath)));
        fillInLogin(login);
        fillInPassword(password);
        clickOtherOptionBtn();
        clickDontUpgradeBtn();
    }
}
