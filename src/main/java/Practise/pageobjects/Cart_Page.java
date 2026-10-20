package Practise.pageobjects;

import AbstractComponents.AbstractCom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;
import java.util.List;

public class Cart_Page extends AbstractCom {

    WebDriver driver;
    public Cart_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    @FindBy(css = ".cartSection h3")
    List<WebElement> cartList;

    @FindBy(css = ".totalRow button")
    WebElement checkOutBtn;

    @FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-profile[1]/div[1]/div[1]/h1[1]")
    WebElement cartTitleText;

    public Boolean VerifyProductDisplay(String Productname){
        Boolean match = cartList.stream().anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(Productname));
        return match ;
    }

    public CheckoutPage goTocheckout(){

        checkOutBtn.click();
        CheckoutPage  checkoutPage = new CheckoutPage(driver);
        return checkoutPage;
    }

    public String CartText(){
        return cartTitleText.getText();
    }

}
