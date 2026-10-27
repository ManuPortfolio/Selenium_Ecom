package Com.cartpages;

import BaseTest.BaseTest;
import Practise.pageobjects.Cart_Page;
import Practise.pageobjects.CheckoutPage;
import Practise.pageobjects.ConfirmationPage;
import Practise.pageobjects.Productcatlogue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ErrorValidations extends BaseTest {

    @Test
    public void Demo() throws InterruptedException {

        String Productname = "ZARA COAT 3";
        Productcatlogue productcatlogue = landingP.Login("risom21901@hudzer.com", "Qwe@");
        driver.findElement(By.id("login")).click();
        Assert.assertEquals("Incorrect email or password", landingP.getErrorMessage());




    }
}
