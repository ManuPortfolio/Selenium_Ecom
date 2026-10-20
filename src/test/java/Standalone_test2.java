import Practise.pageobjects.*;
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

public class Standalone_test2 {

    @Test
    public void Demo() throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        String Productname = "ZARA COAT 3";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        Landing_Page landingP = new Landing_Page(driver);
        landingP.goTo();
        Productcatlogue productcatlogue = landingP.Login("risom21901@hudzer.com", "Qwe@1234");
        String loginconfirm = productcatlogue.LoginAssert();
        Assert.assertEquals(loginconfirm, "AUTOMATION");
        List<WebElement> Cards = productcatlogue.getproductList();
        Cart_Page cartpage = productcatlogue.addToCart(Productname);
        String cartText = cartpage.CartText();
        Assert.assertEquals(cartText, "My Cart");


        Boolean match = cartpage.VerifyProductDisplay(Productname);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartpage.goTocheckout();
        String paymentT = checkoutPage.paymentTitle();
        Assert.assertEquals(paymentT, "Payment Method");
        checkoutPage.setSelectCountry("india");
        ConfirmationPage confirmationPage =  checkoutPage.clickFinalCheckBtn();

                String congetText = confirmationPage.getTextorder();
        Assert.assertEquals(congetText, "THANKYOU FOR THE ORDER.");
        driver.close();

    }
}
