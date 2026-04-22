package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.NotesPage;
import pages.chooseWorkPlacePage;

public class NotesTest extends BaseTest{
  @Test(priority = 1)
  void login() throws InterruptedException {
	  LoginPage lp = new LoginPage(driver);
	  lp.login();
	  chooseWorkPlacePage cws = new chooseWorkPlacePage(driver);
	  cws.ClickNext();
  }
  @Test(priority=2,dependsOnMethods="login")
  void note() throws InterruptedException {
	  NotesPage np = new NotesPage(driver);
	  np.selectLead();
	  np.Add_note("Schedule a meeting with Lead");
	  np.choose_alignment("Align Left");
	  np.select_dateAndtime("25", "10","45", "AM");
	  np.submit();
  }
}
