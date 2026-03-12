package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

import java.util.List;

public class SearchPage extends BasePage{

    // Search Input field
    @AndroidFindBy(accessibility = "citySearchInput")
    @iOSXCUITFindBy(accessibility = "citySearchInput")
    WebElement searchField;

    // Suggestions
    @AndroidFindBy(accessibility = "citySuggestion")
    @iOSXCUITFindBy(accessibility = "citySuggestion")
    List<WebElement> suggestions;

    // Enter city in Search field
    public void enterCity(String city){
        WaitUtils.waitForVisibility(searchField)
                .sendKeys(city);
        WaitUtils.waitForListToLoad(suggestions);
    }

    // Click on the first suggestion displayed
    public void selectFirstSuggestion(){
        WaitUtils.waitForListToLoad(suggestions);
        suggestions.get(0).click();
    }

    // check if suggestions displayed or not
    public boolean areSuggestionsDisplayed(){
        WaitUtils.waitForListToLoad(suggestions);
        return !suggestions.isEmpty();
    }

    // no suggestions there
    public boolean noSuggestionsVisible(){
        return suggestions.isEmpty();
    }
}