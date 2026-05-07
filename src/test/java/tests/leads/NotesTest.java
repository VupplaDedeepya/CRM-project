package tests.leads;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.leads.NotesPage;
import pages.userOnboarding.LoginPage;
import pages.userOnboarding.chooseWorkPlacePage;

public class NotesTest extends BaseTest{
 
  public void login() throws InterruptedException {
	  LoginPage lp = new LoginPage(driver);
	  lp.login();
	  chooseWorkPlacePage cws = new chooseWorkPlacePage(driver);
	  cws.ClickNext();
  }
  @Test(priority=1,groups= {"sanity"})
  public void note() throws InterruptedException {
	  login();
	  NotesPage np = new NotesPage(driver);
	  np.selectLead();
	  np.note_tab();
	  np.Add_note("Schedule a meeting with Lead");
	  np.choose_alignment("Align Left");
	  np.select_dateAndtime("25", "10","45", "AM");
	  np.submit();
	 /* np.edit_note();
	  np.add_comment();
	  np.delete_note();
	  */
	 // np.edit_comment();
	 // np.delete_cmt();
  }
}
