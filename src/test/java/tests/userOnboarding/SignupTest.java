package tests.userOnboarding;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.userOnboarding.Onboarding;

public class SignupTest extends BaseTest{
    @Test(priority=1,groups= {"sanity"})
    public void signup_page() throws InterruptedException {
    	Onboarding ob = new Onboarding(driver);
    	ob.signup("abhishek","abhishek@yopmail.com","Abcdef@12345");
    	ob.enter_otp("abhishek@yopmail.com");
    	ob.login("abhishek@yopmail.com","Abcdef@12345");
    	ob.workspace("apptagram");
    }
}
