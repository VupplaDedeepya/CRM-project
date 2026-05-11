package tests.deals;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.deals.TaskPage;
import pages.userOnboarding.LoginPage;
import pages.userOnboarding.chooseWorkPlacePage;

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
	  TaskPage tp = new TaskPage(driver);
	  tp.dealTab();
  }
  @Test(priority=3,description="select a particular deal")
  public void select_deal() {
	  TaskPage tp = new TaskPage(driver);
	  tp.selectDeal();
  }
  @Test(priority=4,description="add a task")
  public void addTask() throws InterruptedException {
	  TaskPage tp = new TaskPage(driver);
	  tp.task_tab();
	  tp.add_task();
  }
}
