package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CreateTipPage {

    WebDriver driver;
    WebDriverWait wait;
    private final By createPostTitleInputPath = By.id("create-post-title-input");
    private final By creatQuestionInputPath = By.cssSelector("[class='ql-editor ql-blank']");
    private final By chooseTopicPath = By.cssSelector("[aria-controls='selection-item general-error'] > div:nth-child(1)");
    private final By submitBtnPath = By.cssSelector("[class='button create-post-button']");
    private final By followBtnPath = By.cssSelector("[data-cy='cy-unfollow']");


    public CreateTipPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void createTip(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(createPostTitleInputPath)).sendKeys("TopicTitle");
        driver.findElement(creatQuestionInputPath).sendKeys("Question");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //get the height of the webpage and scroll to the end
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        driver.findElement(chooseTopicPath).click();
        driver.findElement(submitBtnPath).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(followBtnPath));


    }
}
