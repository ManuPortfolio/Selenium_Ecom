package AbstractComponents;

import Practise.pageobjects.Cart_Page;
import Practise.pageobjects.Orderpage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;
import java.time.Duration;

public class AbstractCom {

        WebDriver driver;

    public AbstractCom(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[routerlink*='myorders']")
    WebElement orderHeader;

    public void Waitforelementtoappear(By findBy){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
        }

    public void Waitforelementerrortoappear(WebElement findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }


    public Orderpage oderclickpage(){
        orderHeader.click();
        Orderpage orderpage = new Orderpage();
        return orderpage;
    }

        public void Waitforelementtodissapear(WebElement ele) throws InterruptedException {

            //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            //wait.until(ExpectedConditions.invisibilityOf(ele));
            Thread.sleep(4000);
        }


}
