package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class NotesPage extends BasePage{
	public NotesPage(WebDriver driver){
		super(driver);
	}
	//locators
    By Note_tab = By.xpath("//button[contains(@class,'cursor-pointer')]//span[normalize-space()='Notes']");
    By add_note_btn = By.xpath("//button//div[normalize-space()='Add']");
	By note_description = By.xpath("//p[@data-placeholder='Add an internal note...']");
	By date_dd = By.xpath("//img[@alt='Dropdown']/parent::button");
	By custom_date_opt = By.xpath("//button[normalize-space()='Custom date']");
	By select_date = By.xpath("(//img[@alt='Calendar']/parent::div)[2]");
	//By calender_date = By.xpath("//button[normalize-space()='24']");
	By Apply_btn = By.xpath("//div[normalize-space()='Apply']/parent::button");
	By schedule_time = By.xpath("//img[@alt='Time']");
	//By hour = By.xpath("//button[normalize-space()='10']");
	//By minute = By.xpath("//button[normalize-space()='30']");
	By todo_btn = By.xpath("//label[normalize-space()='Create To-Do']");
	By submit_btn = By.xpath("//div[normalize-space()='Submit']/parent::button");
	By edit_btn = By.xpath("(//div[@class='mb-3']//img[@alt='Edit'])[1]");
	By note = By.xpath("(//div[contains(@class,'cursor-pointer')]//h3)[1]");
	By note_data = By.xpath("(//div[@class='mb-3'])[1]");
	By edit_txt = By.xpath("//div[@contenteditable='true']");
	By save_btn = By.xpath("//button[normalize-space()='Save']");
	By Add_comment = By.xpath("(//img[@alt='Add Comment'])[1]");
	By text_box = By.xpath("//p[@data-placeholder='Add your comment...']");
		
    //Action methods
    public void selectLead() {
    	WebElement Lead = getLeadRowData("LEAD-1026","surya");
    	Lead.click();
    	pause();
    }
    public void note_tab() {
    	wait.until(ExpectedConditions.elementToBeClickable(Note_tab)).click();
    	pause();
    }
    public void Add_note(String description) throws InterruptedException {
    	click(add_note_btn);
    	type(note_description,description);
    	pause();
    	pause();
    }
    public void choose_alignment(String alignment) throws InterruptedException {
    	click(By.xpath("//img[contains(@alt,'"+alignment+"')]"));
    	pause();
    	pause();
    }
    public void select_dateAndtime(String date,String hours,String minutes,String indicator) throws InterruptedException {
    	click(date_dd);
        click(custom_date_opt);
        click(select_date);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'"+date+"')]"))).click();
    	pause();
    	click(Apply_btn);
    	click(schedule_time);
    	click(By.xpath("//button[contains(text(),'"+hours+"')]"));
    	click(By.xpath("//button[contains(text(),'"+minutes+"')]"));
    	click(By.xpath("//button[contains(text(),'"+indicator+"')]"));
    	click(Apply_btn);
    	pause();
    	pause();
    }
    public void submit() throws InterruptedException {
    	click(todo_btn);
    	click(submit_btn);
    	pause();
    	pause();
    }
    public void edit_note() throws InterruptedException {
    	click(note);
    	pause();
    	WebElement edit = wait.until(ExpectedConditions.visibilityOfElementLocated(note_data));
    	Actions actions = new Actions(driver);
    	actions.moveToElement(edit);
    	click(edit_btn);
    	pause();
    	type(edit_txt," Need to follow up with it.");
    	pause();
    	click(save_btn);
    	pause();
    	pause();
    }
    
}
