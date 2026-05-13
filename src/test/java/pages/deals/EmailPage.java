package pages.deals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;

import base.BasePage;

public class EmailPage extends BasePage{
   public EmailPage(WebDriver driver) {
	   super(driver);
   }
   //locators
   By deals_tab = By.xpath("//button[@title='Deals']");
   By email_tab = By.xpath("//button[.//span[normalize-space()='Email']]");
   By compose_btn = By.xpath("//button[.//div[normalize-space()='Compose']]");
   By to_address = By.xpath("//input[@id='email-to']");
   By cc_btn = By.xpath("//button[normalize-space()='Cc']");
   By cc_address = By.xpath("//input[@id='email-cc']");
   By bcc_btn = By.xpath("//button[normalize-space()='Bcc']");
   By bcc_address = By.xpath("//input[@id='email-bcc']");
   By subject = By.xpath("//input[@id='email-subject']");
   By email_body = By.xpath("//div[@contenteditable='true']");
   By followup_dd = By.xpath("//img[@alt='Dropdown']");
   By followup_opt = By.xpath("//button[normalize-space()='Custom']");
   By date_time_dd = By.xpath("//img[@alt='Time']");
  // By hours = By.xpath("//div[.//span[normalize-space()='Time:']]//select[1]");
   //By minutes = By.xpath("//div[.//span[normalize-space()='Time:']]//select[2]");
  // By suffix = By.xpath("//div[.//span[normalize-space()='Time:']]//select[3]");
   By date = By.xpath("//button[normalize-space()='27']");
   By cancel_btn = By.xpath("//button[.//div[normalize-space()='Cancel']]");
   By scedule_send_btn = By.xpath("//button[.//div[normalize-space()='Schedule Send']]");
   By send_btn = By.xpath("//button[.//div[normalize-space()='Send']]");
   By create_to_do_btn = By.xpath("//button[normalize-space()='Create To-Do']");
   By schedule_opt = By.xpath("//label[.//span[normalize-space()='Custom']]");
   By schedule_date_dd = By.xpath("//span[normalize-space()='Select date']");
   By schedule_date = By.xpath("//button[normalize-space()='28']");
   By time_dd = By.xpath("(//img[@alt='Time' and @height='24'])[2]");
   By schedule_hours = By.xpath("//button[normalize-space()='7']");
   By schedule_minutes = By.xpath("//button[normalize-space()='30']");
   By schedule_suffix = By.xpath("//button[normalize-space()='PM']");
   By apply_btn = By.xpath("//button[.//div[normalize-space()='Apply']]");
   By schedule_btn = By.xpath("//button[.//div[normalize-space()='Schedule']]");
   By details_container = By.xpath("//h3[normalize-space()='Deal Details']//parent::div");
   By mail_container = By.xpath("//div[@class='space-y-0']");
   Faker faker = new Faker();
   //action methods
   public void deals_tab() throws InterruptedException {
  	 click(deals_tab);
  	 pause();
   }
   public void selectDeal() {
  	   	WebElement Lead = getDealRowData("kishor");
  	   	Lead.click();
  	   	pause();
  	   }
   public void email_tab() throws InterruptedException {
	 WebElement details = wait.until(ExpectedConditions.visibilityOfElementLocated(details_container));
  	 click(email_tab);
  	 pause();
   }
   public void compose_email() throws InterruptedException {
	   WebElement mail = wait.until(ExpectedConditions.visibilityOfElementLocated(mail_container));
	   click(compose_btn);
	   click(followup_dd);
	   click(followup_opt);
	   click(date_time_dd);
	   
	   List<WebElement> selects = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[normalize-space()='Time:']/parent::div//select")));
			  
	   Select hrs = new Select(selects.get(0));
	   hrs.selectByVisibleText("11");

	   Select mins = new Select(selects.get(1));
	   mins.selectByVisibleText("30");

	   Select suffix = new Select(selects.get(2));
	   suffix.selectByVisibleText("AM");
	   click(date);
	   driver.findElement(to_address).sendKeys(faker.internet().emailAddress(),Keys.ENTER);
	   pause();
	   click(cc_btn);
	   driver.findElement(cc_address).sendKeys(faker.internet().emailAddress(),Keys.ENTER);
	   type(subject,"test email");
	   type(email_body,"This is an email");
	   click(create_to_do_btn);
	   click(send_btn);
	   pause();
	   pause();
   }
 /*  public void draft_email() throws InterruptedException {
	   click(compose_btn);
	   driver.findElement(to_address).sendKeys(faker.internet().emailAddress(),Keys.ENTER);
	   pause();
	   click(cc_btn);
	   driver.findElement(cc_address).sendKeys(faker.internet().emailAddress(),Keys.ENTER);
	   pause();
	   type(subject,"test email");
	   type(email_body,"This is a draft email");
	   click(date_time_dd);
	   List<WebElement> selects =
			   driver.findElements(By.xpath("//span[normalize-space()='Time:']/parent::div//select"));
	   Select hrs = new Select(selects.get(0));
	   hrs.selectByVisibleText("11");

	   Select mins = new Select(selects.get(1));
	   mins.selectByVisibleText("30");

	   Select suffix = new Select(selects.get(2));
	   suffix.selectByVisibleText("AM");
	   click(create_to_do_btn);
	   click(cancel_btn);
	   pause();
	   pause();
   }
   public void schedule_email() throws InterruptedException {
	   click(compose_btn);
	   driver.findElement(to_address).sendKeys(faker.internet().emailAddress(),Keys.ENTER);
	   pause();
	   click(cc_btn);
	   driver.findElement(cc_address).sendKeys(faker.internet().emailAddress(),Keys.ENTER);
	   pause();
	   type(subject,"test email");
	   type(email_body,"This is a scheduled email");
	   click(date_time_dd);
	   List<WebElement> selects =
			   driver.findElements(By.xpath("//span[normalize-space()='Time:']/parent::div//select"));
	   Select hrs = new Select(selects.get(0));
	   hrs.selectByVisibleText("11");

	   Select mins = new Select(selects.get(1));
	   mins.selectByVisibleText("30");

	   Select suffix = new Select(selects.get(2));
	   suffix.selectByVisibleText("AM");
	   click(create_to_do_btn);
	   click(scedule_send_btn);
	   click(schedule_opt);
	   click(schedule_date_dd);
	   click(schedule_date);
	   click(time_dd);
	   click(schedule_hours);
	   click(schedule_minutes);
	   click(schedule_suffix);
	   click(apply_btn);
	   click(schedule_btn);
	   pause();
	   pause();
   }
   */
}
