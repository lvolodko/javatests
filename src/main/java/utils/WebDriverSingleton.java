package utils;

import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {
    private static final Logger LOG = Logger.getLogger(WebDriverSingleton.class);
    private static WebDriver instance;

    private WebDriverSingleton(){
    }

    public static WebDriver getInstance(){
        if (instance!=null){
            return instance;
        }
        return instance = init();
    }

    private static WebDriver init() {
        /*System.setProperty("webdriver.chrome.driver",".\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			*/
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static void kill(){
        if (instance!=null){
            try {
                instance.quit();
            } catch (Exception e){
                LOG.info("Cannot kill browser");
            }
            finally {
                instance = null;
            }
        }
    }
}
