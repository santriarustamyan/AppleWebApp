package stepDefinitions;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.*;

public class MySubsPageStepDefinitions {

    HomePage homePage;
    MySubscriptionsPage mySubscriptionsPage;
    ProfilePage profilePage;
    @Given("I click filter button in my subscriptions page")
    public void iClickFilterButtonInMySubscriptionsPage() {
        mySubscriptionsPage.clickButton(MySubscriptionsPage.Button.FilterButton);
    }

    @Then("Click user tips verify results my subscriptions page")
    public void clickUserTipsVerifyResultsMySubscriptionsPage() {
        String expectedName = "\"Content\", \"Following\" and \"User Tips\"";
        mySubscriptionsPage.clickButton(MySubscriptionsPage.Button.UserTipsButton);
        mySubscriptionsPage.waitButtonClickable(MySubscriptionsPage.Button.AuthorNameButton1);
        String actualName = mySubscriptionsPage.getButtonText(MySubscriptionsPage.Button.FilteredByText);
        Assert.isTrue(expectedName.equals(actualName), "Filter User Tips no working");
    }

    @Then("Latest activity button is functional in My Subscriptions")
    public void latestActivityButtonIsFunctionalInMySubscriptions() {
        String expectedAttributeName = "icon icon-after icon-chevrondown";
        mySubscriptionsPage.clickButton(MySubscriptionsPage.Button.TopicsLatestActivityButton);
        mySubscriptionsPage.waitButtonClickable(MySubscriptionsPage.Button.TopicsLatestActivityButton);
        String actualAttributeName = mySubscriptionsPage.getButtonAttributeText(MySubscriptionsPage.Button.TopicsLatestActivitySpanButton, "class");
        Assert.isTrue(expectedAttributeName.equals(actualAttributeName), "Activity button no functional");
    }

    @And("Thread button is functional in My Subscriptions")
    public void threadButtonIsFunctionalInMySubscriptions() {
        String expectedAttributeName = "icon icon-after icon-chevrondown";
        mySubscriptionsPage.clickButton(MySubscriptionsPage.Button.TopicsThreadButton);
        mySubscriptionsPage.waitButtonClickable(MySubscriptionsPage.Button.TopicsThreadButton);
        String actualAttributeName = mySubscriptionsPage.getButtonAttributeText(MySubscriptionsPage.Button.TopicsThreadButtonSpan, "class");
        Assert.isTrue(expectedAttributeName.equals(actualAttributeName), "Activity button no functional");
    }

    @And("Community button is functional in My Subscriptions")
    public void communityButtonIsFunctionalInMySubscriptions() {
        String expectedAttributeName = "icon icon-after icon-chevrondown";
        mySubscriptionsPage.clickButton(MySubscriptionsPage.Button.TopicsCommunityButton);
        mySubscriptionsPage.waitButtonClickable(MySubscriptionsPage.Button.TopicsCommunityButton);
        String actualAttributeName = mySubscriptionsPage.getButtonAttributeText(MySubscriptionsPage.Button.TopicsCommunitySpanButton, "class");
        Assert.isTrue(expectedAttributeName.equals(actualAttributeName), "Activity button no functional");
    }

    @Then("Per pages {string} should be functional in My Subscriptions")
    public void perPagesShouldBeFunctionalInMySubscriptions(String countPage) {
        mySubscriptionsPage.checkPerPageButton(countPage);
    }

    @Then("Profile link is a functional")
    public void profileLinkFunctional() {
        String profileName = mySubscriptionsPage.getButtonText(MySubscriptionsPage.Button.NameProfile);
        mySubscriptionsPage.clickButton(MySubscriptionsPage.Button.NameProfile);
        homePage.switchTab(1);
        String profilePageName = profilePage.getProfileName();
        Assert.isTrue(profileName.equals(profilePageName), "Profile link is not functional");
    }

}
