package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.ConfigReader;
import utils.WaitUtils;

import java.util.List;

public class ActivityPage extends BasePage{

    // Table row locator
    @AndroidFindBy(id = "com.app:id/table_row")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell")
    List<WebElement> activityTableRow;

    // check if activity is displayed (consider table is displaying that contains day wise weather info
    public boolean isActivityDisplayed(){
        WaitUtils.waitForListToLoad(activityTableRow);
        return activityTableRow.get(0)
                .isDisplayed();
    }

    // Get weather information of given day
    public boolean verifyWeatherInformationOfGivenDay(String day, String expectedActivity, String expectedRank, String expectedReason)
    {
        WaitUtils.waitForListToLoad(activityTableRow);
        for(WebElement row : activityTableRow){
            List<WebElement> columns;
            if(ConfigReader.get("platform").equalsIgnoreCase("Android")) {
                columns = row.findElements(By.className("android.widget.TextView"));
            }
            else {
                columns = row.findElements(By.className("XCUIElementTypeStaticText"));
            }
            String date = columns.get(0).getText();
            String activity = columns.get(1).getText();
            String rank = columns.get(2).getText();
            String reason = columns.get(3).getText();

            if(date.equalsIgnoreCase(day)){
                return activity.equalsIgnoreCase(expectedActivity)
                        && rank.equalsIgnoreCase(expectedRank)
                        && reason.equalsIgnoreCase(expectedReason);
            }
        }

        return false;
    }
}