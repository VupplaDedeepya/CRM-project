package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.github.javafaker.Faker;

import base.BasePage;

public class EditLeadPage extends BasePage{
    public EditLeadPage(WebDriver driver) {
    	super(driver);
    }
    //locators
    By Edit_btn = By.xpath("//button//img[@alt='Edit']");
    By update_lead_btn = By.xpath("//button//div[normalize-space()='Update Lead']");
    LeadFormPage lfp = new LeadFormPage(driver);
    Faker faker = new Faker();
    //Action methods
    public void chooserow() {
    	getLeadRowData("LEAD-0976","Meghana").click();
    	pause();
    }
    public void basicDetails() throws InterruptedException {
     	wait.until(ExpectedConditions.visibilityOfElementLocated(Edit_btn)).click();
     	pause();
   	 wait.until(ExpectedConditions.visibilityOfElementLocated(lfp.label));
   	 //click prefix dropdown
   	 click(lfp.prefix_dropdown);
   	 //select option
   	 click(lfp.prefix_option);
   	 //enter full name
   	 driver.findElement(lfp.fullname).sendKeys(Keys.CONTROL + "a");
   	 driver.findElement(lfp.fullname).sendKeys(Keys.DELETE);
   	 pause();
   	 type(lfp.fullname,faker.name().fullName());
   	 //enter designation
   	 driver.findElement(lfp.designation).sendKeys(Keys.CONTROL + "a");
   	 driver.findElement(lfp.designation).sendKeys(Keys.DELETE);
   	 pause();
   	 type(lfp.designation,faker.job().title());
   	 //click phno button
   	 click(lfp.country_btn);
   	 //search for country
   	 type(lfp.search_country,"India");
   	 //select the country
   	 click(lfp.btn_country);
   	 //enter phone number
   	 int firstDigit = faker.number().numberBetween(6, 10);

   	// Remaining 9 digits
   	String remaining = faker.number().digits(9);
  	 driver.findElement(lfp.phno).sendKeys(Keys.CONTROL + "a");
  	 driver.findElement(lfp.phno).sendKeys(Keys.DELETE);
   	 pause();
   	 type(lfp.phno,firstDigit + remaining);
   	 //enter extension number
   	 driver.findElement(lfp.ext).sendKeys(Keys.CONTROL + "a");
   	 driver.findElement(lfp.ext).sendKeys(Keys.DELETE);
   	 pause();
   	 type(lfp.ext,"123");
   	 //click alt phno button
   	 click(lfp.alt_country_btn);
   	 //search for country
   	 type(lfp.alt_search_country,"India");
   	 //select the country
   	 click(lfp.alt_btn_country);
   	 //enter alternate phno
   	 driver.findElement(lfp.alt_phno).sendKeys(Keys.CONTROL + "a");
   	 driver.findElement(lfp.alt_phno).sendKeys(Keys.DELETE);
   	 pause();
   	 type(lfp.alt_phno,firstDigit + remaining);
   	 // enter alternate extension number
   	 driver.findElement(lfp.alt_ext).sendKeys(Keys.CONTROL + "a");
   	 driver.findElement(lfp.alt_ext).sendKeys(Keys.DELETE);
   	 pause();
   	 type(lfp.alt_ext,"789");
   	 //enter email
   	 driver.findElement(lfp.email).sendKeys(Keys.CONTROL + "a");
   	 driver.findElement(lfp.email).sendKeys(Keys.DELETE);
   	 pause();
   	 type(lfp.email,faker.internet().emailAddress());
   	 //click preferred channel button
   	 click(lfp.pre_channel_btn);
   	 //select preferred channel
   	 click(lfp.channel_option);
     }
    public void companyDetails() throws InterruptedException {
  	  //enter company name
      driver.findElement(lfp.company_name).sendKeys(Keys.CONTROL + "a");
      driver.findElement(lfp.company_name).sendKeys(Keys.DELETE);
      pause();
  	  type(lfp.company_name,faker.company().name());
  	  //enter website url
      driver.findElement(lfp.website).sendKeys(Keys.CONTROL + "a");
      driver.findElement(lfp.website).sendKeys(Keys.DELETE);
      pause();
  	  type(lfp.website,faker.internet().url());
  	  //select company size
  	  selectFromDropdown(lfp.btn_company_size, "Medium Business (51-200)");
  	  //select industry type
  	  selectFromDropdown(lfp.btn_Industry_type, "Education");
  	  //select annual revenue
  	  selectFromDropdown(lfp.btn_annual_revenue, "$30,000 - $50,000");
    }
    public void leadDetails() throws InterruptedException {
  	  //select staus of lead
  	  selectFromDropdown(lfp.status,"Negotiation");
  	  //select source of lead
  	  selectFromDropdown(lfp.source,"Trade Show");
  	  //enter next stage
      driver.findElement(lfp.next_stage).sendKeys(Keys.CONTROL + "a");
      driver.findElement(lfp.next_stage).sendKeys(Keys.DELETE);
      pause();
  	  type(lfp.next_stage,"sample");
  	  //enter description
      driver.findElement(lfp.description).sendKeys(Keys.CONTROL + "a");
      driver.findElement(lfp.description).sendKeys(Keys.DELETE);
      pause();
  	  type(lfp.description,"sample description");
  	  //select tags
  	  click(lfp.tags);
  	  click(lfp.tag_option);
    }
    public void socialDetails() throws InterruptedException {
  	  String name = faker.name().firstName();
      driver.findElement(lfp.linkedin_url).sendKeys(Keys.CONTROL + "a");
      driver.findElement(lfp.linkedin_url).sendKeys(Keys.DELETE);
      pause();
  	  type(lfp.linkedin_url," https://www.linkedin.com/in/"+name);
      driver.findElement(lfp.twitter_url).sendKeys(Keys.CONTROL + "a");
      driver.findElement(lfp.twitter_url).sendKeys(Keys.DELETE);
      pause();
  	  type(lfp.twitter_url,"https://x.com/"+name);
    }
    public void ClickUpadteBtn() throws InterruptedException {
    	click(update_lead_btn);
    }
}
