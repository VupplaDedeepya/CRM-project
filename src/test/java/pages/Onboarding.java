package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class Onboarding extends BasePage{
    public Onboarding(WebDriver driver) {
    	super(driver);
    }
    //locators
    By signup_btn = By.xpath("//a[contains(text(),'Sign Up')]");
    By full_name = By.xpath("//input[@placeholder='Enter your full name']");
    By email = By.xpath("//input[@placeholder='Enter your Email']");
    By password = By.xpath("//input[@placeholder='Enter your password']");
    By create_act_btn = By.xpath("//button[contains(@class,'cursor-pointer') and contains(text(),'Create Account')]");
    By otp_list = By.xpath("//input[@inputmode='numeric']");
    By next_btn = By.xpath("//button[normalize-space()='Next']");
    By company_name = By.xpath("//input[@placeholder='Enter your company name']");
    By company_size = By.xpath("//button[contains(text(),'51 to 200')]");
    By role = By.xpath("//button[contains(text(),'Employee')]");
    By hear_abt_us = By.xpath("//button[contains(text(),'LinkedIn')]");
    By industry_type = By.xpath("//button[contains(text(),'Technology & Services')]");
    By connect_tools1 = By.xpath("//button[contains(text(),'Whatsapp')]");
    By connect_tools2 = By.xpath("//button[contains(text(),'Teams')]");
    By connect_tools3 = By.xpath("//button[contains(text(),'Docusign')]");
    //By skip_btn = By.xpath("//button[contains(text(),'Skip Now')]");
    By invite_mail = By.xpath("//input[@placeholder='Press Enter to add multiple emails']");
    By invite_btn = By.xpath("//button[contains(text(),'Send Invite')]");
    //Action methods
    public void signup(String name,String mail,String pswd) throws InterruptedException {
    	click(signup_btn);
    	pause();
    	type(full_name,name);
    	type(email,mail);
    	type(password,pswd);
    	click(create_act_btn);
    	pause();
    }
    public void enter_otp(String email) throws InterruptedException {
		String parentWindow = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.yopmail.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login']"))).sendKeys(email,Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("refresh"))).click();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='ifmail']")));
        String otp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@align='center']//td//p[contains(@style,'letter-spacing')]"))).getText();
        System.out.println(otp);
        driver.switchTo().defaultContent();
        driver.switchTo().window(parentWindow);
        System.out.println("Back to parent tab");
        List<WebElement> otpFields = wait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(
                   otp_list, 5
                )
            );

            // Enter OTP
            for (int i = 0; i < otp.length(); i++) {
                otpFields.get(i).sendKeys(String.valueOf(otp.charAt(i)));
            }

            // Click Next
           click(next_btn);
           pause();

    }
    LoginPage lp = new LoginPage(driver);
    public void login(String mail,String pswd) throws InterruptedException {
    	type(lp.email,mail);
    	pause();
    	type(lp.password,pswd);
    	pause();
    	click(lp.loginBtn);
    	pause();
    }
   public void workspace(String comName) throws InterruptedException {
	   click(next_btn);
	   pause();
	   type(company_name,comName);
	   pause();
	   click(next_btn);
	   pause();
	   click(company_size);
	   click(next_btn);
	   pause();
	   click(role);
	   click(next_btn);
	   pause();
	   click(hear_abt_us);
	   click(next_btn);
	   pause();
	   click(industry_type);
	   click(next_btn);
	   pause();
	   click(connect_tools1);
	   pause();
	   click(connect_tools2);
	   pause();
	   click(connect_tools3);
	   pause();
	   click(next_btn);
	   pause();
       driver.findElement(invite_mail).sendKeys("sanjana@yopmail.com",Keys.ENTER);
	   pause();
	   click(invite_btn);
	   pause();
   }
}
