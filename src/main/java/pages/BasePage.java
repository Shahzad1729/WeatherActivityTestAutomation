package pages;

import driver.DriverManager;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class BasePage {
    // BasePage class for initializing the PageFactory elements, in child classes
    public BasePage(){
        PageFactory.initElements(
                new AppiumFieldDecorator(
                        DriverManager.getDriver(),
                        Duration.ofSeconds(6)),
                this
        );
    }
}