package Utils;

import org.openqa.selenium.WebDriver;

public class Utilities {

    public WebDriver driver;

    public Utilities(WebDriver driver){
        this.driver = driver;
    }

    public String getpageTitle(){
        return driver.getTitle();
    }
}
