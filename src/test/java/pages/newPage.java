package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class newPage extends BasePage {

    public newPage(WebDriver driver) {
        super(driver);
    }



    public void selectLead() throws InterruptedException {
    	getLeadRowData("LEAD-0976", "Meghana").click();
    }

    // 🔥 Generic method to get field using label (IMPORTANT)
    public By getField(String label) {
        return By.xpath("//span[text()='" + label + "']/following::span[1]");
    }

    // 🔥 Stable Double Click (handles stale element)
    public void doubleClick(By element) {
        for (int i = 0; i < 2; i++) {
            try {
                WebElement el = wait.until(
                        ExpectedConditions.elementToBeClickable(element)
                );
                new Actions(driver).doubleClick(el).perform();
                return;
            } catch (StaleElementReferenceException e) {
                System.out.println("Retrying double click...");
            }
        }
    }

    // 🔥 Universal Edit Method (handles both dropdown & textbox)
    public void editField(String label, String type, String value) throws InterruptedException {

        By field = By.xpath("//span[text()='" + label + "']/following::span[1]");

        if (type.equalsIgnoreCase("dropdown")) {

            doubleClick(field);

            By option = By.xpath("//div[normalize-space()='" + value + "']");
            wait.until(ExpectedConditions.visibilityOfElementLocated(option));
            click(option);

        } else if (type.equalsIgnoreCase("textbox")) {

            click(field);

            // ✅ FIXED locator (scoped)
            By input = By.xpath("//span[text()='" + label + "']/ancestor::div[contains(@class,'grid')]//input");

            WebElement el = wait.until(
                ExpectedConditions.visibilityOfElementLocated(input)
            );

            el.sendKeys(Keys.CONTROL + "a");
            el.sendKeys(Keys.DELETE);
            el.sendKeys(value);
            el.sendKeys(Keys.ENTER);
        }
    }
    public void editPhone(String label, String phone, String ext) throws InterruptedException {

        // Step 1: Click correct field (Contact / Alternate)
        By field = By.xpath("//span[text()='" + label + "']/following::span[1]");
        click(field);

        // Step 2: Wait for popup
        By phone_input = By.xpath("//input[@placeholder='Phone number']");
        By ext_input = By.xpath("//input[@placeholder='Extension']");

        WebElement phoneEl = wait.until(
            ExpectedConditions.visibilityOfElementLocated(phone_input)
        );

        WebElement extEl = wait.until(
            ExpectedConditions.visibilityOfElementLocated(ext_input)
        );

        // Step 3: Clear & enter values
        phoneEl.sendKeys(Keys.CONTROL + "a");
        phoneEl.sendKeys(Keys.DELETE);
        phoneEl.sendKeys(phone);

        extEl.sendKeys(Keys.CONTROL + "a");
        extEl.sendKeys(Keys.DELETE);
        extEl.sendKeys(ext);

        // Step 4: Click Save
        By save_btn = By.xpath("//button//div[text()='Save']");
        click(save_btn);
    }

    // 🔥 Updated profile method (CLEAN & DYNAMIC)
    public void profile_info() throws InterruptedException {

        editField("Salutation", "dropdown", "Ms");
        pause();
        editField("Full Name", "textbox", "Meghana");
        pause();
        editField("Email", "textbox", "meghanar@yopmail.com");
        pause();
        editPhone("Contact Number", "8586958697", "567");
        pause();
        editPhone("Alternate Number", "6789356478", "526");
        pause();
        editField("Preferred Channel", "dropdown", "Phone");
        pause();
        editField("Website", "textbox", "https://meghanam.com");
        pause();
    }
    public void Company_Info() throws InterruptedException {

        editField("Company Name", "textbox", "Hitech Pearl");
        pause();
        editField("Designation", "textbox", "Full Stack developer");
        pause();
        editField("Company Size", "dropdown", "Small Business (11-50)");
        pause();
        editField("Industry Type", "dropdown", "Consulting");
        pause();
    }
    public void Lead_Info() throws InterruptedException {

        editField("Lead Owner", "dropdown", "Saikumarballa");
        pause();
        editField("Status", "dropdown", "New");
        pause();
        editField("Source", "dropdown", "Referral");
        pause();
    }
}