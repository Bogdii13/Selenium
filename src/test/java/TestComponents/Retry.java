package TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    int count = 0;
    int maxRetryCount = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (count < maxRetryCount) {
            count++;
            return true;
        }
        return false;
    }
}
