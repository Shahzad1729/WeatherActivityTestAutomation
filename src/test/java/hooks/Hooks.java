package hooks;

import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    // Creating a driver
    @Before
    public void setup(){

        DriverManager.init();
    }

    // Quiting driver
    @After
    public void teardown(){

        DriverManager.quit();
    }
}