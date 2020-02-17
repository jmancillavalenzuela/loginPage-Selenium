package scenarios;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;


public class webSetup {
    public WebDriver driver;
    
    @BeforeClass(alwaysRun = true)
    public void setUp(){
       //System.setProperty("webdriver.gecko.driver", "/Users/macbookpro/eclipse-workspace/Selenium-TestLoginPage/driver/geckodriver");
       WebDriverManager.firefoxdriver().setup();
       driver = new FirefoxDriver();
       driver.manage().window().maximize(); 
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    @AfterClass
    public void quit() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	driver.quit();
    }
} 