package pages;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Page extends BaseTest{
    private static ThreadLocal<WebDriver> thread = new ThreadLocal<>();

    public Page(){
        PageFactory.initElements(thread.get(),this);
    }
}
