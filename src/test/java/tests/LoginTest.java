package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(retryAnalyzer = listeners.RetryAnalyzer.class)
    public void validateUserAbleToLogin() throws Exception {
        new LoginPage(driver)
                .loginToApplication()
                .validateNotificationText()
                .clickOnFarmerTab();
    }
}
