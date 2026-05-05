package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class CreateDealPage extends BasePage{
   public CreateDealPage(WebDriver driver) {
	   super(driver);
   }
   //locators
   By deals_tab = By.xpath("//button[@title='Deals']");
   By create_deal_btn = By.xpath("//button[.//div[normalize-space()='Create Deal']]");
   By label = By.xpath("//button[.//div[normalize-space()='Deal Details']]");
   By create_btn = By.xpath("(//button[.//div[normalize-space()='Create Deal']])[2]");
   By deal_title = By.xpath("//input[@placeholder='Enter Deal Title']");
   By deal_value = By.xpath("//input[@placeholder='0.00']");
   By calendar_btn = By.xpath("//img[@alt='Calendar' and @height='24']");
   By close_date = By.xpath("//button[contains(text(),'27')]");
   By apply_btn = By.xpath("//button[.//div[normalize-space()='Apply']]");
   By tags_dd = By.xpath("//div[@data-field-key='tags']//button[.//div[normalize-space()='Select tags...']]");
   By tag = By.xpath("//li//span[.//span[normalize-space()='Hot Leads']]");
   By title = By.xpath("//label[normalize-space()='Close Date']");
   //reusable method
   public void select_from_dropdown(String label,String option) throws InterruptedException {
  	 click(By.xpath("//label[contains(text(),'"+label+"')]//following-sibling::div//div[contains(@class,'custom-react-select__control')]"));
  	 pause();
  	 click(By.xpath("//div[contains(text(),'"+option+"')]"));
  	 pause();
   }
   //action methods
   public void ClickDealsTab() throws InterruptedException {
	   click(deals_tab);
	   pause();
   }
   public void createDeal(String Tvalue) throws InterruptedException {
	   click(create_deal_btn);
	   pause();
	   type(deal_title,Tvalue);
	   pause();
	   select_from_dropdown("Account","Hermann Group");
	   pause();
	   select_from_dropdown("Contact","law");
	   pause();
	   select_from_dropdown("Stage","Value Proposition");
	   pause();
	   type(deal_value,"50000");
	   pause();
	   select_from_dropdown("Deal Value","USD");
	   pause();
	   click(calendar_btn);
	   pause();
	   click(close_date);
	   pause();
	   select_from_dropdown("Status","Open");
	   pause();
	   select_from_dropdown("Deal Owner","Thanuja");
	   pause();
	   click(tags_dd);
	   pause();
	   click(tag);
	   pause();
	   click(title);
	   click(create_btn);
	   pause();
	   pause();
   }

}
