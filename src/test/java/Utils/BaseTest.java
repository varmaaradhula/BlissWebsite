package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    public WebDriver webDriverManager() throws IOException {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/Resources/global.properties");
        properties.load(fis);

        if(driver==null) {
            if (properties.getProperty("browser").equals("chrome")) {
                driver = new ChromeDriver();
            } else if (properties.getProperty("browser").equals("firefox")) {
                driver = new FirefoxDriver();
            } else if (properties.getProperty("browser").equals("edge")) {
                driver = new EdgeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get("https://blisssoftwaresolutions.co.uk/");
        }
        return driver;

    }
}
