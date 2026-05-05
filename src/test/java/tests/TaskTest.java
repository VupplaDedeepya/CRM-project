package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.TaskPage;
import pages.chooseWorkPlacePage;

public class TaskTest extends BaseTest{
  @Test(priority=1)
  void login() throws InterruptedException {
	  LoginPage lp = new LoginPage(driver);
	  lp.login();
	  chooseWorkPlacePage cws = new chooseWorkPlacePage(driver);
	  cws.ClickNext();
  }
  @Test(dependsOnMethods="login")
  void addTask() throws InterruptedException {
	  TaskPage tp = new TaskPage(driver);
	  tp.selectLead();
	  tp.task_tab();
	 // tp.add_task();
	  //tp.edit_task();
	  tp.delete_task();
  }
}
