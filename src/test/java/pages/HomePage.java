package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage{

    @FindBy(xpath = "//h3[contains(text(),'Notification/Circular From Head Office')]")
    private WebElement tv_notification;

    @FindBy(xpath = "//span[text()='Farmer']")
    private WebElement tv_farmer;
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver , this);
    }

    public HomePage validateNotificationText(){
        tv_notification.isDisplayed();
        return this;
    }

    public void clickOnFarmerTab(){
        tv_farmer.click();
    }
}
