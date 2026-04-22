package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class EmailPage extends BasePage{
     public EmailPage(WebDriver driver) {
    	 super(driver);
     }
     //locators
     By email_tab = By.xpath("(//span[normalize-space()='Email'])[2]");
     By compose_btn = By.xpath("//button[normalize-space()='Compose']");
     By To = By.xpath("//input[@placeholder='Enter recipient email and press Enter']");
     By subject = By.xpath("//input[@id='email-subject' and @placeholder='Add a subject']");
     By email_body = By.xpath("//p[@data-placeholder='Enter your email body here']");
     By todo_btn = By.xpath("//button[normalize-space()='Create To-Do']/preceding-sibling::button");
     By cancel_btn = By.xpath("//button[.//div[normalize-space()='Cancel']]");
     By schedule_send_btn = By.xpath("//button[.//div[normalize-space()='Schedule Send']]");
     By schedule_opt = By.xpath("//span[normalize-space()='Tomorrow afternoon (1pm)']");
     By schedule_btn = By.xpath("//button[.//div[normalize-space()='Schedule']]");
     By send_btn = By.xpath("//button[.//div[normalize-space()='Send']]");
     
     
     //action methods
     public void selectLead() {
     	WebElement Lead = getLeadRowData("LEAD-0973","Avan");
     	Lead.click();
     	pause();
     }
     public void click_email_tab() throws InterruptedException {
    	 wait.until(ExpectedConditions.elementToBeClickable(email_tab)).click();
    	 pause();
     }
     public void compose_draft() throws InterruptedException {
    	 click(compose_btn);
    	 type(To,"sai@gmail.com");
    	 pause();
    	 type(subject,"Followup regarding the meeting");
    	 pause();
    	 type(email_body,"this is a draft email");
    	 pause();
    	 click(cancel_btn);
    	 pause();
     }
     public void compose_schedule_send() throws InterruptedException {
    	 WebElement compose = new WebDriverWait(driver, Duration.ofSeconds(10))
    		        .until(ExpectedConditions.elementToBeClickable(compose_btn));
    		compose.click();
    	 pause();
    	 type(To,"sai@gmail.com");
    	 pause();
    	 type(subject,"Followup regarding the meeting");
    	 pause();
    	 type(email_body,"this is a scheduled email");
    	 pause();
    	 click(schedule_send_btn);
    	 click(schedule_opt);
    	 WebElement btn = new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(schedule_btn));
    	 btn.click();
    	 pause();
     }
     public void compose_email() throws InterruptedException {
    	 WebElement compose = new WebDriverWait(driver, Duration.ofSeconds(10))
    		        .until(ExpectedConditions.elementToBeClickable(compose_btn));
    		compose.click();
    	 type(To,"sai@gmail.com");
    	 pause();
    	 type(subject,"Followup regarding the meeting");
    	 pause();
    	 type(email_body,"this is an email");
    	 pause();
    	 click(send_btn);
    	 pause();
    	 pause();
     }
     
}
