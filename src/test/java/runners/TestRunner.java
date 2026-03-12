package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// provided features, steps, and tag for a scenario to run, using cucumber reporting
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions"},
        tags = "@sanity",
        plugin = {
                "pretty",
                "html:target/report.html"
        }
)

public class TestRunner extends AbstractTestNGCucumberTests {
}