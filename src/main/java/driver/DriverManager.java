package driver;

import io.appium.java_client.AppiumDriver;

public class DriverManager {
    // Class for managing driver initialization and quite
    private static AppiumDriver driver;

    public static void init(){
        driver = DriverFactory.createDriver();
    }

    public static AppiumDriver getDriver(){
        return driver;
    }

    public static void quit(){
        if(driver != null){
            driver.quit();
        }
    }
}