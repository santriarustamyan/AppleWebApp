package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowsPage {
    WebDriver driver;

    private final By threadNamePath = By.cssSelector("[class='topic-title-link '][data-analytics-index='0']");


    public BrowsPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickThreadLink(){
        String a = driver.findElement(threadNamePath).getText();
        driver.findElement(threadNamePath).click();
    }
    public String getThreadName(){
        return driver.findElement(threadNamePath).getText();
    }

}
