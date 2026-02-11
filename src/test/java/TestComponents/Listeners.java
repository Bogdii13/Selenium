package TestComponents;

import Resources.ExtentReporterNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends BaseTest implements ITestListener {
    ExtentTest test;
    ExtentReports extent = ExtentReporterNG.getReportObject();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal();

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        test = extent.createTest(result.getName(), result.getMethod().getMethodName());
        extentTest.set(test); // unique thread id -> test
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        extentTest.get().log(Status.PASS, "Test Passed");

    }


    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        extentTest.get().fail(result.getThrowable());
        extentTest.get().log(Status.FAIL, "Test Failed");

        WebDriver failedDriver = null;
        try {
            Class<?> realClass = result.getTestClass().getRealClass();
            // Dacă driver-ul este în BaseTest, îl citim din superclasă.
            Class<?> driverOwner = realClass.getSuperclass();
            var driverField = driverOwner.getDeclaredField("driver");
            driverField.setAccessible(true);
            failedDriver = (WebDriver) driverField.get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (failedDriver != null) {
            try {
                String filePath = getScreenshot(result.getMethod().getMethodName(), failedDriver);
                extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        extentTest.get().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
        extentTest.get().fail(result.getThrowable());
        extentTest.get().log(Status.FAIL, "Test Failed");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
        extentTest.get().fail(result.getThrowable());
        extentTest.get().log(Status.FAIL, "Test Failed");
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);

    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        extent.flush();
    }
}
