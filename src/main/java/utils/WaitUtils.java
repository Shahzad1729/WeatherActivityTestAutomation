package utils;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitUtils {

    private static WebDriverWait getWait(){

        return new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(10)
        );
    }

    public static WebElement waitForVisibility(WebElement locator) {

        return getWait().until(
                ExpectedConditions.visibilityOf(locator)
        );
    }

    public static WebElement waitForClickable(WebElement locator) {

        return getWait().until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }

    public static void  waitForListToLoad(List<WebElement> elements) {

        getWait().until(driver -> !elements.isEmpty());
    }

    public static boolean waitForInvisibility(WebElement locator) {

        return getWait().until(
                ExpectedConditions.invisibilityOf(locator)
        );
    }
}