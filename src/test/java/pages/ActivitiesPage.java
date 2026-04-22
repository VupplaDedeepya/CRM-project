package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class ActivitiesPage extends BasePage{
     public  ActivitiesPage(WebDriver driver){
    	  super(driver);
      }
     //locators
     By notes_btn = By.xpath("//button[.//img[@alt='Notes']]");
     By tasks_btn = By.xpath("//button[.//img[@alt='Tasks']]");
     By calendar_btn = By.xpath("(//button[.//img[@alt='Calendar']])[2]");
     By email_btn = By.xpath("//button[.//img[@alt='Email']]");
     By convert_to_deal_btn = By.xpath("//div[normalize-space()='Convert to deal']//parent::button");
     By close_btn = By.xpath("//button[@title='Expand']//following-sibling::button");
     By calendar_close = By.xpath("(//img[@alt='Google Calendar']//parent::div)//following-sibling::button");
     //deal form locators
     By loading = By.xpath("//label[contains(text(),'Deal Title')]");
     By deal_title = By.xpath("//input[@placeholder='Enter Deal Title']");
    // By Account_dd = By.xpath("//label[contains(text(),'Account')]//following-sibling::div//div[contains(@class,'custom-react-select__control')]");
    // By Account_opt = By.xpath("//div[contains(text(),'Sales Force')]");
     //By status_dd = By.xpath("//label[contains(text(),'Stage')]//following-sibling::div//div[contains(@class,'custom-react-select__control')]");
     //By status_opt = By.xpath("//div[contains(text(),'Value Proposition')]");
     By deal_value = By.xpath("//input[@placeholder='0.00']");
     //By currency_dd = By.xpath("//label[contains(text(),'Deal Value')]//following-sibling::div//div[contains(@class,'custom-react-select__control')]");
     //By currency_opt = By.xpath("//div[contains(text(),'USD')]");
     By close_date = By.xpath("(//img[@alt='Calendar'])[3]");
     By date = By.xpath("//button[contains(text(),'23')]");
     //By lead_owner_dd = By.xpath("//label[contains(text(),'Deal Owner')]//following-sibling::div//div[contains(@class,'custom-react-select__control')]");
     //By lead_owner_opt = By.xpath("//div[contains(text(),'Niharikac')]");
     By tags_dd = By.xpath("//label[contains(text(),'Tags')]//following-sibling::div//button[1]");
     By tags_opt = By.xpath("//li[.//span[contains(text(),'Hot Leads')]]");
     By label = By.xpath("//label[contains(text(),'Deal Owner')]");
     By create_deal_btn = By.xpath("//button[.//div[contains(text(),'Create Deal')]]");
     //reusable method
     public void select_from_dropdown(String label,String option) throws InterruptedException {
    	 click(By.xpath("//label[contains(text(),'"+label+"')]//following-sibling::div//div[contains(@class,'custom-react-select__control')]"));
    	 pause();
    	 click(By.xpath("//div[contains(text(),'"+option+"')]"));
    	 pause();
     }
     //action methods
     public void selectLead(String LeadId,String name) {
     	WebElement Lead = getLeadRowData(LeadId,name);
     	Lead.click();
     	pause();
     }
     public void notes() throws InterruptedException {
    	 click(notes_btn);
    	 pause();
    	 click(close_btn);
    	 pause();
     }
     public void tasks() throws InterruptedException {
    	 click(tasks_btn);
    	 pause();
    	 click(close_btn);
    	 pause();
     }
     public void calendar() throws InterruptedException {
    	 click(calendar_btn);
    	 pause();
    	 click(calendar_close);
    	 pause();
     }
     public void email() throws InterruptedException {
    	 click(email_btn);
    	 pause();
    	 click(close_btn);
    	 pause();
     }
     public void convertToDeal() throws InterruptedException {
    	 click(convert_to_deal_btn);
    	 pause();
    	 wait.until(ExpectedConditions.visibilityOfElementLocated(loading));
    	 driver.findElement(deal_title).sendKeys(Keys.CONTROL+"a");
    	 pause();
    	 driver.findElement(deal_title).sendKeys(Keys.DELETE);
    	 pause();
    	 type(deal_title,"Website Development Deal – Phase 1");
    	 pause();
    	 select_from_dropdown("Account","Sales Force");
    	 pause();
    	 select_from_dropdown("Stage","Value Proposition");
    	 pause();
    	 type(deal_value,"40000");
    	 pause();
    	 select_from_dropdown("Deal Value","USD");
    	 pause();
    	 click(close_date);
    	 pause();
    	 click(date);
    	 pause();
    	 select_from_dropdown("Deal Owner","Niharikac");
    	 pause();
    	 click(tags_dd);
    	 pause();
    	 click(tags_opt);
    	 pause();
    	 click(label);
    	 click(create_deal_btn);
    	 pause();
     }
}
