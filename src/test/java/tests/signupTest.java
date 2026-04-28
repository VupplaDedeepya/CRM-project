package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.Onboarding;

public class signupTest extends BaseTest{
    @Test(priority=1)
    void signup_page() throws InterruptedException {
    	Onboarding ob = new Onboarding(driver);
    	ob.signup("abhishek","abhishek@yopmail.com","Abcdef@12345");
    	ob.enter_otp("abhishek@yopmail.com");
    	ob.login("abhishek@yopmail.com","Abcdef@12345");
    	ob.workspace("apptagram");
    }
}
