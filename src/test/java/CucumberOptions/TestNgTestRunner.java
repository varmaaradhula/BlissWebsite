package CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@CucumberOptions(features = "src/test/java/Features", glue = "StepDefinitions", monochrome = true, dryRun = true)
@CucumberOptions(features = "src/test/java/Features", glue = "StepDefinitions", monochrome = true,
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class TestNgTestRunner extends AbstractTestNGCucumberTests {

}
