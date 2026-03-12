package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

import utils.ConfigReader;

public class DriverFactory {

    public static AppiumDriver createDriver() {

        AppiumDriver driver = null;

        try {
            // Get information from a config file, and create the desired driver
            String platform = ConfigReader.get("platform");

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("appium:deviceName", ConfigReader.get("deviceName"));
            caps.setCapability("appium:app", ConfigReader.get("appPath"));

            if(platform.equalsIgnoreCase("Android")){

                caps.setCapability("platformName","Android");
                caps.setCapability("automationName","UiAutomator2");

                driver = new AndroidDriver(
                        new URL("http://127.0.0.1:4723"),
                        caps
                );

            } else if (platform.equalsIgnoreCase("iOS")){

                caps.setCapability("platformName","iOS");
                caps.setCapability("automationName","XCUITest");

                driver = new IOSDriver(
                        new URL("http://127.0.0.1:4723"),
                        caps
                );

            }

        } catch(Exception e){
            e.printStackTrace();
        }

        return driver;
    }
}