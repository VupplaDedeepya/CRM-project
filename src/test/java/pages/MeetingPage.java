package pages;

import java.time.Duration;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import base.BasePage;

public class MeetingPage extends BasePage{
  public MeetingPage(WebDriver driver) {
	  super(driver);
  }
  //locators
  By Meetings_tab = By.xpath("//span[normalize-space()='Meetings']");
  By Log_meeting_btn = By.xpath("//button[.//div[normalize-space()='Log Meeting']]");
  By Meeting_title = By.xpath("//input[@id='meeting-title']");
  By participants_dd = By.xpath("//label[@for='meeting-participants']/following-sibling::div//div[contains(@class,'cursor-pointer')]");
  By participants_opt = By.xpath("//span[normalize-space()='sai (sai@yopmail.com)']/preceding-sibling::button");
  By Meeting_location = By.xpath("//input[@id='meeting-location']");
  By Meeting_description = By.xpath("//p[@data-placeholder='Enter meeting description...']");
  By date_dd = By.xpath("//button[contains(text(),'In 3 business days')]");
  By date_opt = By.xpath("//button[contains(text(),'Custom date')]");
  By sel_date = By.xpath("(//img[@alt='Time'])[2]");
  By date = By.xpath("//button[contains(text(),'23')]");
  By todo_btn = By.xpath("//label[contains(@class,'cursor-pointer')]//button");
  By submit_btn = By.xpath("(//button[.//div[contains(text(),'Log Meeting')]])[2]");
  Faker faker = new Faker();
  //add meeting locators
  By Add_meeting_btn = By.xpath("//button[normalize-space()='Add']");
  By meetingTitle = By.xpath("//input[@placeholder='Enter event title']");
  By attendees = By.xpath("//input[@placeholder='Enter email and press Enter']");
  By start_date = By.xpath("(//img[@alt='Calendar'])[3]");
  By dd = By.xpath("//button[normalize-space()='30']");
  By start_time = By.xpath("//label[contains(text(),'Start Date & Time')]/following::button[2]");
  By time = By.xpath("//button[normalize-space()='06:00 PM']");
  By description = By.xpath("//textarea[@placeholder='Add event description']");
  By scheduleMeeting_btn = By.xpath("//button[.//div[normalize-space()='Schedule Meeting']]");
  //reusable methods
  public void select_from_dropdown(String label,String option){
	  WebElement dropdown = new WebDriverWait(driver,Duration.ofSeconds(10)).
			  until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(@for,'"+label+"')]//following-sibling::div//div[contains(@class,'custom-react-select__control')]")));
	  dropdown.click();
	  WebElement opt = new WebDriverWait(driver,Duration.ofSeconds(10)).
			  until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'"+option+"')]")));
	  opt.click();
  }
  public void select_time(int index,String option) {
	  WebElement dropdown = driver.findElement(By.xpath("(//span[contains(text(),'Time:')]/following-sibling::select)[" + index + "]"));
	  Select select = new Select(dropdown);
	  select.selectByValue(option);
	  pause();
  }
  //Action methods
  public void selectLead() {
  	WebElement Lead = getLeadRowData("LEAD-0973","Avan");
  	wait.until(ExpectedConditions.elementToBeClickable(Lead)).click();
  	pause();
  }
  public void navigate_meetingTab() throws InterruptedException {
	  wait.until(ExpectedConditions.elementToBeClickable(Meetings_tab)).click();
  }
  public void Log_meeting() throws InterruptedException {
	  click(Log_meeting_btn);
	  String meetingTitle = faker.options().option(
			    "Follow-up Meeting",
			    "Product Discussion",
			    "Requirement Discussion",
			    "Sales Meeting",
			    "Demo Session",
			    "Introductory Call",
			    "Business Discussion"
			);
	 // String location = faker.address().city();

	  //type(Meeting_title,"Buisiness Discussion");
       driver.findElement(Meeting_title).click();
       pause();
       driver.findElement(Meeting_title).sendKeys(meetingTitle);
	  pause();
	  select_from_dropdown("meeting-type","Phone Call");
	  pause();
	  select_from_dropdown("meeting-outcome","Rescheduled");
	  pause();
	  select_from_dropdown("meeting-duration","45 Minutes");
	  pause();
	  click(participants_dd);
	  pause();
	  WebElement participant_option = new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(participants_opt));
	  participant_option.click();
	  driver.findElement(By.xpath("//label[@for='meeting-participants']")).click();
	  pause();
	  //type(Meeting_location,location);
	  type(Meeting_description,meetingTitle);
	  pause();
	  click(date_dd);
	  pause();
	  click(date_opt);
	  pause();
	  click(sel_date);
	  pause();
	  select_time(1,"06");
	  select_time(2,"30");
	  select_time(3,"PM");
	  click(date);
	  click(todo_btn);
	  click(submit_btn);
	  pause();
	  pause();
  }
  public void Add_Meeting() throws InterruptedException {
	  wait.until(ExpectedConditions.visibilityOfElementLocated(Add_meeting_btn)).click();
	  String title = faker.options().option(
			    "Follow-up Meeting",
			    "Product Discussion",
			    "Requirement Discussion",
			    "Sales Meeting",
			    "Demo Session",
			    "Introductory Call",
			    "Business Discussion"
			);
	  type(meetingTitle,title);
	  type(attendees,"sai@gmail.com");
	  driver.findElement(attendees).sendKeys(Keys.ENTER);
	  pause();
      click(start_date);
      click(dd);
      pause();
      click(start_time);
      click(time);
	  type(description,title);
	  pause();
	  click(scheduleMeeting_btn);
  	pause();
  	pause();
  }
}
