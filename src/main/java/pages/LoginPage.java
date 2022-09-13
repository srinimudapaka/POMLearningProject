package pages;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.sql.SQLOutput;

public class LoginPage extends utilities {
    WebDriver driver;
    //Locators
    private By userEmail = By.cssSelector("input#input-email");
    private By userPassword = By.cssSelector("input#input-password");
    private By loginButton=By.xpath("//button[@class='btn btn-primary btn-lg hidden-xs']");
    private By pinConfirm=By.cssSelector("input#input-pin");
    private By continueButton=By.cssSelector("button[type='submit'][class='btn btn-primary btn-lg']");

    //Constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    //Methods
    public void validateUserEmail() {
        if (visibilityOfElementWait(driver, driver.findElement(userEmail))) {
            System.out.println("Email field is available in Login Page");
        }
    }

    public void enterUserEmail(String emailadress) throws Throwable {

           if (driver.findElement(userEmail).isDisplayed()){
               type(driver.findElement(userEmail),emailadress);
           }
        }

    public void enterUserPassword(String password) throws Throwable {
       // driver.findElement(userPassword).sendKeys("Pravallika@2603");
        type(driver.findElement(userPassword),password);
    }
    public void clickLoginBtn() throws Throwable {
      //  driver.findElement(loginButton).click();
        waitforelementtobeclickable(driver,driver.findElement(loginButton));
        click(driver.findElement(loginButton));
    }
    public void enterUserPinConfirm(){
        driver.findElement(pinConfirm).sendKeys("0810");
    }
    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }
    public String ValidateLoginPageDisplayed(){
        String title = driver.getTitle();
        return title;

    }
}
