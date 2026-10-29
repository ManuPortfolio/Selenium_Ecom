package Practise.pageobjects;

import AbstractComponents.AbstractCom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Orderpage extends AbstractCom {

    WebDriver driver;
    public Orderpage() {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    @FindBy(css = "tr td:nth-child(3)")
    List<WebElement> productNames;

    @FindBy(css = ".totalRow button")
    WebElement checkOutBtn;

    @FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-profile[1]/div[1]/div[1]/h1[1]")
    WebElement cartTitleText;

    public Boolean VerifyOrderDisplay(String Productname){
        Boolean match = productNames.stream().anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(Productname));
        return match ;
    }



}
