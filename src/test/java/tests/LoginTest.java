package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtils;

public class LoginTest extends BaseTest{
   @Test
   void login() throws IOException, InterruptedException {
	   LoginPage lp = new LoginPage(driver);
	   String path = "src/test/resources/CRM Testcases.xlsx";
       // Load Excel
       ExcelUtils.loadExcel(path, "login");
       int rows = ExcelUtils.getRowCount();
       System.out.println(rows);
       for (int i = 1; i <= rows; i++) {
           String email = ExcelUtils.getCellData(i, 1);
           String password = ExcelUtils.getCellData(i, 2);
           String expected = ExcelUtils.getCellData(i, 3);
           lp.clearinputs();
       lp.loginWithArgs(email, password);
       String buttonState = lp.btndisabled();
    // ❗ Only click if enabled
    if (buttonState.equalsIgnoreCase("enabled")) {
        lp.clickLogin();
    }
       String error = lp.isErrorDisplayed()? "Invalid credentials" : "valid credentials";
       if(expected.equalsIgnoreCase(lp.btndisabled())) {
    	   ExcelUtils.setCellData(path, i, 4, "Pass");
    	   ExcelUtils.fillGreenColor(path, i, 4);
    	   System.out.println("passed");
    	   
       }
       else if(expected.equals(error)){
       	   ExcelUtils.setCellData(path, i, 4, "Pass");
    	   ExcelUtils.fillGreenColor(path, i, 4);
    	   System.out.println("passed");
    	   
       }
       else if (expected.equalsIgnoreCase(lp.loginSuccess())) {
    	   System.out.println(lp.loginSuccess());
      	   ExcelUtils.setCellData(path, i, 4, "Pass");
    	   ExcelUtils.fillGreenColor(path, i, 4);
    	   System.out.println("passed");
    	   
       }
       else {
      	 
       }
   }
}
}
