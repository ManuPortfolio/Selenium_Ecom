package Practise.pageobjects;

import AbstractComponents.AbstractCom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends AbstractCom {
    WebDriver driver;
    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".form-group input")
    WebElement selectCountry;

    @FindBy(xpath = "/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[1]/div/section/button[2]")
    WebElement clickCountry;

    @FindBy(css = ".btnn")
    WebElement finalCheckBtn;


    @FindBy(css = "div[class = 'payment__title']")
    WebElement getpaymentText;


    public void setSelectCountry(String countryname) throws InterruptedException {
        Actions a = new Actions(driver);
        a.sendKeys(selectCountry,countryname).build().perform();
        Thread.sleep(2000);
        clickCountry.click();
    }
    public ConfirmationPage clickFinalCheckBtn(){
        finalCheckBtn.click();
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        return confirmationPage;
    }

    public String paymentTitle(){
        return getpaymentText.getText();
    }





}
