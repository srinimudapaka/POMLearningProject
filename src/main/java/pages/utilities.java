package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class utilities  {

    public WebDriver driver;

    public void waitForElement(WebDriver driver, WebElement Element) {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(Element));
    }

    //method for explicit wait for element until visible
    public boolean visibilityOfElementWait(WebDriver driver,WebElement Element) {
        if (Element != null) {
            try {
                WebDriverWait wait = new WebDriverWait(driver,50);
                wait.until(ExpectedConditions.visibilityOf(Element));
                return true;
            } catch (Exception e) {
                return false;
            }
        } else
            //  Logger.logError("PageElement " + webElement.getText() + " not exist");
            return false;
    }

    //method for explicit wait for element to click
    public boolean waitforelementtobeclickable(WebDriver driver,WebElement Element) {
        if (Element != null) {
            try {
                WebDriverWait wait = new WebDriverWait(driver,50);
                wait.until(ExpectedConditions.elementToBeClickable(Element));
                return true;
            } catch (Exception e) {
                return false;
            }
        } else
            //  Logger.logError("PageElement " + webElement.getText() + " not exist");
            return false;
    }


    public boolean type(WebElement Element, String testdata) throws Throwable {
        boolean flag = false;
        try {
            Element.clear();
            Thread.sleep(500);
            Element.sendKeys(testdata);
            flag = true;
            Thread.sleep(100);
            //logger.pass("Data typing action is performed on " + locatorName + " with data " + testdata.replace(":", ""));
        } catch (Exception e) {
            e.printStackTrace();
            //logger.fail("Data typing action is not perform on " + locatorName);
            //failureReport(locatorName, "Data typing action is performed on " + locatorName + " with data " + testdata.replace(":", ""));
        }
        return flag;
    }

    public boolean click(WebElement Element) throws Throwable {
        boolean flag = false;
        try {
            Element.click();
            //logger.pass("Successfully clicked on " + locatorName);
            //Reporter.addStepLog("SucessFully Click on "+locatorName);
            //successReport("Successfully clicked on " + locatorName);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            //logger.fail("Unable to clicked on " + locatorName);
            //failureReport(locatorName, "Unable to clicked on " + locatorName);
        }
        return flag;
    }

    public static void SelectDropDown(WebElement element, String Value, String type) {
        Select select = new Select(element);
        switch (type.toLowerCase()) {
            case "index":
                try {
                    select.selectByIndex(Integer.parseInt(Value));
                } catch (NoSuchElementException e) {
                    System.out.println("Element " + element + " is not found in DOM " + e.getStackTrace());
                }
                break;

            case "value":
                try {
                    select.selectByValue(Value);
                } catch (NoSuchElementException e) {
                    System.out.println("Element " + element + " is not found in DOM " + e.getStackTrace());
                }
                break;
            case "visibletext":
                try {
                    select.selectByVisibleText(Value);
                } catch (NoSuchElementException e) {
                    System.out.println("Element " + element + " is not found in DOM " + e.getStackTrace());
                }
                break;
            default:
                System.out.println("Please select correct value");
        }

    }

}


