package Practise.pageobjects;

import AbstractComponents.AbstractCom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Orderpage extends AbstractCom {

    WebDriver driver;

    @FindBy(css = "tr td:nth-child(3)")
    List<WebElement> productNames;

    public Orderpage(WebDriver driver) {
        super(driver);
        this.driver = this.driver;

    }

    public Boolean VerifyOrderDisplay(String Productname) {
        Boolean match = productNames.stream()
                .anyMatch(product -> product.getText()
                        .equalsIgnoreCase(Productname));

        return match;
    }
}