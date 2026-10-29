package Com.cartpages;

import BaseTest.BaseTest;
import Practise.pageobjects.Cart_Page;
import Practise.pageobjects.Productcatlogue;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ErrorValidationsTest extends BaseTest {

    @Test
    public void LoginErrorValidation()  {

        String Productname = "ZARA COAT 3";
        Productcatlogue productcatlogue = landingP.Login("risom21901@hudzer.com", "Qwe@");
        Assert.assertEquals("Incorrect email or password.", landingP.getErrorMessage());
        System.out.println("Login Errror Done");
    }

    @Test
    public void AddErrorValdiation() throws InterruptedException {

        String Productname = "ZARA COAT 3";
        Productcatlogue productcatlogue = landingP.Login("jaboles232@hiringview.com", "Qwe@1234");
        String loginconfirm = productcatlogue.LoginAssert();
        Assert.assertEquals(loginconfirm, "AUTOMATION");
        List<WebElement> Cards = productcatlogue.getproductList();
        Cart_Page cartpage = productcatlogue.addToCart(Productname);
        String cartText = cartpage.CartText();
        Assert.assertEquals(cartText, "My Cart11");
        System.out.println(cartText);
    }
}
