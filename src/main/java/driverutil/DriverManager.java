package driverutil;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private DriverManager(){
    }
    private static ThreadLocal<WebDriver> threadlocal=new ThreadLocal();

    public static WebDriver getDriver(){
        return threadlocal.get();
    }

    public static void unload(){
        threadlocal.remove();
    }

    public static void setDriver(WebDriver driverRef){
        threadlocal.set(driverRef);
    }
}
