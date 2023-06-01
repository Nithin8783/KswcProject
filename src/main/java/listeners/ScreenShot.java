package listeners;

import base.BaseTest;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import constants.Constants;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

public class ScreenShot  {

    public static String getScreenShot(ITestResult result , ExtentTest test, WebDriver driver) throws IOException {
        test.fail(MarkupHelper.createLabel(result.getMethod().getMethodName().toString(), ExtentColor.RED));
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(Constants.ScreenShort_PATH);
        String path = dest.getAbsolutePath();
        FileUtils.copyFile(source,dest);
        byte[] byteImage = IOUtils.toByteArray(new FileInputStream(path));
        return Base64.getEncoder().encodeToString(byteImage);

    }

}
