package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utils.ConfigReader;

public class BaseTest {
    protected WebDriver driver;
    @BeforeClass
    public void setup() throws InterruptedException {
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--force-device-scale-factor=0.95");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
     //   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfigReader.get("url"));
    }

  /*  @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    */
    
}
