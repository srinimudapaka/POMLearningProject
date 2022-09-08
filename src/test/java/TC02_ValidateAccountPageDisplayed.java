import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;

import java.sql.SQLOutput;
import java.util.Properties;

public class TC02_ValidateAccountPageDisplayed {
    configReader configreader = new configReader();
    Properties prop = configreader.init_prop();
    String appUrl = prop.getProperty("url");
    private LoginPage loginPage = new LoginPage(driverFactory.getDriver());
    private AccountPage accountPage = new AccountPage(driverFactory.getDriver());

    static WebDriver driver;

    @Test
    public void ValidateAccountPage() {
        driverFactory.getDriver().get(appUrl);
        loginPage.enterUserEmail();
        loginPage.enterUserPassword();
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
