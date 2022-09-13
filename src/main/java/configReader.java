import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configReader {
    private Properties prop;

    /**
     * This Method is used to load the properties from config.properties file
     *
     * @return prop
     */

    @BeforeSuite
    public Properties init_prop() {
        prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\srinivas.mudapaka\\IdeaProjects\\POMProject\\src\\main\\resources\\config.properties");
            try {
                prop.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //driverFactory driverfactory = new driverFactory();
        //driverfactory.init_driver(prop.getProperty("browser"));
        return prop;
    }

    public String getReportConfigPath(){
        String reportConfigPath = prop.getProperty("reportconfigpath");
        if(reportConfigPath!= null) return reportConfigPath;
        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }

}
