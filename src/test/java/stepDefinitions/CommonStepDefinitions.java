package stepDefinitions;

import classes.Requests;
import data.Users;
import dev.failsafe.internal.util.Assert;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class CommonStepDefinitions {

    public static WebDriver driver;
    public static HomePage homePage;
    public static LogInPage logInPage;
    public static BrowsePage browsePage;
    UserPage userPage;
    Requests requests;
    public static SearchPage searchPage;
    public static AskTheCommunityPage askTheCommunityPage;
    public static CreateTipPage createTipPage;
    public static ThreadPage threadPage;
    public static MySubscriptionsPage mySubscriptionsPage;
    public static ProfilePage profilePage;
    public static SubCommunityPage subCommunityPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        logInPage = new LogInPage(driver);
        browsePage = new BrowsePage(driver);
        userPage = new UserPage(driver);
        askTheCommunityPage = new AskTheCommunityPage(driver);
        createTipPage = new CreateTipPage(driver);
        requests = new Requests();
        threadPage = new ThreadPage(driver);
        mySubscriptionsPage = new MySubscriptionsPage(driver);
        profilePage = new ProfilePage(driver);
        searchPage = new SearchPage(driver);
        subCommunityPage = new SubCommunityPage(driver);
    }

    @Given("I am on the Home page")
    public void goHomePage() {
        driver.get("https://discussions.apple.com/welcome");
        driver.manage().window().maximize();
        homePage.clickButton(HomePage.Button.ClosePopUpAlert);
    }

    @When("I fill L{string} Login and password")
    public void iFillLLoginAndPassword(String levelNumber) {
        Users data = new Users();
        String userName = data.users.keySet().toArray()[Integer.parseInt(levelNumber) - 1].toString();
        String password = data.users.get(userName);
        logInPage.login(userName, password);
    }

    @And("{string} button is displayed")
    public void buttonIsDisplayed(String buttonName) {
        Assert.isTrue(userPage.buttonIsDisplayed(
                UserPage.Button.valueOf(buttonName)), buttonName + " button is not displayed");
    }

    @And("{string} button is not displayed")
    public void buttonIsNotDisplayed(String buttonName) {
        Assert.isTrue(!userPage.buttonIsDisplayed(
                UserPage.Button.valueOf(buttonName)), buttonName + " button is displayed");
    }

    @And("I am on the {string} page")
    public void iAmOnThePage(String buttonName) {
        homePage.clickButton(HomePage.Button.valueOf(buttonName));
    }

    @When("Fill and search")
    public void fillAndSearch() {
        searchPage.setSearchText("Apple");
        searchPage.clickButton(SearchPage.Button.SearchButton);
    }

    @Then("Go sub community page")
    public void goSubCommunityPage() {
        browsePage.clickButton(BrowsePage.Button.SubCommunityButton);
        homePage.switchTab(1);
    }

    @Then("My Subscriptions button is displayed")
    public void my_subscriptions_button_is_displayed() {
        userPage.clickButton(UserPage.Button.Profile);
        Assert.isTrue(userPage.buttonIsDisplayed(UserPage.Button.MySubscriptions), "My Subscriptions button is not displayed");
    }

    @Then("Go in My Subscriptions")
    public void clickMySubscriptionsButton() {
        userPage.clickButton(UserPage.Button.Profile);
        userPage.clickButton(UserPage.Button.MySubscriptions);
    }

    @Then("Access Lounge Announcements")
    public void goLoungeAnnouncements() {
        userPage.clickButton(UserPage.Button.More);
        userPage.clickButton(UserPage.Button.Lounge);
    }

    @Then("Try Access Lounge Announcements With Link")
    public void TryFindLoungeAnnouncementsWithLink() {
        int statusCode = requests.getStatusCode("https://discussions.apple.com/community/lounge/announcements");
        Assert.isTrue(statusCode == 404, "Page is accessible");
    }

    @Then("Try Access User Tip With Link")
    public void TryFindUserTipWithLink() {
        driver.get("https://discussions.apple.com/post/userTip");
        String expectedTitle = "Error - Access Denied - Apple Community";
        String currentTitle = driver.getTitle();
        Assert.isTrue(currentTitle.equals(expectedTitle), "Page is accessible");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
