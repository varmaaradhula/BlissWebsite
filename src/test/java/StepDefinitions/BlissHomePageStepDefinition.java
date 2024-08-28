package StepDefinitions;

import PageObjects.HomePage;
import Utils.TestContextSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class BlissHomePageStepDefinition {
public WebDriver driver;
public TestContextSetUp testContext;
public HomePage homePage;
public BlissHomePageStepDefinition(TestContextSetUp testContext){
    this.testContext = testContext;
    this.homePage = testContext.pageObjectmanger.getHomePage();
}
    @Given("User is on Bliss Software solutions Home page")
    public void user_is_on_bliss_software_solutions_home_page() {
    String pageTitle = testContext.utils.getpageTitle();
        System.out.println(pageTitle);
    Assert.assertTrue(pageTitle.contains("blisssoftware"));
    }
    @When("User selects Services Option")
    public void user_selects_services_option() throws InterruptedException {
        homePage.selectServices();
    }
    @Then("User find the services {string} offered by Bliss")
    public void user_find_the_services_offered_by_bliss(String serviceName) {
        List<WebElement> services = homePage.getServiceList();
        Assert.assertTrue(services.stream().anyMatch(s->s.getText().contains(serviceName)));
    }
    @Then("User can select {string} service")
    public void user_can_select_service(String serviceName) {
        List<WebElement> services = homePage.getServiceList();
      WebElement service = services.stream().filter(s->s.getText().equals(serviceName)).findFirst().orElse(null);
      Assert.assertTrue(service.isEnabled());
    }

}
