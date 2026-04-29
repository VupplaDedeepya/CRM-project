package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;
import utils.ConfigReader;

public class LoginPage extends BasePage{


    By email = By.xpath("//input[@placeholder='Enter your email']");
    By password = By.xpath("//input[@placeholder='Enter your password']");
    By loginBtn = By.xpath("//div[@class='relative inline-block w-full']/child::button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login() throws InterruptedException {
        type(email,ConfigReader.get("username"));
        type(password,ConfigReader.get("password")); 
        click(loginBtn);
    }
    public void loginWithArgs(String mail,String pswd) throws InterruptedException {
    	type(email,mail);
    	type(password,pswd);
    }
    public void clickLogin() {
        WebElement btn = wait.until(
            ExpectedConditions.elementToBeClickable(loginBtn)
        );
        btn.click();
    }
    public void clearinputs() {
    	driver.findElement(email).sendKeys(Keys.CONTROL + "a");
    	driver.findElement(email).sendKeys(Keys.DELETE);
    	driver.findElement(password).sendKeys(Keys.CONTROL + "a");
    	driver.findElement(password).sendKeys(Keys.DELETE);
    }
    public String btndisabled() {
        try {
            WebElement btn = wait.until(
                ExpectedConditions.presenceOfElementLocated(loginBtn)
            );
            return btn.isEnabled() ? "enabled" : "disabled";
        } catch (Exception e) {
            return "not found";
        }
    }
    public boolean isErrorDisplayed() {
        try {
           // return driver.findElement(By.xpath("//div[contains(text(),'Invalid')]")).isDisplayed();
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Invalid')]"))).isDisplayed();
        } catch (Exception e) 
        {
            return false;
        }
    }
    public String loginSuccess() {
         return driver.getTitle();
    }
}