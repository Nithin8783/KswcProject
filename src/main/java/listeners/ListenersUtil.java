package listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import constants.Constants;
import driverutil.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import org.testng.internal.InvokedMethod;
import reports.ExtentReportHelper;
import utilities.PropertyFile;

import java.io.File;
import java.io.IOException;

public class ListenersUtil implements ITestListener , IInvokedMethodListener , ISuiteListener{
    ExtentTest test;
    WebDriver driver = Driver.inItDiver();

    public ListenersUtil() throws IOException {
    }

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        test = ExtentReportHelper.extent.createTest(result.getMethod().getMethodName().toString()).assignCategory("smoke").assignDevice("chrome");
        test.info(result.getMethod().getMethodName().toString()+ " Started Execution ");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        try {
            if(PropertyFile.getProperty("retryCount").equalsIgnoreCase("true")){
                new RetryAnalyzer().retry(result);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            test.fail("Failed", MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShot.getScreenShot(result,test,driver)).build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
        test.fail(result.getMethod().getMethodName().toString()+" got Failed with TimeOut");
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        IInvokedMethodListener.super.beforeInvocation(method, testResult);
       //System.out.println();
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        IInvokedMethodListener.super.afterInvocation(method, testResult);
        System.out.println();
//        }
        }
}
