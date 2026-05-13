package utils;

public class TestResultData {

    String testName;
    String status;
    String time;

    public TestResultData(String testName,
                          String status,
                          String time) {

        this.testName = testName;
        this.status = status;
        this.time = time;
    }

    public String getTestName() {
        return testName;
    }

    public String getStatus() {
        return status;
    }

    public String getTime() {
        return time;
    }
}