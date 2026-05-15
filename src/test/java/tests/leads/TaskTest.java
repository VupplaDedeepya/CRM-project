package tests.leads;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.leads.TaskPage;
import pages.userOnboarding.LoginPage;
import pages.userOnboarding.chooseWorkPlacePage;

public class TaskTest extends BaseTest{
  @Test(priority=1,description="login")
  public void login() throws InterruptedException {
	  LoginPage lp = new LoginPage(driver);
	  lp.login();
	  chooseWorkPlacePage cws = new chooseWorkPlacePage(driver);
	  cws.ClickNext();
  }
  @Test(priority=2)
  public void lead() {
	  TaskPage tp = new TaskPage(driver);
	  tp.selectLead();
  }
  @Test(priority=3,groups= {"sanity"})
  public void addTask() throws InterruptedException {
	  //login();
	  TaskPage tp = new TaskPage(driver);
	 // tp.selectLead();
	  tp.task_tab();
	  tp.add_task();
	  //tp.edit_task();
	  //tp.delete_task();
  }
}
