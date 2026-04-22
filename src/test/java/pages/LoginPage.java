package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}