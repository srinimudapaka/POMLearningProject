package pages;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.sql.SQLOutput;

public class LoginPage {
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
        if (driver.findElement(userEmail).isDisplayed()) {
            System.out.println("Email field is available in Login Page");
        }
    }

    public void enterUserEmail() {
        if (driver.findElement(userEmail).isDisplayed()) {
            driver.findElement(userEmail).sendKeys("srinivas.mudapaka@gmail.com");
        }
    }
    public void enterUserPassword(){
        driver.findElement(userPassword).sendKeys("Pravallika@2603");
    }
    public void clickLoginBtn(){
        driver.findElement(loginButton).click();
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
