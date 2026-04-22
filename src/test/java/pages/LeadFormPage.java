package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.github.javafaker.Faker;

import base.BasePage;

public class LeadFormPage extends BasePage{
  public LeadFormPage(WebDriver driver) {
      super(driver);
  }

  //basic details locators
  By label = By.xpath("//label[contains(normalize-space(),'Full Name')]");
  By prefix_dropdown = By.xpath("//label[contains(text(),'Full Name')]/following::div[contains(@class,'custom-react-select__control')][1]");
  By prefix_option =  By.xpath("//div[contains(@class,'custom-react-select__option') and normalize-space()='Ms']");
  By fullname = By.xpath("//input[@placeholder='Enter Full Name']");
  By designation = By.xpath("//input[@placeholder='Enter Designation']");
  By country_btn = By.xpath("//div[@data-field-key='contactNumber']//button");
  By search_country = By.xpath("//input[@placeholder='Search countries...' and not(@aria-hidden='true')]");
  By btn_country = By.xpath("//div[@class='max-h-48 overflow-y-auto']//button");
  By phno = By.xpath("//input[@placeholder='Enter Contact Number']");
  By ext = By.xpath("//div[@data-field-key='contactNumber']//input[@placeholder='Ext']");
  By alt_country_btn = By.xpath("//div[@data-field-key='alternateNumber']//button");
  By alt_search_country = By.xpath("//input[@placeholder='Search countries...' and not(@aria-hidden='true')]");
  By alt_btn_country = By.xpath("//div[@class='max-h-48 overflow-y-auto']//button");
  By alt_phno = By.xpath("//input[@placeholder='Enter Alternate Number']");
  By alt_ext = By.xpath("//div[@data-field-key='alternateNumber']//input[@placeholder='Ext']");
  By email = By.xpath("//div[@data-field-key='email']//input");
  By pre_channel_btn = By.xpath("(//div[@data-field-key='preferredChannel']//div[contains(@class,'custom-react-select__control')])[1]");
  By channel_option = By.xpath("//div[contains(@class,'custom-react-select__option') and normalize-space()='whatsapp']");

  //company details locators
  By company_name = By.xpath("//div[@data-field-key='companyName']//input");
  By website = By.xpath("//div[@data-field-key='website']//input");
  By btn_company_size = By.xpath("//div[@data-field-key='companySize']//div[contains(@class,'custom-react-select__control')]");
  By btn_Industry_type = By.xpath("//div[@data-field-key='industryType']//div[contains(@class,'custom-react-select__control')]");
  By btn_annual_revenue = By.xpath("//div[@data-field-key='annualRevenue']//div[contains(@class,'custom-react-select__control')]");

  //lead details
  By status = By.xpath("//div[@data-field-key='status']//div[contains(@class,'custom-react-select__control')]");
  By source = By.xpath("//div[@data-field-key='source']//div[contains(@class,'custom-react-select__control')]");
  By next_stage = By.xpath("//div[@data-field-key='nextStage']//input");
  By description = By.xpath("//div[@data-field-key='description']//textarea");
  By tags = By.xpath("//div[@data-field-key='tags']//button");
  By tag_option = By.xpath("//li[.//span[normalize-space()='Cold leads']]");

  //social details
  By linkedin_url = By.xpath("//div[@data-field-key='linkedinUrl']//input");
  By twitter_url = By.xpath("//div[@data-field-key='twitterUrl']//input");

  //create lead button
  By create = By.xpath("(//button/div[normalize-space()='Create Lead'])[2]");
  By error_msg = By.xpath("//p[normalize-space()='Please fix all validation errors']");

  //validation errors
  By all_errors = By.xpath("//div[contains(@class,'text-red') and contains(text(),'Invalid') or contains(text(),'required')]");

  Faker faker = new Faker();

  public void retype(By element,String text) {
      driver.findElement(element).sendKeys(Keys.CONTROL + "a");
      driver.findElement(element).sendKeys(Keys.DELETE);
      pause();
      driver.findElement(element).sendKeys(text);
      pause();
  }

  //action methods
  HomePage hp = new HomePage(driver);

  public void ClickCreateLead() throws InterruptedException {
      click(hp.create_lead_button);
      wait.until(ExpectedConditions.visibilityOfElementLocated(label));
      pause();
  }

