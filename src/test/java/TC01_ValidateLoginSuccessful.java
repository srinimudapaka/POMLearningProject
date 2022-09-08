import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.Properties;

public class TC01_ValidateLoginSuccessful {
    configReader configreader = new configReader();
    Properties prop = configreader.init_prop();
    String appUrl = prop.getProperty("url");
    private LoginPage loginPage = new LoginPage(driverFactory.getDriver());
    
    static WebDriver driver;

    @Test
    public void launchApplication (){
        driverFactory.getDriver().get(appUrl);
        loginPage.validateUserEmail();
        loginPage.enterUserEmail();
        loginPage.enterUserPassword();
        loginPage.clickLoginBtn();
        //wait
        loginPage.enterUserPinConfirm();
        loginPage.clickContinueButton();
       // String strLogin = loginPage.ValidateLoginPageDisplayed();
       // if strLogin


    }




}
