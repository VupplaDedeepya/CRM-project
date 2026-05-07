package tests.leads;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.leads.TaskPage;
import pages.userOnboarding.LoginPage;
import pages.userOnboarding.chooseWorkPlacePage;

public class TaskTest extends BaseTest{
  
  public void login() throws InterruptedException {
	  LoginPage lp = new LoginPage(driver);
	  lp.login();
	  chooseWorkPlacePage cws = new chooseWorkPlacePage(driver);
	  cws.ClickNext();
  }
  @Test(priority=1,groups= {"sanity"})
  public void addTask() throws InterruptedException {
	  login();
	  TaskPage tp = new TaskPage(driver);
	  tp.selectLead();
	  tp.task_tab();
	  tp.add_task();
	  //tp.edit_task();
	  //tp.delete_task();
  }
}
