package tests.deals;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.deals.NotesPage;
import pages.userOnboarding.LoginPage;
import pages.userOnboarding.chooseWorkPlacePage;

public class NotesTest extends BaseTest{
	public class TaskTest extends BaseTest{
		  @Test(priority=1,description="login")
		  public void login() throws InterruptedException{
			  LoginPage lp = new LoginPage(driver);
			  lp.login();
			  chooseWorkPlacePage cwsp = new chooseWorkPlacePage(driver);
			  cwsp.ClickNext();
		  }
		  @Test(priority=2,description="navigate to deals tab")
		  public void deals() throws InterruptedException {
			  NotesPage np = new NotesPage(driver);
			  np.deals_tab();
		  }
		  @Test(priority=3,description="select a particular deal")
		  public void select_deal() {
			  NotesPage np = new NotesPage(driver);
			  np.selectDeal();
		  }
		  @Test(priority=4,description="add a note")
		  public void addTask() throws InterruptedException {
			  NotesPage np = new NotesPage(driver);
			  np.notes_tab();
			  np.add_notes();
		  }
	}
}
