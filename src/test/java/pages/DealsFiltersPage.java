package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class DealsFiltersPage extends BasePage{
   public DealsFiltersPage(WebDriver driver) {
	   super(driver);
   }
   //locators
   //deal owner
   By deal_tab = By.xpath("//button[@title='Deals']");
   By deal_owner_filter = By.xpath("//div[contains(@class,'cursor-pointer')]//span[normalize-space()='Deal Owner']");
   By search_deal_owner = By.xpath("//input[@placeholder='Search deal owner']");
   By btn_search_lo = By.xpath("(//span[text()='Adesh Yearanty']/ancestor::div[contains(@class,'cursor-pointer')])[1]");
   //deal status
   By deal_status_filter = By.xpath("//div[contains(@class,'cursor-pointer')]//span[normalize-space()='Deal Status']");
   By search_deal_status = By.xpath("//input[@placeholder='Search deal status']");
   By btn_search_ls = By.xpath("(//span[text()='Open']/ancestor::div[contains(@class,'cursor-pointer')])[1]");
   //close date
   By 	close_date = By.xpath("//div[contains(@class,'cursor-pointer')]//span[normalize-space()='Close Date']");
   By search_close_date = By.xpath("//input[@placeholder='Search close date']");
   By btn_search_cld = By.xpath("//span[text()='This Month']/ancestor::div[contains(@class,'cursor-pointer')]");
   //created date
   By created_date = By.xpath("//div[contains(@class,'cursor-pointer')]//span[normalize-space()='Created Date']");
   By search_created_date = By.xpath("//input[@placeholder='Search created date']");
   By btn_search_cd = By.xpath("//span[text()='Last 30 Days']");
   //Advanced filters
   By Advanced_filters = By.xpath("//div[contains(@class,'cursor-pointer')]//span[normalize-space()='Advanced Filters']");
   By sel_filter = By.xpath("//div[normalize-space()='Select filter']");
   By sel_condition = By.xpath("//div[normalize-space()='Select condition']");
   By sel_value = By.xpath("//button[@role='combobox' and contains(.,'Select value')]");
   By value1 = By.xpath("//li//span[normalize-space()='Open']");
   By value2 = By.xpath("//li//span[normalize-space()='Value Proposition']");
   By add_row = By.xpath("//button/img[@alt='Add filter']");
   By apply_btn = By.xpath("//button[.//div[normalize-space()='Apply']]");
   //search by column name
   By column_dd = By.xpath("//span[normalize-space()='1 Selected']//ancestor::button");
   By search_term = By.xpath("//input[@placeholder='Search deal...']");
   //Action methods
   public void dealTab() throws InterruptedException {
	   click(deal_tab);
	   pause();
   }
   public void filterByDealOwner() throws InterruptedException {
   	click(deal_owner_filter);
   	type(search_deal_owner,"Adesh Yearanty");
   	click(btn_search_lo);
   	driver.findElement(By.xpath("//body")).click();
   	pause();
   }
   public void filterByDealStatus() throws InterruptedException {
   	click(deal_status_filter);
   	type(search_deal_status,"Open");
   	click(btn_search_ls);
   	driver.findElement(By.xpath("//body")).click();
   	pause();
   }
   public void filterByCloseDate() throws InterruptedException {
   	click(close_date);
   	type(search_close_date,"This Month");
   	click(btn_search_cld);
   	pause();
   }
   public void filterByCreatedDate() throws InterruptedException {
   	click(created_date);
   	type(search_created_date,"Last 30 Days");
   	click(btn_search_cd);
   	pause();
   }
   public void advanced_filters() throws InterruptedException {
   	click(Advanced_filters);
	    SelectFromFilter(sel_filter,"Status");
	    SelectFromFilter(sel_condition,"equals");
	    click(sel_value);
	    click(value1);
	    driver.findElement(By.xpath("//body")).click();
	    click(add_row);
	    SelectFromFilter(sel_filter,"Stage");
	    SelectFromFilter(sel_condition,"equals");
	    click(sel_value);
	    click(value2);
	    driver.findElement(By.tagName("body")).click();
	    click(apply_btn);
	    pause();
	    pause();
   }
   public void search_by_col(String field,String value) throws InterruptedException {
	  WebElement col = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='\"+field+\"']//preceding-sibling::button")));
	  col.click();
	  pause();
	  type(search_term,value);
	  pause();
   }
}
