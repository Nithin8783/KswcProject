package base;

import driverutil.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import reports.ExtentReportHelper;

import java.io.IOException;
@Listeners(listeners.ListenersUtil.class)

public class BaseTest {

    public WebDriver driver;

    WebDriverWait wait;

    @BeforeSuite
    public void setUp(){
        ExtentReportHelper.inItReports();
    }

    @BeforeMethod
    public void loginToApplication() throws IOException {
        Driver.inItDiver();
        driver = Driver.inItDiver();
    }

    @AfterMethod
    public void closeApplication(){
        Driver.quitDriver();
    }

    @AfterSuite
    public void flush() throws IOException {
        ExtentReportHelper.flushReport();
    }
}
