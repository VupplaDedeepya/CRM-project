package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class ListingDetailsUpdatePage extends BasePage {
   public ListingDetailsUpdatePage(WebDriver driver) {
	   super(driver);	   
   }
   //Leadowner dropdown
   
   By LeadOwner_dd =  By.xpath("//tr[.//span[contains(text(),'LEAD-0970')]]//span[normalize-space()='sai kumar']");
   By LeadOption = By.xpath("//div[@class='custom-filter-scrollbar']//div[contains(@class,'cursor-pointer') and normalize-space()='Sriharsha S']");
   //tags dropdown
   By tags_dd = By.xpath("(//tr[.//span[contains(text(),'LEAD-0970')]]//span[normalize-space()='-'])[1]");
   By tag_option = By.xpath("//div[@class='custom-filter-scrollbar']//div[contains(@class,'cursor-pointer') and normalize-space()='Heat leads']");
   //reusable method
   public void DoubleClick(String LeadId,String value,String option) throws InterruptedException {
 	 
 	  Actions actions = new Actions(driver);
 	  By dd = By.xpath("//tr[.//span[contains(text(),'"+LeadId+"')]]//span[contains(@title,'"+value+"')]");
 	  wait.until(ExpectedConditions.visibilityOfElementLocated(dd));
 	  By opt = By.xpath("//div[@class='custom-filter-scrollbar']//div[contains(@class,'cursor-pointer') and normalize-space()='" + option + "']");
 	  actions.doubleClick(driver.findElement(dd)).perform();
 	  //Thread.sleep(2000);
 	  click(opt);
 	  Thread.sleep(2000);
   }
   //reusable method 2
   public void EnterValue(String LeadId,String text,String placeholder,String val ) throws InterruptedException {
 	  By txt_box = By.xpath("//tr[.//span[contains(text(),'"+LeadId+"')]]//span[contains(text(),'"+text+"')]");
 	    wait.until(ExpectedConditions.visibilityOfElementLocated(txt_box));

 	    driver.findElement(txt_box).click();

 	    By input = By.xpath("//input[@placeholder='"+placeholder+"']");
 	    WebElement inputBox = wait.until(ExpectedConditions.visibilityOfElementLocated(input));
         Thread.sleep(2000);
         // Better way to clear (important)
 	    inputBox.sendKeys(Keys.CONTROL + "a");
 	    inputBox.sendKeys(Keys.DELETE);
 	    inputBox.sendKeys(val);
 	    // ✅ IMPORTANT: trigger blur (save)
 	    inputBox.sendKeys(Keys.ENTER);
         Thread.sleep(3000);
   }
   //action methods
   public void changeStatusFromListing() throws InterruptedException {
		 DoubleClick("LEAD-0970","New","Contacted");
	  }
	  public void changeSourceFromListing() throws InterruptedException {
		  DoubleClick("LEAD-0970","Email Campaign","Trade Show");
	  }
	  public void changePrefferedChannelFromListing() throws InterruptedException {
		  DoubleClick("LEAD-0970","Email","Phone");
	  }
	  public void leadOwner() throws InterruptedException {
		  wait.until(ExpectedConditions.visibilityOfElementLocated(LeadOwner_dd));
		  Actions actions = new Actions(driver);
		  actions.doubleClick(driver.findElement(LeadOwner_dd)).perform();
		  click(LeadOption);
	  }
	  public void tags() throws InterruptedException {
		  wait.until(ExpectedConditions.visibilityOfElementLocated(tags_dd));
		  Actions actions = new Actions(driver);
		  actions.doubleClick(driver.findElement(tags_dd)).perform();
		  click(tag_option);
		  Thread.sleep(2000);
	  }
	  public void textChanges() throws InterruptedException {
		  
		  EnterValue("LEAD-0970","mail.com","Enter email address","pavan@yopmail.com");
		  EnterValue("LEAD-0970","+91","e.g., +91 1234567890","+91 9056784578");
		  pause();
		  pause();
	  }
}
