package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import base.BasePage;

public class HomePage extends BasePage {
  public HomePage(WebDriver driver) {
	  super(driver);
  }
		
  //locators
  By create_lead_button = By.xpath("//button[.//div[normalize-space()='Create Lead']]");
  By add_view = By.xpath("//div[@id='add-view-button']");
  By view_name = By.xpath("//input[@id='viewName' and @placeholder='Enter view name']");
  By defaultview_checkbox = By.xpath("//label[@for='isDefaultView']");
  By sel_filter = By.xpath("//div[normalize-space()='Select filter']");
  By sel_condition = By.xpath("//div[normalize-space()='Select condition']");
  By sel_value = By.xpath("//button[@role='combobox' and contains(.,'Select value')]");
  By value = By.xpath("//li//span[normalize-space()='Trade Show']");
  By value2 = By.xpath("//li//span[normalize-space()='Negotiation']");
  By add_row = By.xpath("//button/img[@alt='Add filter']");
  By btn_create_view = By.xpath("//button[.//div[normalize-space()='Create View']]");
  By view = By.xpath("//div[contains(@class,'cursor-pointer')]//span[normalize-space()='adesh']");
  By view_more_btn = By.xpath("//img[@alt='More options']");
  By edit_view_btn = By.xpath("//img[@alt='Edit']");
  By edit_view_name = By.xpath("//input[@id='viewName']");
  By columns_btn = By.xpath("//div[@class='relative ']//button[@type='button']");
  By select_column = By.xpath("//div[contains(@class,'cursor-pointer')][.//div[normalize-space()='Lead ID']]");
  By save_changes_btn = By.xpath("//button//div[normalize-space()='Save Changes']");
  By Toast_message = By.xpath("//p[contains(text(),'already exists')]");
  Faker faker = new Faker();
  public void Handle_AddView(String name) throws InterruptedException {
	    wait.until(ExpectedConditions.elementToBeClickable(add_view)).click();
	    type(view_name,name);
	    click(btn_create_view);
	    WebElement Toast_msg = new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(Toast_message));
	    String error_msg = Toast_msg.getText();
	    if(error_msg!=null && error_msg.contains("already exists")) {
            Thread.sleep(5000);
	    	driver.findElement(view_name).sendKeys(Keys.CONTROL + "a");
	    	driver.findElement(view_name).sendKeys(Keys.DELETE);
	    	type(view_name,faker.name().fullName()+"'s view");
	    }
	       //click(defaultview_checkbox);
		    SelectFromFilter(sel_filter,"Source");
		    SelectFromFilter(sel_condition,"equals");
		    click(sel_value);
		    click(value);
		    WebElement input = driver.findElement(view_name);
		    String currentValue = input.getAttribute("value");

		    if (currentValue == null || currentValue.trim().isEmpty()) {
		        input.clear();
		        input.sendKeys(faker.name().firstName() + "'s view");
		    }
	    	click(add_row);
		    SelectFromFilter(sel_filter,"Status");
		    SelectFromFilter(sel_condition,"equals");
		    click(sel_value);
		    click(value2);
		    driver.findElement(By.tagName("body")).click();
		    click(btn_create_view);
            pause();
        }
  public void create_view() throws InterruptedException {
	    wait.until(ExpectedConditions.elementToBeClickable(add_view)).click();
	    type(view_name,faker.name().lastName()+"'s view");
	       //click(defaultview_checkbox);
		    SelectFromFilter(sel_filter,"Source");
		    SelectFromFilter(sel_condition,"equals");
		    click(sel_value);
		    click(value);
	    	click(add_row);
		    SelectFromFilter(sel_filter,"Status");
		    SelectFromFilter(sel_condition,"equals");
		    click(sel_value);
		    click(value2);
		    driver.findElement(By.tagName("body")).click();
		    click(btn_create_view);
          pause();
  }

   public void edit_view() throws InterruptedException {
	   wait.until(ExpectedConditions.visibilityOfElementLocated(view));
	   Actions actions = new Actions(driver);
	   actions.moveToElement(driver.findElement(view)).perform();
	   click(view_more_btn);
	   click(edit_view_btn);
	   click(columns_btn);
	   click(select_column);
	   driver.findElement(By.xpath("//h2[text()='Edit View']")).click();
	   click(save_changes_btn);
	   pause();
   }
}