package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {

    WebDriver driver;
    private final By appleIDTextFieldPath = By.cssSelector("[id='account_name_text_field']");
    private final By passwordTextFieldPath = By.id("password_text_field");

    private final By nextBtnPath = By.cssSelector("[class='shared-icon icon_sign_in']");
    private final By otherOptionsBtnPath = By.cssSelector("[class='button button-secondary first  nav-cancel pull-right']");
    private final By dontUpgradeBtnPath = By.cssSelector("[class='button button-secondary first  nav-cancel pull-right']");

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillInLogin() {
        driver.findElement(appleIDTextFieldPath).sendKeys("johnjul2017@outlook.com");
        driver.findElement(nextBtnPath).click();

    }

    public void fillInPassword() {
        driver.findElement(passwordTextFieldPath).sendKeys("Password@12");
        driver.findElement(nextBtnPath).click();
    }

    public void clickOtherOptionBtn() {
        driver.findElement(otherOptionsBtnPath).click();
    }

    public void clickDontUpgradeBtn() {
        driver.findElement(dontUpgradeBtnPath).click();
    }

    public void login() {

        fillInLogin();
        fillInPassword();
        clickOtherOptionBtn();
        clickDontUpgradeBtn();
    }

}
