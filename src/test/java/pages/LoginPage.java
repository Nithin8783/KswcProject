package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class LoginPage {
    WebDriver driver;
    @FindBy(className = "card-body")
    private WebElement tv_loginHeader;

    @FindBy(className = "title")
    private WebElement tv_loginText;

    @FindBy(id = "LoginUserName")
    private WebElement tf_userName;

    @FindBy(id = "loginPassword")
    private WebElement tf_password;

    @FindBy(id = "imgshow")
    private WebElement iv_passwordEyeHide;

    @FindBy(className = "custom_style")
    private WebElement tv_captcha;

    @FindBy(xpath = "//input[@id='txt_manual_Input_captcha']")
    private WebElement tf_captcha;

    @FindBy(xpath = "//a[text()='Reset / Forgot Password']")
    private WebElement link_forgetPassword;

    @FindBy(id = "btn_kswc_sign_In")
    private WebElement btn_submit;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage enterUserName(){
        tf_userName.sendKeys("wm19019");
        return this;
    }

    public LoginPage enterPassword(){
        tf_password.sendKeys("Kswc@123");
        return this;
    }

    public String getCaptcha(){
       return tv_captcha.getText().toString();
    }

    public LoginPage enterCaptcha() throws AWTException {
        tf_captcha.click();
        tf_captcha.sendKeys(getCaptcha());
        return this;
    }

    public HomePage clickOnSubmit(){
        JavascriptExecutor js=((JavascriptExecutor)driver);
        js.executeScript("arguments[0].scrollIntoView(true);", btn_submit);
        btn_submit.click();
        return new HomePage(driver);
    }

    public HomePage loginToApplication() throws AWTException {
        enterUserName()
                .enterPassword()
                .enterCaptcha()
                .clickOnSubmit();
        return new HomePage(driver);
    }
}
