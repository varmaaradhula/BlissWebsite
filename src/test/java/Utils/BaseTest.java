package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    public WebDriver webDriverManager() throws IOException {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/Resources/global.properties");
        properties.load(fis);

        if(driver==null) {
            DesiredCapabilities caps = new DesiredCapabilities();
            if (properties.getProperty("browser").equals("chrome")) {
                //driver = new ChromeDriver();
                caps.setBrowserName("chrome");
                driver = new RemoteWebDriver(new URL("http://localhost:4444"),caps);
            } else if (properties.getProperty("browser").equals("firefox")) {
                caps.setBrowserName("firefox");
                driver = new RemoteWebDriver(new URL("http://localhost:4444"),caps);
                //driver = new FirefoxDriver();
            } else if (properties.getProperty("browser").equals("edge")) {
                //driver = new EdgeDriver();
                caps.setBrowserName("EDGE");
                driver = new RemoteWebDriver(new URL("http://localhost:4444"),caps);
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get("https://blisssoftwaresolutions.co.uk/");
        }
        return driver;

    }
}
