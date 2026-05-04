package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.ForgotPasswordPage;

public class ForgotPswdTest extends BaseTest{

	@Test(priority=1)
	void forgot_pswd() throws InterruptedException {
		ForgotPasswordPage fpp = new ForgotPasswordPage(driver);
		fpp.click_forgot_pswd("dedeepya@yopmail.com");
		fpp.enter_otp("dedeepya@yopmail.com");
		fpp.new_password("Dedeepya@180204");
	}
}
