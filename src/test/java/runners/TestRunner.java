package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepDefinitions",
        tags = "@Login or @Navigation or @Cart or @Checkout",
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt" // Re-run failed scenarios
        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
