package stepDefinitions;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.*;

public class SearchPageStepDefinitions {
    WebDriver driver;
    SearchPage searchPage;
    SubCommunityPage subCommunityPage;
    ThreadPage threadPage;
    ProfilePage profilePage;

    @When("I click filter button in search page")
    public void clickFilterInSearchPage() {
        searchPage.clickButton(SearchPage.Button.FilterButton);
    }

    @Then("People -> verify results search page")
    public void clickPeopleVerifyResultInSearchPage() {
        String expectedNameOfSearching = "\"People\"";
        searchPage.clickButton(SearchPage.Button.PeopleButton);
        searchPage.peopleAvatar();
        Assert.isTrue(expectedNameOfSearching.equals(searchPage.getButtonText(SearchPage.Button.FilteredByText)), "Step click People dont work right");
    }

    @Then("Author -> verify results search page")
    public void clickAuthorVerifyResultInSearchPage() {
        searchPage.clickButton(SearchPage.Button.DiscussionsButton);
        searchPage.waitButtonVisibility();
        searchPage.clickButton(SearchPage.Button.AuthorButton);
        Assert.isTrue(searchPage.searchByAuthorBtnIsVisible(), "Step click Author dont work right");
    }

    @Then("Time -> verify results search page")
    public void clickTimeVerifyResultInSearchPage() {
        String expectedNameOfSearching = "\"Discussions\" and \"Last day\"";
        searchPage.clickButton(SearchPage.Button.TimeButton);
        searchPage.clickButton(SearchPage.Button.DayButton);
        Assert.isTrue(expectedNameOfSearching.equals(searchPage.getButtonText(SearchPage.Button.FilteredByText)), "Steps dont work right");
    }

    @Then("UserTips -> AppleWatch -> verify results search page")
    public void clickAppleWatchVerifyResultInSearchPage() throws InterruptedException {
        String expectedNameOfSearching = "\"User Tips\" and \"Apple Watch\"";
        searchPage.waitButtonVisibility();
        searchPage.clickButton(SearchPage.Button.UserTipsButton);
        searchPage.clickAppleWatchBtn();
        Assert.isTrue(expectedNameOfSearching.equals(searchPage.getButtonText(SearchPage.Button.FilteredByText)), "Steps dont work right");
    }

    @Then("Discussions -> Solved -> iPhone -> verify results search page")
    public void clickIPhoneVerifyResultInSearchPage() throws InterruptedException {
        String expectedNameOfSearching = "\"Discussions\", \"Solved questions\" and \"iPhone\"";
        searchPage.clickButton(SearchPage.Button.DiscussionsButton);
        searchPage.waitButtonVisibility();
        searchPage.clickSolvedBtn();
        searchPage.clickButton(SearchPage.Button.CommunityButton);
        searchPage.clickButton(SearchPage.Button.IPhoneButton);
        Assert.isTrue(expectedNameOfSearching.equals(searchPage.getButtonText(SearchPage.Button.FilteredByText)), "Steps dont working right");
    }

    @Then("Discussions -> UnSolved -> iPad -> verify results search page")
    public void clickIPadVerifyResultInSearchPage() throws InterruptedException {
        String expectedNameOfSearching = "\"Discussions\", \"Unsolved questions\" and \"iPad\"";
        Thread.sleep(4000);
        searchPage.clickButton(SearchPage.Button.DiscussionsButton);
        searchPage.waitButtonVisibility();
        searchPage.clickUnSolvedBtn();
        searchPage.clickButton(SearchPage.Button.CommunityButton);
        searchPage.clickButton(SearchPage.Button.IPadButton);
        Assert.isTrue(expectedNameOfSearching.equals(searchPage.getButtonText(SearchPage.Button.FilteredByText)), "Steps dont work right");
    }

    @When("I go {string} page")
    public void iGoPage(String buttonName) {
        searchPage.clickButton(SearchPage.Button.valueOf(buttonName));
    }

    @Then("I should be in {string}")
    public void iShouldBeIn(String pageName) throws InterruptedException {
        Assert.isTrue(pageName.equals(searchPage.getPageNumberName()), "Button no working");
    }

    @And("Link reply to work right search page")
    public void linkReplyToWorkRightSearchPage() {
        String expectedName = searchPage.getButtonText(SearchPage.Button.NameReplyToButton);
        searchPage.clickButton(SearchPage.Button.NameReplyToButton);
        Assert.isTrue(("Re: " + threadPage.getThreadName()).equals(expectedName), "ReplyTo no worked");
        driver.navigate().back();
    }

    @And("Link1 author name work right search page")
    public void link1AuthorNameWorkRightSearchPage() {
        String expectedName = searchPage.getButtonText(SearchPage.Button.AuthorNameButton1);
        searchPage.clickButton(SearchPage.Button.AuthorNameButton1);
        String actualName = searchPage.getButtonText(SearchPage.Button.PopupUserName).replaceFirst("User profile information for user:\n", "");
        searchPage.clickButton(SearchPage.Button.PopupClose);
        Assert.isTrue(expectedName.equals(actualName), "Link 1 no worked");
    }

    @And("Link2 author name work right search page")
    public void link2AuthorNameWorkRightSearchPage() {
        String expectedName = searchPage.getButtonText(SearchPage.Button.AuthorNameButton2);
        searchPage.clickButton(SearchPage.Button.AuthorNameButton2);
        String actualName = profilePage.getProfileName();
        driver.navigate().back();
        Assert.isTrue(expectedName.equals(actualName), "Link 2 no worked");
    }

    @And("Link sub community button right search page")
    public void linkSubCommunityButtonRightSearchPage() {
        String expectedName = searchPage.getButtonText(SearchPage.Button.SubCommunityButton);
        searchPage.clickButton(SearchPage.Button.SubCommunityButton);
        String actualName = subCommunityPage.getButtonText(SubCommunityPage.Button.CommunityName);
        driver.navigate().back();
        Assert.isTrue(expectedName.equals(actualName), "Link Sub Community In no worked");
    }
}
