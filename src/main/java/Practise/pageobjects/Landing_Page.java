package Practise.pageobjects;

import AbstractComponents.AbstractCom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landing_Page extends AbstractCom {
    WebDriver driver;

    public Landing_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userPassword")
    WebElement userPassword;

    @FindBy(id = "login")
    WebElement submit;

    public Productcatlogue Login(String email, String password) {
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        submit.click();
        Productcatlogue productcatlogue = new Productcatlogue(driver);
        return productcatlogue;
    }

    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client");
    }

}
