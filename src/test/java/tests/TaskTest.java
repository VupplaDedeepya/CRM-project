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
	  tp.add_task();
  }
}
