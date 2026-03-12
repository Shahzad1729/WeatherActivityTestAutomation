package stepdefinitions;

import io.cucumber.java.en.*;
import pages.DashboardPage;
import pages.SearchPage;
import pages.ActivityPage;

import org.testng.Assert;

public class ActivitySteps {

    SearchPage searchPage = new SearchPage();
    ActivityPage activityPage = new ActivityPage();
    DashboardPage dashboardPage=new DashboardPage();

    @Given("user opens activity search screen")
    public void openActivitySearchScreen() {
        dashboardPage.openActivitySearchScreen();
    }

    @When("user types city {string}")
    public void typeCity(String city){
        searchPage.enterCity(city);
    }

    @Given("user selects city {string}")
    public void userSelectsCity(String city) {

        searchPage.enterCity(city);
        searchPage.selectFirstSuggestion();
    }

    @When("user selects first suggestion")
    public void selectSuggestion(){
        searchPage.selectFirstSuggestion();
    }


    @Then("each day should show {string},{string},{string},{string}")
    public void eachDayShouldShow(String date,String activity,String rank,String reason) {
        boolean result = activityPage.verifyWeatherInformationOfGivenDay(
                date,
                activity,
                rank,
                reason
        );
        Assert.assertTrue(result, "Weather information is incorrect!");
    }

    @Then("no suggestions should be displayed")
    public void noSuggestionsShouldBeDisplayed() {
        Assert.assertTrue(searchPage.noSuggestionsVisible());
    }

    @Then("autocomplete suggestions should appear")
    public void autocompleteSuggestionsShouldAppear() {
        Assert.assertTrue(searchPage.areSuggestionsDisplayed());
    }

    @Then("ranked activities for 7 days should be displayed")
    public void verifyActivities(){
        Assert.assertTrue(activityPage.isActivityDisplayed());
    }
}