  public void basicDetails() throws InterruptedException {
      wait.until(ExpectedConditions.visibilityOfElementLocated(label));

      click(prefix_dropdown);
      click(prefix_option);

      type(fullname,faker.name().lastName());
      type(designation,faker.job().title());

      click(country_btn);
      type(search_country,"India");
      click(btn_country);

      int firstDigit = faker.number().numberBetween(6, 10);
      String remaining = faker.number().digits(9);

      type(phno,firstDigit + remaining);
      type(ext,"123");

      click(alt_country_btn);
      type(alt_search_country,"India");
      click(alt_btn_country);

      type(alt_phno,firstDigit + remaining);
      type(alt_ext,"789");

      // intentionally wrong email for validation testing
      type(email,faker.internet().emailAddress());

      click(pre_channel_btn);
      click(channel_option);
  }

  public void companyDetails() throws InterruptedException {
      type(company_name,faker.company().name());
      type(website,faker.internet().url());
      selectFromDropdown(btn_company_size, "Medium Business (51-200)");
      selectFromDropdown(btn_Industry_type, "Education");
      selectFromDropdown(btn_annual_revenue, "$30,000 - $50,000");
  }

  public void leadDetails() throws InterruptedException {
      selectFromDropdown(status,"Negotiation");
      selectFromDropdown(source,"Trade Show");
      type(next_stage,"test");
      type(description,"test");
      click(tags);
      click(tag_option);
  }

  public void socialDetails() throws InterruptedException {
      String name = faker.name().lastName();
      type(linkedin_url," https://www.linkedin.com/in/"+name);
      type(twitter_url,"https://x.com/"+name);
  }

  public void clickCreate() throws InterruptedException {
      click(create); 
  }

  // ================= VALIDATION HANDLING =================

  public boolean isValidationErrorPresent() {
      try {
          return wait.withTimeout(Duration.ofSeconds(3))
                  .until(ExpectedConditions.visibilityOfElementLocated(error_msg))
                  .isDisplayed();
      } catch (Exception e) {
          return false;
      }
  }

  public void captureValidationErrors() {
      List<WebElement> errors = driver.findElements(all_errors);

      for(WebElement err : errors) {
          System.out.println("Validation Error: " + err.getText());
      }
  }

  public void fixValidationErrors() throws InterruptedException {
      List<WebElement> errors = driver.findElements(all_errors);

      for(WebElement err : errors) {
          String text = err.getText().toLowerCase();

          if(text.contains("name")) {
              retype(fullname, faker.name().lastName());
          }
          else if(text.contains("email")) {
              retype(email,faker.internet().emailAddress());
          }
          else if(text.contains("status")) {
              selectFromDropdown(status,"Negotiation");
          }
          else if(text.contains("source")) {
              selectFromDropdown(source,"Trade Show");
          }
      }
  }

  public void submitWithValidationHandling() throws InterruptedException {

      click(create);

      if(isValidationErrorPresent()) {
          System.out.println("Validation errors detected");

          captureValidationErrors();
          fixValidationErrors();

          System.out.println("Retrying form submission...");
          click(create);
      } else {
          System.out.println("Form submitted successfully");
      }
  }


  // Scenario 1: Only required fields
  public void submitWithOnlyRequiredFields() throws InterruptedException {

      click(create);

      if(isValidationErrorPresent()) {
          System.out.println("Filling only required fields...");

          List<WebElement> errors = driver.findElements(all_errors);

          for(WebElement err : errors) {
              String text = err.getText().toLowerCase();

              if(text.contains("name")) {
                  retype(fullname, faker.name().fullName());
              }
              else if(text.contains("email")) {
                  retype(email, faker.internet().emailAddress());
              }
              else if(text.contains("status")) {
                  selectFromDropdown(status,"Negotiation");
              }
              else if(text.contains("source")) {
                  selectFromDropdown(source,"Trade Show");
              }
          }

          System.out.println("Retrying submission...");
          click(create);
          pause();
          pause();
      }
  }

  // Scenario 2: Full form submission
  public void submitWithAllDetails() throws InterruptedException {
	  wait.until(ExpectedConditions.elementToBeClickable(hp.create_lead_button));
	  ClickCreateLead();
      basicDetails();
      companyDetails();
      leadDetails();
      socialDetails();
      submitWithValidationHandling();
  }
}