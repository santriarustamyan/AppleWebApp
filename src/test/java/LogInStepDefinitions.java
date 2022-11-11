import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LogInPage;

public class LogInStepDefinitions {

    WebDriver driver;
    HomePage homePage;
    LogInPage logInPage;


    @Given("I am on the Home page")
    public void goHomePage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://discussions.apple.com/welcome");
        homePage = new HomePage(driver);
        logInPage = new LogInPage(driver);
    }

    @When("I am on the Login page")
    public void goSignInPage() throws InterruptedException {
        homePage.clickBtnLogIn();
        Thread.sleep(10000);
    }

    @Then("I fill Login and password")
    public void fillUserData() {
        logInPage.login();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
