package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class FiltersPage extends BasePage{
    public FiltersPage(WebDriver driver) {
    	super(driver);
    }
    //locators
    //lead owner
    By lead_owner_filter = By.xpath("//div[contains(@class,'cursor-pointer')]//span[normalize-space()='Lead Owner']");
    By search_lead_owner = By.xpath("//input[@placeholder='Search lead owner']");
    By btn_search_lo = By.xpath("(//span[text()='Adesh Yearanty']/ancestor::div[contains(@class,'cursor-pointer')])[1]");
    //lead status
    By lead_status_filter = By.xpath("//div[contains(@class,'cursor-pointer')]//span[normalize-space()='Lead Status']");
    By search_lead_status = By.xpath("//input[@placeholder='Search lead status']");
    By btn_search_ls = By.xpath("(//span[text()='Negotiation']/ancestor::div[contains(@class,'cursor-pointer')])[1]");
    //create date
    By 	create_date = By.xpath("//div[contains(@class,'cursor-pointer')]//span[normalize-space()='Create Date']");
    By search_create_date = By.xpath("//input[@placeholder='Search create date']");
    By btn_search_cd = By.xpath("//span[text()='This Month']/ancestor::div[contains(@class,'cursor-pointer')]");
    //last activity
    By last_activity = By.xpath("//div[contains(@class,'cursor-pointer')]//span[normalize-space()='Last Activity']");
    By search_last_activity = By.xpath("//input[@placeholder='Search last activity']");
    By btn_search_la = By.xpath("//span[text()='Last 30 Days']");
    //advance filters
    By Advanced_filters = By.xpath("//div[contains(@class,'cursor-pointer')]//span[normalize-space()='Advanced Filters']");
    By sel_filter = By.xpath("//div[normalize-space()='Select filter']");
    By sel_condition = By.xpath("//div[normalize-space()='Select condition']");
    By sel_value = By.xpath("//button[@role='combobox' and contains(.,'Select value')]");
    By value = By.xpath("//li//span[normalize-space()='Website']");
    By value2 = By.xpath("//li//span[normalize-space()='Negotiation']");
    By add_row = By.xpath("//button/img[@alt='Add filter']");
    By apply_btn = By.xpath("//button[.//div[normalize-space()='Apply']]");
    //column search
    By search_txt = By.xpath("(//input[@placeholder='Search'])[2]");
    By column_dd = By.xpath("//button//span[normalize-space()='Select Column']");
    By column_opt = By.xpath("//li//span[normalize-space()='Status']");
    //Action methods
    public void filterByLeadOwner() throws InterruptedException {
    	click(lead_owner_filter);
    	type(search_lead_owner,"Adesh Yearanty");
    	click(btn_search_lo);
    	driver.findElement(By.xpath("//body")).click();
    	pause();
    }
    public void filterByLeadStatus() throws InterruptedException {
    	click(lead_status_filter);
    	type(search_lead_status,"Negotiation");
    	click(btn_search_ls);
    	driver.findElement(By.xpath("//body")).click();
    	pause();
    }
    public void filterByCreateDate() throws InterruptedException {
    	click(create_date);
    	type(search_create_date,"This Month");
    	click(btn_search_cd);
    	pause();
    }
    public void filterByLastActivity() throws InterruptedException {
    	click(last_activity);
    	type(search_last_activity,"Last 30 Days");
    	click(btn_search_la);
    	pause();
    }
    public void AdvFilters() throws InterruptedException {
    	click(Advanced_filters);
	    SelectFromFilter(sel_filter,"Source");
	    SelectFromFilter(sel_condition,"equals");
	    click(sel_value);
	    click(value);
	    driver.findElement(By.xpath("//body")).click();
	    click(add_row);
	    SelectFromFilter(sel_filter,"Status");
	    SelectFromFilter(sel_condition,"equals");
	    click(sel_value);
	    click(value2);
	    driver.findElement(By.tagName("body")).click();
	    click(apply_btn);
	    pause();
	    pause();
    }
    public void searchByColumnName() throws InterruptedException {
    	click(column_dd);
    	click(column_opt);
    	type(search_txt,"Negotiation");
    	pause();
    }
    
}
