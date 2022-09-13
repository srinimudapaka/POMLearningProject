import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;

import java.sql.SQLOutput;
import java.util.Properties;

public class TC02_ValidateAccountPageDisplayed extends driverFactory{
    configReader configreader = new configReader();
    Properties prop = configreader.init_prop();
    String appUrl = prop.getProperty("url");
    LoginPage loginPage;
    AccountPage accountPage;

   // static WebDriver driver;
   @BeforeMethod
   public void setUp(){
       loginPage = new LoginPage(driver);
       accountPage = new AccountPage(driver);
   }

    @Test
    public void ValidateAccountPage() throws Throwable {
        driver.get(appUrl);
        loginPage.enterUserEmail("srinivas.mudapaka@gmail.com");
        loginPage.enterUserPassword("Pravallika@2603");
        loginPage.clickLoginBtn();
        //wait
        loginPage.enterUserPinConfirm();
        loginPage.clickContinueButton();
        String strAccountPagetitle = loginPage.ValidateLoginPageDisplayed();
        if (strAccountPagetitle == "OpenCart - Your Account") {
            System.out.println("AccountPage is displayed");
        }
    }

}
