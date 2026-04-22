package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
  protected WebDriver driver;
  protected WebDriverWait wait;
  public BasePage(WebDriver driver){
	   this.driver = driver;
	   this.wait = new WebDriverWait(driver,Duration.ofSeconds(20));
  }
  public void click(By element) throws InterruptedException {
	  wait.until(ExpectedConditions.elementToBeClickable(element));
	  driver.findElement(element).click();
	  pause();
  }
  public void type(By element,String text ) throws InterruptedException {
	   wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	   driver.findElement(element).sendKeys(text);
	   pause();
  }
  public void selectFromDropdown(By dropdown, String value) throws InterruptedException {
	    for (int i = 0; i < 3; i++) {
	        try {
	            // Step 1: Click dropdown
	            WebElement dd = wait.until(ExpectedConditions.elementToBeClickable(dropdown));
	            dd.click();

	            // Step 2: Wait for options container (IMPORTANT)
	            wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//div[contains(@class,'custom-react-select__menu')]")
	            ));

	            // Step 3: Use CONTAINS instead of exact match
	            By option = By.xpath(
	                "//div[contains(@class,'custom-react-select__option') and contains(normalize-space(),'" + value + "')]"
	            );

	            WebElement opt = wait.until(ExpectedConditions.elementToBeClickable(option));
	            opt.click();

	            break;

	        } catch (Exception e) {
	            System.out.println("Retrying dropdown selection...");
	            e.printStackTrace();
	        }
	        
	    }
	    pause();
	}
  public void SelectFromFilter(By element,String value) throws InterruptedException {
	    for (int i = 0; i < 3; i++) {
	        try {
	            WebElement dd = wait.until(ExpectedConditions.elementToBeClickable(element));
	            dd.click();

	            wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//div[contains(@class,'custom-filter-scrollbar')]")
	            ));

	            By option = By.xpath(
	            	    "//div[contains(@class,'cursor-pointer')][.//div[normalize-space()='" + value + "']]"
	            	);

	            wait.until(ExpectedConditions.elementToBeClickable(option)).click();
	            break;

	        } catch (Exception e) {
	            System.out.println("Retrying dropdown selection...");
	        }
	    }
	    pause();
}
  int delay = 1000; // normal
  public void pause() {
	    try {
	        Thread.sleep(delay);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
  public WebElement getLeadRowData(String leadId, String value) {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

      By locator = By.xpath(
          "//tr[.//span[contains(normalize-space(),'" + leadId + "')]]//span[contains(normalize-space(),'" + value + "')]"
      );

      return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }
  
}
