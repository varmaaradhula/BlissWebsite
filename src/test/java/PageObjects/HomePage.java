package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    public WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    By servicesLink = By.xpath("//li[@id='menu-item-5551']/a");
    By ServicesList = By.xpath("//div[@class='grid-item-inner wow fadeInUp']/div[2]/h3");

    public void selectServices() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(servicesLink).click();
        Thread.sleep(5000);
    }

    public List<WebElement> getServiceList(){

        return driver.findElements(ServicesList);
    }
}
