package AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;
import java.time.Duration;

public class AbstractCom {

        WebDriver driver;

    public AbstractCom(WebDriver driver) {
        this.driver = driver;
    }

    public void Waitforelementtoappear(By findBy){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
        }



        public void Waitforelementtodissapear(WebElement ele) throws InterruptedException {

            //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            //wait.until(ExpectedConditions.invisibilityOf(ele));
            Thread.sleep(4000);
        }


}
