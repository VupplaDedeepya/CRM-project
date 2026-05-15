package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import utils.ConfigReader;
import utils.ExcelReportGenerator;
import utils.SendMail;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void setup() throws InterruptedException {
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--force-device-scale-factor=0.95");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
     //   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfigReader.get("url"));	
    }
    
    
   
    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
           
        }
    }
   

    
}
