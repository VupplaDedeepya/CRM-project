package listeners;

import java.util.ArrayList;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utils.ExcelReportGenerator;
import utils.SendMail;
import utils.TestResultData;

public class TestListener implements ITestListener {

    public static List<TestResultData> results
            = new ArrayList<>();
    
    private void addResult(ITestResult result,String status) {

    		long executionTime =result.getEndMillis()- result.getStartMillis();

    		results.add(new TestResultData(result.getName(),status, executionTime + " ms"));
    		}
    
    @Override
    public void onTestSuccess(ITestResult result) {

    	 addResult(result, "PASS");
    }

    @Override
    public void onTestFailure(ITestResult result) {

    	addResult(result, "FAIL");
    }
    
    @Override
    public void onTestSkipped(ITestResult result) {

    	addResult(result, "SKIPPED");
    }
    @Override
    public void onStart(ITestContext context) {

        results.clear();
    }
    
    @Override
    public void onFinish(ITestContext context) {

        try {

            ExcelReportGenerator.generateReport();

            SendMail.sendEmail();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }
}