package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.Onboarding;

public class signupTest extends BaseTest{
    @Test(priority=1)
    void signup_page() throws InterruptedException {
    	Onboarding ob = new Onboarding(driver);
    	ob.signup("bhushan","bhushan@yopmail.com","Abcdef@12345");
    	ob.enter_otp("bhushan@yopmail.com");
    	ob.login("bhushan@yopmail.com","Abcdef@12345");
    	ob.workspace("bizaquity");
    }
}
