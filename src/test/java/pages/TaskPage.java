package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

import base.BasePage;

public class TaskPage extends BasePage{
   public TaskPage(WebDriver driver) {
	   super(driver);
   }
   //locators
   By Task_tab = By.xpath("//div[contains(@class,'cursor-pointer')]//span[normalize-space()='Task']");
   By add_task = By.xpath("//button[normalize-space()='Add']");
   By task_name = By.xpath("//input[@id='task-title']");
   //By task_type_dd = By.xpath("//label[normalize-space()='Task Type']/following-sibling::div//div[contains(@class,'custom-react-select__control')]");
   //By task_type_opt = By.xpath("//div[contains(@class,'custom-react-select__option') and normalize-space()='Meeting']");
  // By priority_dd = By.xpath("//label[normalize-space()='Priority']/following-sibling::div//div[contains(@class,'custom-react-select__control')]");
   //By priority_opt = By.xpath("//div[contains(@class,'custom-react-select__option') and normalize-space()='Medium']");
   By due_date_dd = By.xpath("(//img[@alt='Calendar'])[4]");
   By due_date = By.xpath("//button[normalize-space()='17']");
   By due_time = By.xpath("//input[@placeholder='Time']");
   By assignedTo_dd = By.xpath("//label[contains(text(),'Assigned To ')]/following-sibling::div//button");
   By assignedTo_opt = By.xpath("//li[contains(text(),'saipavan')]");
   By contributors_dd = By.xpath("//button[.//span[contains(text(),'Select contributors')]]");
   By contributors_opt = By.xpath("//span[normalize-space()='Saikumarballa']");
   By task_description = By.xpath("//textarea[@id='task-description']");
   By submit_btn = By.xpath("//button[normalize-space()='Submit']");
   Faker faker = new Faker();
   //reusable method
   public void select_from_dropdown(String label,String option) throws InterruptedException {
	   click(By.xpath("//label[contains(text(),'"+label+"')]/following-sibling::div//div[contains(@class,'custom-react-select__control')]"));
	   click(By.xpath("//div[contains(@class,'custom-react-select__option') and contains(text(),'"+option+"')]"));
	   pause();
   }
   //actions method
   public void selectLead() {
   	WebElement Lead = getLeadRowData("LEAD-0973","Avan");
   	Lead.click();
   	pause();
   }	   
   public void add_task() throws InterruptedException {
	   click(Task_tab);
	   pause();
	   click(add_task);
	   pause();
	   String taskName = faker.options().option(
			    "Follow up with lead",
			    "Schedule product demo",
			    "Send proposal to client",
			    "Call lead for requirement discussion",
			    "Share pricing details",
			    "Arrange meeting with stakeholder",
			    "Close deal discussion",
			    "Lead qualification call"
			);
	   type(task_name,taskName);
	   pause();
	   select_from_dropdown("Task Type","Meeting");
	   pause();
	   select_from_dropdown("Priority","Medium");
	   pause();
	   click(due_date_dd);
	   pause();
	   click(due_date);
	   pause();
	   driver.findElement(due_time).sendKeys(Keys.CONTROL+"a");
	   driver.findElement(due_time).sendKeys(Keys.DELETE);
	   pause();
	   type(due_time,"11:45");
	   driver.findElement(By.xpath("//label[contains(text(),'Due Date & Time')]")).click();
	   click(assignedTo_dd);
	   click(assignedTo_opt);
	   pause();
	   click(contributors_dd);
	   click(contributors_opt);
	   pause();
	   type(task_description,taskName);
	   pause();
	   click(submit_btn);
	   pause();
	   pause();
   }
   
}
