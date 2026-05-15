package tests.userOnboarding;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.userOnboarding.Onboarding;

public class SignupTest extends BaseTest{
    @Test(priority=1,groups= {"sanity"})
    public void signup_page() throws InterruptedException {
    	Onboarding ob = new Onboarding(driver);
    	ob.signup("pavani","pavani@yopmail.com","Abcdef@12345");
    	ob.enter_otp("pavani@yopmail.com");
    	ob.login("pavani@yopmail.com","Abcdef@12345");
    	ob.workspace("apptagram");
    }
}
