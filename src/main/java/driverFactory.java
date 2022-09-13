import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class driverFactory {
    public WebDriver driver;

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    /**
     * This method is used to initialize the thradlocal driver on the basis of
     * given browser
     *
     * @param browser
     * @return this will return tldriver
     */

    @BeforeMethod
    @Parameters({"browser"})
    public WebDriver init_driver(String browser) {

        System.out.println("browser value is: " + browser);

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            this.driver = new ChromeDriver();
        } else if (browser.equals("IeEdge")) {
            WebDriverManager.edgedriver().setup();
            this.driver = new EdgeDriver();
        } else if (browser.equals("safari")) {
            tlDriver.set(new SafariDriver());
        } else {
            System.out.println("Please pass the correct browser value: " + browser);
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        return driver;

    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}

