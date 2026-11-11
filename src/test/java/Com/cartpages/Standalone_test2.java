package Com.cartpages;

import BaseTest.BaseTest;
import Practise.pageobjects.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Standalone_test2 extends BaseTest {
    String Productname = "ZARA COAT 3";
    @Test(dataProvider = "getData1", groups = "Purchase")
    public void Demo(HashMap<String,String> input ) throws InterruptedException {

        Productcatlogue productcatlogue = landingP.Login(input.get("email"), input.get("password"));
        String loginconfirm = productcatlogue.LoginAssert();
        Assert.assertEquals(loginconfirm, "AUTOMATION");
        List<WebElement> Cards = productcatlogue.getproductList();
        Cart_Page cartpage = productcatlogue.addToCart(input.get("product"));
        String cartText = cartpage.CartText();
        Assert.assertEquals(cartText, "My Cart");
        System.out.println(cartText);


        Boolean match = cartpage.VerifyProductDisplay(input.get("product"));
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

    @Test(dependsOnMethods = "Demo")
    public void orderHistory(){

        Productcatlogue productcatlogue = landingP.Login("risom21901@hudzer.com", "Qwe@1234");
        Orderpage orderpage = productcatlogue.goToorderpage();
        Assert.assertTrue(orderpage.VerifyOrderDisplay(Productname));
        System.out.println(orderpage.VerifyOrderDisplay(Productname));

    }

    public String getScreenShot(String testCasename) throws IOException {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File screenshot = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "\\screenshots\\" + testCasename + ".png");
        FileUtils.copyFile(file, screenshot);
        return System.getProperty("user.dir") + "\\screenshots\\" + testCasename + ".png";

    }



    @DataProvider
    public Object[][] getData1() throws IOException {

        List<HashMap<String,String>>data =  getJsontoData(System.getProperty("user.dir") + "//src//test//java/Data_Set//PurchaseOrder.json");
        return new Object[][] {
                {data.get(0)},
                {data.get(1)}
        };
    }


// Method 1
    //    @DataProvider
//    public Object[] [] getData(){
//        return new Object [] []{{"risom21901@hudzer.com","Qwe@1234","ZARA COAT 3"},{"jaboles232@hiringview.com","Qwe@1234","ADIDAS ORIGINAL"}};
//    }

    //Method 2
     /* HashMap<String, String> map = new HashMap<>();
        map.put("email", "risom21901@hudzer.com");
        map.put("password", "Qwe@1234");
        map.put("product", "ZARA COAT 3");

        HashMap<String, String> map1 = new HashMap<>();
        map1.put("email", "jaboles232@hiringview.com");
        map1.put("password", "Qwe@1234");
        map1.put("product", "ADIDAS ORIGINAL");*/

}
