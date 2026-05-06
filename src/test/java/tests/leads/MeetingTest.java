package tests.leads;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.leads.MeetingPage;
import pages.userOnboarding.LoginPage;
import pages.userOnboarding.chooseWorkPlacePage;

public class MeetingTest extends BaseTest{
  @Test(priority=1)
  void login() throws InterruptedException{
	  LoginPage lp = new LoginPage(driver);
	  lp.login();
	  chooseWorkPlacePage cws = new chooseWorkPlacePage(driver);
	  cws.ClickNext();
  }
  @Test(dependsOnMethods="login")
  void logMeeting() throws InterruptedException {
	  MeetingPage mp = new MeetingPage(driver);
	  mp.selectLead();
	  mp.navigate_meetingTab();
	  mp.Log_meeting();
	//  mp.Add_Meeting();
  }
}
