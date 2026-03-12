package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class DashboardPage extends BasePage{

    @AndroidFindBy(accessibility = "activity_search_btn")
    @iOSXCUITFindBy(accessibility = "activity_search_btn")
    WebElement activityScreenBtn;

    // from dashboard go to activity search screen by clicking on button
    public void openActivitySearchScreen(){
        WaitUtils.waitForVisibility(activityScreenBtn).click();
    }
}
