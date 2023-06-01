package reports;

import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import org.testng.IReporter;
import org.testng.annotations.Listeners;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
public class ExtentReportHelper implements IReporter {
    //to change view order
//    ExtentSparkReporter spark = new ExtentSparkReporter("index.html").viewConfigurer().viewOrder().as(new ViewName[]{ViewName.TEST,ViewName.DASHBOARD,ViewName.CATEGORY}).apply();

   public static ExtentReports extent;
   static ExtentSparkReporter spark;
    public static void inItReports(){
        if(Objects.isNull(extent)) {
            extent = new ExtentReports();
            spark = new ExtentSparkReporter("report.html").viewConfigurer().viewOrder().as(new ViewName[]{ViewName.TEST,ViewName.CATEGORY, ViewName.DEVICE,ViewName.DASHBOARD}).apply();
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("Execution report");
            spark.config().setReportName("KSWC Project Report");
            extent.attachReporter(spark);
        }
    }

    public static void flushReport() throws IOException {
        extent.flush();
        Desktop.getDesktop().browse(new File("report.html").toURI());
    }

    public static void createTest(String testName){
        extent.createTest(testName);
    }
}
