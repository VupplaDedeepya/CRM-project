package pages.deals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;

import base.BasePage;

public class DealViewPage extends BasePage{
    public DealViewPage(WebDriver driver) {
    	super(driver);
    }
    //locators
    By deals_tab = By.xpath("//button[@title='Deals']");
    By add_view = By.xpath("//div[@id='add-view-button']");
    By view_name = By.xpath("//input[@id='viewName']");
    By defaultview_checkbox = By.xpath("//label[@for='isDefaultView']");
    By sel_filter = By.xpath("//div[normalize-space()='Select filter']");
    By sel_condition = By.xpath("//div[normalize-space()='Select condition']");
    By sel_value = By.xpath("//button[@role='combobox' and contains(.,'Select value')]");
    By sel_date_preset = By.xpath("//div[normalize-space()='Select date preset']//parent::button");
    By sel_assignees = By.xpath("//div[normalize-space()='Select assignees']//parent::button");
    By enter_val = By.xpath("//input[@placeholder='Enter value']");
    By value1 = By.xpath("//div[contains(@class,'cursor-pointer')][.//div[normalize-space()='Last 7 Days']]");
    By value2 = By.xpath("//li//span[normalize-space()='Open']");
    By add_row = By.xpath("//button/img[@alt='Add filter']");
    By btn_create_view = By.xpath("//button[.//div[normalize-space()='Create View']]");
    
    Faker faker = new Faker();
    //action methods
    public void deals_tab() throws InterruptedException {
    	click(deals_tab);
    	pause();
    	pause();
    }
    public void add_view() throws InterruptedException {
    	click(add_view);
    	pause();
    	String name = faker.name().lastName();
    	type(view_name,name+"'s view");
    	pause();
	    SelectFromFilter(sel_filter,"Created Date");
	    SelectFromFilter(sel_condition,"preset");
	    click(sel_date_preset);
	    click(value1);
	    driver.findElement(By.xpath("//body")).click();
	    click(add_row);
	    SelectFromFilter(sel_filter,"Status");
	    SelectFromFilter(sel_condition,"equals");
	    click(sel_value);
	    click(value2);
	    driver.findElement(By.tagName("body")).click();
	    pause();
	    click(btn_create_view);
	    pause();
	    pause();
    }
}
