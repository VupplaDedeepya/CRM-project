package pages.deals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

import base.BasePage;

public class NotesPage extends BasePage{
     public NotesPage(WebDriver driver) {
    	 super(driver);
     }
     //locators
     By deals_tab = By.xpath("//button[@title='Deals']");
     By notes_tab = By.xpath("//button[.//span[normalize-space()='Notes']]");
     By add_notes_btn = By.xpath("//button[normalize-space()='Add']");
     By notes_description = By.xpath("//p[@data-placeholder='Add an internal note...']");
     By create_to_do_btn = By.xpath("//label[normalize-space()='Create To-Do']//preceding-sibling::button");
     By followup_dd = By.xpath("//img[@alt='Dropdown']");
     By followup_opt = By.xpath("//button[normalize-space()='Custom date']");
     By date_dd = By.xpath("//span[normalize-space()='Select date']");
     By date = By.xpath("//button[normalize-space()='24']");
     By time_dd = By.xpath("//img[@alt='Time' and @height='24']");
     By hours = By.xpath("//button[normalize-space()='7']");
     By minutes = By.xpath("//button[normalize-space()='30']");
     By suffix = By.xpath("//button[normalize-space()='PM']");
     By apply_btn = By.xpath("//button[.//div[normalize-space()='Apply']]");
     By submit_btn = By.xpath("//button[.//div[normalize-space()='Submit']]");
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
     public void notes_tab() throws InterruptedException {
    	 click(notes_tab);
    	 pause();
     }
     public void add_notes() throws InterruptedException {
    	 click(add_notes_btn);
    	 pause();
  	   String text = faker.options().option(
  			 "Client requested a revised quotation with updated pricing details.",

			    "Followed up with the customer regarding proposal approval.",

			    "Customer showed interest in premium support package.",

			    "Meeting scheduled with the client for product demo next week.",

			    "Deal moved to negotiation stage after successful discussion.",

			    "Client requested additional information about implementation timeline.",

			    "Payment terms discussed with the finance team.",

			    "Customer asked for a discount on bulk purchase order.",

			    "Technical requirements shared with the development team.",

			    "Waiting for final confirmation from the client side.",

			    "Product presentation completed successfully with stakeholders.",

			    "Customer requested integration details with existing software.",

			    "Deal value updated based on revised customer requirements.",

			    "Follow-up call completed and feedback collected from client.",

			    "Proposal document shared through email for review.",

			    "Client requested another meeting to discuss contract terms.",

			    "Initial requirement gathering completed successfully.",

			    "Customer interested in long-term partnership opportunities.",

			    "Sales manager approved special pricing for this deal.",

			    "Contract draft sent to customer for legal verification."
			);
    	 type(notes_description,text);
    	 pause();
    	 click(create_to_do_btn);
    	 click(followup_dd);
    	 click(followup_opt);
    	 click(date_dd);
    	 click(date);
    	 click(apply_btn);
    	 click(time_dd);
    	 click(hours);
    	 click(minutes);
    	 click(suffix);
    	 click(apply_btn);
    	 click(submit_btn);
     }
}
