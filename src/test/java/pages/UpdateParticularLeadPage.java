package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class UpdateParticularLeadPage extends BasePage{
  public UpdateParticularLeadPage(WebDriver driver) {
	  super(driver);
  }
  //update from lead checkbox 
  By lead_checkbox = By.xpath("//tr[.//span[contains(text(),'LEAD-0997')]]//button");
  By update_status = By.xpath("//img[@alt='Update Status']");
  By status_dropdown = By.xpath("//span[normalize-space()='Choose status...']");
  By status_option = By.xpath("//button[@type='button' and contains(text(),'New')]");
  By update_btn = By.xpath("//button[contains(text(),'Update')]");
  By update_leadowner = By.xpath("//img[@alt='Assign Owner']");
  By leadowner_dropdown= By.xpath("//button//span[contains(text(),'Choose owner...')]");
  By leadowner_option = By.xpath("//button[@type='button' and contains(text(),'Niharikac')]");
  By Add_tags = By.xpath("//button//span[normalize-space()='Add Tags']");
  By Add_tags_dropdown = By.xpath("//button[@type='button']//span[normalize-space()='Select tags']");
  By Add_tag_option = By.xpath("(//div[contains(@class,'cursor-pointer')]//button)[2]");
  By Add_tag_btn = By.xpath("//button[@type='button' and text()='Add Tags' ]");
  public void leadStatusUpdateFromCheckbox() throws InterruptedException {
	  click(lead_checkbox);
	  click(update_status);
	  click(status_dropdown);
	  click(status_option);
	  click(update_btn);
  }
  public void leadOwnerUpdateFromCheckbox() throws InterruptedException {
	  click(lead_checkbox);
	  click(update_leadowner);
	  click(leadowner_dropdown);
	  click(leadowner_option);
	  click(update_btn);
  }
  public void AddTagsFromCheckbox() throws InterruptedException {
	  click(lead_checkbox);
	  click(Add_tags);
	  click(Add_tags_dropdown);
	  click(Add_tag_option);
	  driver.findElement(By.xpath("//h3[normalize-space()='Add Tags']")).click();
	  click(Add_tag_btn);
  }
}
