package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LeadFormPage;
import pages.LoginPage;
import pages.chooseWorkPlacePage;

public class CreateLeadTest extends BaseTest {

    // Common login step
    public void doLogin() throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        lp.login();
        System.out.println("login successful");

        chooseWorkPlacePage cwp = new chooseWorkPlacePage(driver);
        cwp.ClickNext();
        System.out.println("workspace selected");
    }

    // 🔥 SCENARIO 1: Only required fields
    @Test(priority = 1, groups = {"sanity"})
    public void createLead_WithOnlyRequiredFields() throws InterruptedException {

        doLogin();

        LeadFormPage lead = new LeadFormPage(driver);

        lead.ClickCreateLead();
        lead.submitWithOnlyRequiredFields();

        System.out.println("Lead created with only required fields");
    }

    // 🔥 SCENARIO 2: Full form submission
    @Test(priority = 2, groups = {"regression"})
    public void createLead_WithAllDetails() throws InterruptedException {


        LeadFormPage lead = new LeadFormPage(driver);

        lead.submitWithAllDetails();

        System.out.println("Lead created with full details");
    }
}