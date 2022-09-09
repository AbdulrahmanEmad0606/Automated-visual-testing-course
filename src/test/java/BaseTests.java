import com.applitools.eyes.selenium.Eyes;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.testng.annotations.BeforeMethod;

public class BaseTests {
    protected WebDriver driver;
    protected static Eyes eyes;
    @BeforeMethod
    public void setUp() {
        // to get test properties file content
        Properties props=System.getProperties();
        try {
            props.load(new FileInputStream(new File("Resources/test.properties")));
        }
        catch (Exception e){
            e.printStackTrace();
            System.exit(-1);
        }
        WebDriverManager.chromedriver().setup();
        initiateEyes();
        driver.get("https://www.google.com");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    private static void initiateEyes(){
        eyes = new Eyes();
        eyes.setApiKey(System.getProperty("applitools.api.key"));
    }

}
