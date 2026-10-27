package Com.cartpages;

import BaseTest.BaseTest;
import Practise.pageobjects.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Standalone_test2 extends BaseTest {

    @Test
    public void Demo() throws InterruptedException {

        String Productname = "ZARA COAT 3";
        Productcatlogue productcatlogue = landingP.Login("risom21901@hudzer.com", "Qwe@1234");
        String loginconfirm = productcatlogue.LoginAssert();
        Assert.assertEquals(loginconfirm, "AUTOMATION");
        List<WebElement> Cards = productcatlogue.getproductList();
        Cart_Page cartpage = productcatlogue.addToCart(Productname);
        String cartText = cartpage.CartText();
        Assert.assertEquals(cartText, "My Cart");
        System.out.println(cartText);


        Boolean match = cartpage.VerifyProductDisplay(Productname);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartpage.goTocheckout();
        String paymentT = checkoutPage.paymentTitle();
        Assert.assertEquals(paymentT, "Payment Method");
        checkoutPage.setSelectCountry("india");
        ConfirmationPage confirmationPage =  checkoutPage.clickFinalCheckBtn();

                String congetText = confirmationPage.getTextorder();
        Assert.assertEquals(congetText, "THANKYOU FOR THE ORDER.");
        System.out.println(congetText);
        driver.close();

    }
}
