package BaseTest;

import Practise.pageobjects.Landing_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public Landing_Page landingP;

    public WebDriver IntializeDriver(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;

    }
    @BeforeMethod
    public Landing_Page launchApplication(){
        driver = IntializeDriver();
        landingP = new Landing_Page(driver);
        landingP.goTo();
        return landingP;
    }
    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }
}
