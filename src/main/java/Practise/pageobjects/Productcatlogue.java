package Practise.pageobjects;

import AbstractComponents.AbstractCom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Productcatlogue extends AbstractCom {
    WebDriver driver;
    public Productcatlogue(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".mb-3")
    List<WebElement> productslist;

    @FindBy(css = ".ng-animating")
            WebElement spinner;

    @FindBy(css = ".cartSection h3")
    List<WebElement> cartList;

    @FindBy (xpath = "/html/body/app-root/app-dashboard/app-sidebar/nav/label[1]/div/a/div/h3")
    WebElement loginconfirmMSg;

    By products1 = By.cssSelector(".mb-3");
    By addCart = By.cssSelector("button[class = 'btn w-10 rounded']");
    By toastmessage = By.cssSelector(".toast-container");
    By clickCart = By.cssSelector("[routerlink*='cart']");


    public List<WebElement> getproductList(){

        Waitforelementtoappear(products1);
        return productslist;
    }

    public WebElement getProductname(String Productname){
        WebElement Prod =  productslist.stream().filter(Card -> Card.findElement(By.cssSelector("b")).
                getText().equals(Productname)).findFirst().orElse(null);
        return Prod;
    }

    public Cart_Page addToCart(String Productname) throws InterruptedException {
        WebElement prod = getProductname(Productname);
        prod.findElement(addCart).click();
        Waitforelementtoappear(toastmessage);
        Waitforelementtodissapear(spinner);
        driver.findElement(clickCart).click();

        Cart_Page cartpage = new Cart_Page(driver);
        return cartpage;

    }

    public String LoginAssert(){
        return loginconfirmMSg.getText();
    }


}
