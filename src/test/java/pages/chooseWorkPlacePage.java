package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class chooseWorkPlacePage extends BasePage {
   //WebDriver driver;
   public chooseWorkPlacePage(WebDriver driver){
	   super(driver);
   }
   //locators
   By chooseWorkPlace = By.xpath("//button[text()='Next']");
   //action methods
   public void ClickNext() {
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	   wait.until(
	       ExpectedConditions.elementToBeClickable(chooseWorkPlace)
	   ).click();
   }
}
