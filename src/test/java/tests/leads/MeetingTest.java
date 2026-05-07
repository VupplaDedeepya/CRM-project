package tests.leads;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.leads.MeetingPage;
import pages.userOnboarding.LoginPage;
import pages.userOnboarding.chooseWorkPlacePage;

public class MeetingTest extends BaseTest{

  public void login() throws InterruptedException{
	  LoginPage lp = new LoginPage(driver);
	  lp.login();
	  chooseWorkPlacePage cws = new chooseWorkPlacePage(driver);
	  cws.ClickNext();
  }
  @Test(priority=1,groups= {"sanity"})
  public void addMeeting() throws InterruptedException {
	  login();
	  MeetingPage mp = new MeetingPage(driver);
	  mp.selectLead();
	  mp.navigate_meetingTab();
	  mp.Add_Meeting();
	  //mp.Log_meeting();
	 // mp.edit_meeting("05/12/2026");
	  //mp.delete_meeting();
  }
 
}
