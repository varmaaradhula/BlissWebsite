package StepDefinitions;

import Utils.TestContextSetUp;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Hooks {

    public TestContextSetUp contextSetUp;

    public Hooks(TestContextSetUp contextSetUp){

        this.contextSetUp = contextSetUp;
    }

    @After
    public void closeBrowser() throws IOException {
        contextSetUp.baseTest.webDriverManager().quit();
    }
}
