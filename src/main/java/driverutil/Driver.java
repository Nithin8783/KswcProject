package driverutil;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.PropertyFile;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){}
   static WebDriverWait wait;
    public static WebDriver inItDiver() throws IOException {
        if(Objects.isNull(DriverManager.getDriver())) {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            DriverManager.setDriver(driver);
            DriverManager.getDriver().get(PropertyFile.getProperty("url"));
            driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
            wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("card-body")));
        }
        return DriverManager.getDriver();
    }

    public static void quitDriver(){
        if(Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
