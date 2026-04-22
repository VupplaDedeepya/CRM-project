package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class demo {
	   WebDriver driver;
	   WebDriverWait wait;
	   @Test(priority=1)
	   void fun() throws InterruptedException{
		   driver = new ChromeDriver();
		   wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		   driver.get("https://dev-app.dev.salesastra-nonprod.com/");
		   driver.manage().window().maximize();
		   driver.findElement(By.xpath("//input[@placeholder='Enter your email']")).sendKeys("ballasaikumar.qa@gmail.com");
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys("Saikumar@123");
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("//div[@class='relative inline-block w-full']/child::button")).click();
		   Thread.sleep(2000);
		   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Next']"))).click();
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Full Name']")));
		   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='LEAD-1011']/ancestor::tr/td[2]"))).click();
		   Actions actions = new Actions(driver);
		   WebElement salutation = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[normalize-space()='Salutation']//parent::div)//child::div")));
		   actions.doubleClick(salutation).perform();
		   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'custom-react-select__option') and contains(text(),'Dr')]"))).click();
		   Thread.sleep(2000);
		   //email
		   Faker faker = new Faker();
		   driver.findElement(By.xpath("(//span[normalize-space()='Email']//parent::div)//child::div")).click();
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Email']//following-sibling::input")));
		   driver.findElement(By.xpath("//span[normalize-space()='Email']//following-sibling::input")).sendKeys(Keys.CONTROL+"a");
		   driver.findElement(By.xpath("//span[normalize-space()='Email']//following-sibling::input")).sendKeys(Keys.DELETE);
		   driver.findElement(By.xpath("//span[normalize-space()='Email']//following-sibling::input")).sendKeys(faker.internet().emailAddress());
		   driver.findElement(By.xpath("//span[normalize-space()='Email']//following-sibling::input")).sendKeys(Keys.ENTER);
		   Thread.sleep(2000);
		   //contact
		   driver.findElement(By.xpath("(//span[normalize-space()='Contact Number']//parent::div)//child::button")).click();
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Phone number']"))).sendKeys(Keys.CONTROL+"a");
		   driver.findElement(By.xpath("//input[@placeholder='Phone number']")).sendKeys(Keys.DELETE);
		   driver.findElement(By.xpath("//input[@placeholder='Phone number']")).sendKeys("7890578890");
		   driver.findElement(By.xpath("//button[.//div[contains(text(),'Save')]]")).click();
		   Thread.sleep(2000);	
		   driver.findElement(By.xpath("(//span[normalize-space()='Contact Number']//parent::div)//child::button")).click();
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Phone number']"))).sendKeys(Keys.CONTROL+"a");
		   driver.findElement(By.xpath("//input[@placeholder='Phone number']")).sendKeys(Keys.DELETE);
		   driver.findElement(By.xpath("//input[@placeholder='Phone number']")).sendKeys("7890578890");
		   driver.findElement(By.xpath("//button[.//div[contains(text(),'Save')]]")).click();
		   Thread.sleep(2000);
		   //preffered channel
		   WebElement preferred_channel_dd = driver.findElement(By.xpath("(//span[normalize-space()='Preferred Channel']//parent::div)//child::div"));
		   actions.doubleClick(preferred_channel_dd).perform();
		   driver.findElement(By.xpath("//div[contains(@class,'custom-react-select__option') and contains(text(),'SMS')]")).click();
		   //website
		   driver.findElement(By.xpath("(//span[normalize-space()='Website']//parent::div)//child::div")).click();
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[normalize-space()='Website']//parent::div)//child::input")));
		   driver.findElement(By.xpath("(//span[normalize-space()='Website']//parent::div)//child::input")).sendKeys(Keys.CONTROL+"a");
		   driver.findElement(By.xpath("(//span[normalize-space()='Website']//parent::div)//child::input")).sendKeys(Keys.DELETE);
		   driver.findElement(By.xpath("(//span[normalize-space()='Website']//parent::div)//child::input")).sendKeys("https://website.com");
		   Thread.sleep(2000);
		   
	   }
}
