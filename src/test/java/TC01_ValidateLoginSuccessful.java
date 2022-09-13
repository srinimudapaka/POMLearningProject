import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.Properties;

public class TC01_ValidateLoginSuccessful extends driverFactory{
    configReader configreader = new configReader();
    Properties prop = configreader.init_prop();
    String appUrl = prop.getProperty("url");
    LoginPage loginPage;
    
    //static WebDriver driver;
    @BeforeMethod
    public void setUp(){
        loginPage = new LoginPage(driver);
    }
    @Test
    public void launchApplication () throws Throwable {
        driver.get(appUrl);
        loginPage.validateUserEmail();
        loginPage.enterUserEmail("srinivas.mudapaka@gmail.com");
        loginPage.enterUserPassword("Pravallika@2603");
        loginPage.clickLoginBtn();
        //wait
        loginPage.enterUserPinConfirm();
        loginPage.clickContinueButton();
       // String strLogin = loginPage.ValidateLoginPageDisplayed();
       // if strLogin


    }




}
