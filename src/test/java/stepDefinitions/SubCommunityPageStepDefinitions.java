package stepDefinitions;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.SubCommunityPage;
import pages.ThreadPage;

public class SubCommunityPageStepDefinitions {

   SubCommunityPage subCommunityPage = CommonStepDefinitions.subCommunityPage;
    ThreadPage threadPage = CommonStepDefinitions.threadPage;
    @And("Link name author is functional sub community page")
    public void linkNameAuthorClickIsFunctionalSubCommunityPage() {
        String expectedName = subCommunityPage.getButtonText(SubCommunityPage.Button.AuthorName);
        subCommunityPage.clickButton(SubCommunityPage.Button.AuthorName);
        String actualName = subCommunityPage.getButtonText(SubCommunityPage.Button.PopupUserName).replaceFirst("User profile information for user:\n", "");
        subCommunityPage.clickButton(SubCommunityPage.Button.PopupClose);
        Assert.isTrue(expectedName.equals(actualName), "Link author name no worked");
    }

    @Then("Link icon author is functional sub community page")
    public void linkIconAuthorClickIsFunctionalSubCommunityPage() {
        String expectedName = subCommunityPage.getButtonText(SubCommunityPage.Button.AuthorName);
        subCommunityPage.clickButton(SubCommunityPage.Button.AuthorIcon);
        String actualName = subCommunityPage.getButtonText(SubCommunityPage.Button.PopupUserName).replaceFirst("User profile information for user:\n", "");
        subCommunityPage.clickButton(SubCommunityPage.Button.PopupClose);
        Assert.isTrue(expectedName.equals(actualName), "Link icon no worked");
    }

    @Then("Link thread name is functional sub community page")
    public void linkThreadNameIsFunctionalSubCommunityPage() {
        String expectedThreadName = subCommunityPage.getButtonText(SubCommunityPage.Button.ThreadName);
        subCommunityPage.clickButton(SubCommunityPage.Button.ThreadName);
        String actualTreadName = threadPage.getThreadName();
        Assert.isTrue(actualTreadName.equals(expectedThreadName), "Link is no functional");
    }
}
