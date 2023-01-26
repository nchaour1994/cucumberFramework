package pageObject;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    public RegisterPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//input[@name=\"firstName\"]")
    WebElement firstNameField;
    @FindBy(xpath = "//input[@name=\"lastName\"]")
    WebElement lastNameField;
    @FindBy(xpath = "//input[@name=\"registerData\"]")
    WebElement emailField;
    @FindBy(xpath = "//input[@name=\"registerPassword\"]")
    WebElement passwordField;
    @FindBy(xpath = "//input[@id=\"wag-reg-myw-checkbox\"]")
    public
    WebElement checkboxLinkMyAcoount;
    @FindBy(xpath = "//input[@name=\"phoneno\"]")
    public WebElement phoneNumberField;
    @FindBy(xpath = "//input[@name=\"zipcode\"]")
    WebElement zipCodeField;
    @FindBy(xpath = "//input[@id=\"wag-mywterms-checkbox\"]")
    public
    WebElement checkBoxOver16;
    @FindBy(xpath = "//input[@id=\"wag-terms-checkbox\"]")
    public
    WebElement checkBoxAgreement;


    public void typeOnFirstNameField(String name){
        firstNameField.sendKeys(name);


    }
    public void typeOnLastNameField(String lastName){
        lastNameField.sendKeys(lastName);
    }
    public void typeOnEmailField(String email){
       // email= RandomStringUtils.randomAlphanumeric(8)+"@gmail.com";
        emailField.sendKeys(email);

    }
    public void typeOnPasswordField(String pass){
        passwordField.sendKeys(pass);
    }

    public void flagCheckBoxAgreement(){
        checkBoxAgreement.click();
    }
    public String getValueOfName(){
        return firstNameField.getAttribute("value");
    }
    public String getValueOfLastName(){
        return lastNameField.getAttribute("value");
    }
}
