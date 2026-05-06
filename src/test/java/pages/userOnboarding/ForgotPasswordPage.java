package pages.userOnboarding;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class ForgotPasswordPage extends BasePage {
   public ForgotPasswordPage(WebDriver driver) {
	   super(driver);
   }
   //locators
   By forgot_pswd = By.linkText("Forgot password");
   By email = By.xpath("//input[@placeholder='Enter your email']");
   By send_verification_btn = By.xpath("//button[contains(text(),'Send Verification Code')]");
   By otp_list = By.xpath("//input[@inputmode='numeric']");
   By verify_otp_btn = By.xpath("//button[normalize-space()='Verify Code']");
   By new_pswd = By.xpath("//input[@placeholder='Enter your new password']");
   By confirm_pswd = By.xpath("//input[@placeholder='Confirm your new password']");
   By reset_btn = By.xpath("//button[normalize-space()='Reset Password']");
   
   //action methods
   public void click_forgot_pswd(String mail) throws InterruptedException {
	   click(forgot_pswd);
	   pause();
	   type(email,mail);
	   pause();
	   click(send_verification_btn);
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

           // Click verify button
          click(verify_otp_btn);
          pause();

   }
   public void new_password(String pswd) throws InterruptedException {
	   type(new_pswd,pswd);
	   pause();
	   type(confirm_pswd,pswd);
	   pause();
	   click(reset_btn);
	   pause();
   }
}
