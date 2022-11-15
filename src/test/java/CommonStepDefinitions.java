import dev.failsafe.internal.util.Assert;
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

    WebDriver driver;
    HomePage homePage;
    LogInPage logInPage;
    BrowsePage browsPage;
    UserPage userPage;
    AskTheCommunityPage askTheCommunityPage;
    CreateTipPage createTipPage;
    Requests requests;
    ThreadPage threadPage;
    MySubscriptionsPage mySubscriptionsPage;
    ProfilePage profilePage;
    SearchPage searchPage;
    CommunityPage communityPage;


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        logInPage = new LogInPage(driver);
        browsPage = new BrowsePage(driver);
        userPage = new UserPage(driver);
        askTheCommunityPage = new AskTheCommunityPage(driver);
        createTipPage = new CreateTipPage(driver);
        requests = new Requests();
        threadPage = new ThreadPage(driver);
        mySubscriptionsPage = new MySubscriptionsPage(driver);
        profilePage = new ProfilePage(driver);
        searchPage = new SearchPage(driver);
        communityPage = new CommunityPage(driver);
    }

    @Given("I am on the Home page")
    public void goHomePage() {
        driver.get("https://discussions.apple.com/welcome");
        driver.manage().window().maximize();
        homePage.clickClosePopupBtn();
    }

    @When("I am on the Login page")
    public void goSignInPage() {
        homePage.clickBtnLogIn();
    }

    @Then("I fill L Login and password")
    public void fillLUserData() {
        logInPage.login("johnaug2017@outlook.com", "Password@12");
    }

    @Then("I fill L5 Login and password")
    public void fillL5UserData() {
        logInPage.login("johnjan2017@outlook.com", "Password@12");
    }

    @Then("I fill L6 Login and password")
    public void fillL6UserData() {
        logInPage.login("apple.asc003+100@gmail.com", "Hampshire@123");
    }

    @When("I am on the Browse page")
    public void goBrowsePage() {
        homePage.clickBtnBrows();
    }

    @When("I am on the Search page")
    public void goSearchPage() {
        homePage.clickBtnSearch();
    }

    @When("Fill and search")
    public void fillAndSearch() {
        searchPage.setSearchText();
        searchPage.clickSearchBtn();
    }

    @When("I click filter button in search page")
    public void clickFilterInSearchPage() {
        searchPage.clickFilterBtn();
    }

    @When("I click filter button in browse page")
    public void clickFilterInBrowsePage() {
        searchPage.clickFilterBtn();
    }

    @Then("Discussions -> Solved -> iPhone -> verify results search page")
    public void clickIPhoneVerifyResultInSearchPage() throws InterruptedException {
        String expectedNameOfSearching = "\"Discussions\", \"Solved questions\" and \"iPhone\"";
        searchPage.clickDiscussionsBtn();
        searchPage.clickSolvedBtn();
        searchPage.clickIPhoneBtn();
        Assert.isTrue(expectedNameOfSearching.equals(searchPage.getTextSearchingResult()), "Steps dont working right");
    }

    @Then("Discussions -> Solved -> iPhone -> verify results browse page")
    public void clickIPhoneVerifyResultInBrowsePage() {
        String expectedNameOfSearching = "\"Discussions\", \"Solved questions\" and \"iPhone\"";
        browsPage.clickDiscussionsBtn();
        browsPage.clickSolvedBtn();
        browsPage.clickIPhoneBtn();
        Assert.isTrue(expectedNameOfSearching.equals(browsPage.getTextSearchingResult()), "Steps dont working right");
    }

    @Then("Discussions -> UnSolved -> iPad -> verify results search page")
    public void clickIPadVerifyResultInSearchPage() throws InterruptedException {
        String expectedNameOfSearching = "\"Discussions\", \"Unsolved questions\" and \"iPad\"";
        Thread.sleep(4000);
        searchPage.clickDiscussionsBtn();
        searchPage.clickUnSolvedBtn();
        searchPage.clickIpadBtn();
        Assert.isTrue(expectedNameOfSearching.equals(searchPage.getTextSearchingResult()), "Steps dont work right");
    }

    @Then("Discussions -> UnSolved -> iPad -> verify results browse page")
    public void clickIPadVerifyResultInBrowsePage() throws InterruptedException {
        String expectedNameOfSearching = "\"Discussions\", \"Unsolved questions\" and \"iPad\"";
        Thread.sleep(4000);
        browsPage.clickDiscussionsBtn();
        browsPage.clickUnSolvedBtn();
        browsPage.clickIpadBtn();
        Assert.isTrue(expectedNameOfSearching.equals(browsPage.getTextSearchingResult()), "Steps dont work right");
    }

    @Then("UserTips -> AppleWatch -> verify results search page")
    public void clickAppleWatchVerifyResultInSearchPage() throws InterruptedException {
        String expectedNameOfSearching = "\"User Tips\" and \"Apple Watch\"";
        searchPage.clickUserTipBtn();
        searchPage.clickAppleWatchBtn();
        Assert.isTrue(expectedNameOfSearching.equals(searchPage.getTextSearchingResult()), "Steps dont work right");
    }

    @Then("UserTips -> AppleWatch -> verify results browse page")
    public void clickAppleWatchVerifyResultInBrowsePage() throws InterruptedException {
        String expectedNameOfSearching = "\"User Tips\" and \"Apple Watch\"";
        browsPage.clickUserTipBtn();
        browsPage.clickAppleWatchBtn();
        Assert.isTrue(expectedNameOfSearching.equals(browsPage.getTextSearchingResult()), "Steps dont work right");
    }

    @Then("People -> verify results search page")
    public void clickPeopleVerifyResultInSearchPage() {
        String expectedNameOfSearching = "\"People\"";
        searchPage.clickPeopleBtn();
        searchPage.peopleAvatar();
        Assert.isTrue(expectedNameOfSearching.equals(searchPage.getTextSearchingResult()), "Step click People dont work right");
    }

    @Then("Author -> verify results search page")
    public void clickAuthorVerifyResultInSearchPage() {
        searchPage.clickDiscussionsBtn();
        searchPage.clickAuthorBtn();
        Assert.isTrue(searchPage.searchByAuthorBtnIsVisible(), "Step click Author dont work right");
    }

    @Then("Time -> verify results search page")
    public void clickTimeVerifyResultInSearchPage() {
        String expectedNameOfSearching = "\"Discussions\" and \"Last day\"";
        searchPage.clickTimeBtn();
        Assert.isTrue(expectedNameOfSearching.equals(searchPage.getTextSearchingResult()), "Steps dont work right");
    }

    @When("Links should be functional")
    public void goThreadPage() {
        String threadName = browsPage.getThreadName();
        browsPage.clickThreadLinkAndSwitchTab();
        Assert.isTrue(threadName.equals(threadPage.getThreadName()), "Link is not working");
    }

    @Then("My Subscriptions button is displayed")
    public void my_subscriptions_button_is_displayed() {
        Assert.isTrue(userPage.mySubscriptionsBtnIsDisplayed(), "My Subscriptions button is not displayed");
    }

    @Then("Go in My Subscriptions")
    public void clickMySubscriptionsButton() {
        userPage.clickMySubscriptionsBtn();
    }

    @Then("Profile link is a functional")
    public void profileLinkFunctional() {
        String profileName = mySubscriptionsPage.getProfileName();
        mySubscriptionsPage.clickFirstProfileLink();
        String profilePageName = profilePage.getProfileName();
        Assert.isTrue(profileName.equals(profilePageName), "Profile link is not functional");
    }

    @Then("Browse button is displayed")
    public void browse_button_is_displayed() {
        Assert.isTrue(userPage.browseBtnIsDisplayed(), "Browse button is not displayed");
    }

    @Then("Search button is displayed")
    public void search_button_is_displayed() {
        Assert.isTrue(userPage.searchBtnIsDisplayed(), "Search button is not displayed");
    }

    @Then("Ask the Community button is displayed")
    public void post_question_button_is_displayed() {
        Assert.isTrue(userPage.askTheCommunityBtnIsDisplayed(), "Post Question button is not displayed");
    }

    @Then("Post User Tip button is displayed")
    public void post_user_tip_button_is_displayed() {
        Assert.isTrue(userPage.createTipBtnIsDisplayed(), "Post User Tip button is not displayed");
    }

    @Then("Post User Tip button is not displayed")
    public void post_user_tip_button_is_not_displayed() {
        Assert.isTrue(!userPage.createTipBtnIsDisplayed(), "Post User Tip button is displayed");
    }

    @Then("Lounge button is displayed")
    public void lounge_button_is_displayed() {
        Assert.isTrue(userPage.loungeLibelIsDisplayed(), "Lounge button is not displayed");
    }

    @Then("Lounge button is not displayed")
    public void lounge_button_is_not_displayed() {
        Assert.isTrue(!userPage.loungeLibelIsDisplayed(), "Lounge button is displayed");
    }

    @Then("Access Lounge Announcements")
    public void goLoungeAnnouncements() {
        userPage.clickLoungeBtn();
    }

    @Then("Try Access Lounge Announcements With Link")
    public void TryFindLoungeAnnouncementsWithLink() {
        int statusCode = requests.getStatusCode("https://discussions.apple.com/community/lounge/announcements");
        Assert.isTrue(statusCode == 404, "Page is accessible");
    }

    @Then("Per pages 20 should be functional in Browse page")
    public void check20PerPageBrowse() {
        browsPage.checkPerPageButton("20");
    }

    @Then("Per pages 60 should be functional in Browse page")
    public void check60PerPageBrowse() {
        browsPage.checkPerPageButton("60");
    }

    @Then("Per pages 20 should be functional in My Subscriptions")
    public void check20PerPageMySubscriptions() {
        mySubscriptionsPage.checkPerPageButton("20");
    }

    @Then("Per pages 60 should be functional in My Subscriptions")
    public void check60PerPageMySubscriptions() {
        mySubscriptionsPage.checkPerPageButton("60");
    }

    @Then("Try Access User Tip With Link")
    public void TryFindUserTipWithLink() {
        driver.get("https://discussions.apple.com/post/userTip");

        String expectedTitle = "Error - Access Denied - Apple Community";
        String currentTitle = driver.getTitle();

        Assert.isTrue(currentTitle.equals(expectedTitle), "Page is accessible");
    }

    @And("I go next page")
    public void iGoNextPage() {
        searchPage.clickNextBtn();
    }

    @Then("I am in page Two")
    public void iAmInPageTwo() throws InterruptedException {
        String pageNumberName = "Page 2";
        Assert.isTrue(pageNumberName.equals(searchPage.getPageNumberName()), "Button next no working");
    }

    @And("I go previous page")
    public void iGoPreviousPage() {
        searchPage.clickPreviousBtn();
    }

    @Then("I am in page One")
    public void iAmInPageOne() throws InterruptedException {
        String pageNumberName = "Page 1";
        Assert.isTrue(pageNumberName.equals(searchPage.getPageNumberName()), "Previous next no working");
    }

    @And("Link reply to work right")
    public void linkReplyToWorkRight() {
        String expectedName = searchPage.getReplyToBtnName();
        searchPage.clickReplyToBtn();
        Assert.isTrue(("Re: " + threadPage.getThreadName()).equals(expectedName), "ReplyTo no worked");
        driver.navigate().back();
    }

    @And("Link1 author name work right")
    public void link1AuthorNameWorkRight() {
        String expectedName = searchPage.getAuthorNameBtn1();
        searchPage.clickAuthorNameBtn1();
        String actualName = searchPage.getPopupUserName().replaceFirst("User profile information for user:\n", "");
        searchPage.clickPopupCloseBtn();
        Assert.isTrue(expectedName.equals(actualName), "Link 1 no worked");
    }

    @And("Link2 author name work right")
    public void link2AuthorNameWorkRight() {
        String expectedName = searchPage.getAuthorNameBtn2();
        searchPage.clickAuthorNameBtn2();
        String actualName = profilePage.getProfileName();
        driver.navigate().back();
        Assert.isTrue(expectedName.equals(actualName), "Link 2 no worked");
    }

    @And("Link where thread In work right")
    public void linkWhereThreadInWorkRight() {
        String expectedName = searchPage.getWhereInThreadBtnName();
        searchPage.clickWhereInThreadBtn();
        String actualName = communityPage.getCommunityName();
        driver.navigate().back();
        Assert.isTrue(expectedName.equals(actualName), "Link Where In no worked");

    }

//    @After
//    public void tearDown() {
//        driver.quit();
//    }
}
