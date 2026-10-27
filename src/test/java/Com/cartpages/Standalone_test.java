package Com.cartpages;

import Practise.pageobjects.Landing_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.List;

public class Standalone_test {

    @Test
    public void Demo() {


        WebDriver driver = new ChromeDriver();
        String Productname = "ZARA COAT 3";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/client");
        driver.manage().window().maximize();
        driver.findElement(By.id("userEmail")).sendKeys("risom21901@hudzer.com");
        driver.findElement(By.id("userPassword")).sendKeys("Qwe@1234");
        driver.findElement(By.id("login")).click();

        Landing_Page loginPage = new Landing_Page(driver);

        WebElement dashboard = driver.findElement(By.xpath("/html/body/app-root/app-dashboard/app-sidebar/nav/label[1]/div/a/div/h3"));
        Assert.assertEquals(dashboard.getText(), "AUTOMATION");

        List<WebElement> Cards =  driver.findElements(By.cssSelector(".mb-3"));

        WebElement Prod = Cards.stream().filter(Card -> Card.findElement(By.cssSelector("b")).
                getText().equals(Productname)).findFirst().orElse(null);
        Prod.findElement(By.cssSelector("button[class = 'btn w-10 rounded']")).click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-container")));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

        WebElement cartV = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-profile[1]/div[1]/div[1]/h1[1]"));
        Assert.assertEquals(cartV.getText(), "My Cart");

        List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
        Boolean prod_tru = cartProducts.stream().anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(Productname));
        Assert.assertTrue(prod_tru);

        driver.findElement(By.cssSelector(".totalRow button")).click();

        WebElement fin_pay = driver.findElement(By.cssSelector("div[class = 'payment__title']"));
        Assert.assertEquals(fin_pay.getText(), "Payment Method");

//.form-group input
        Actions a = new Actions(driver);
        a.sendKeys(driver.findElement(By.cssSelector(".form-group input")),"india").build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(@class, 'ta-item')])[2]"))).click();
        driver.findElement(By.cssSelector(".btnn")).click();

        WebElement succ_Order = driver.findElement(By.cssSelector("h1[class = 'hero-primary']"));
        Assert.assertEquals(succ_Order.getText(), "THANKYOU FOR THE ORDER.");
        driver.close();

    }
}
