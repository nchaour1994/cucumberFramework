package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "user_name")
    @CacheLookup
    public  WebElement username;
    @FindBy(id = "user_password")
    public  WebElement password;
    @FindBy(id = "submit_btn")
    WebElement signInBtn;

    public void typeOnUsername(String user) {
        username.sendKeys(user);
    }

    public void typeOnPassword(String pass) {
        password.sendKeys(pass);
    }

    public void clickOnSignInBtn() {
        signInBtn.click();
    }

    public String getUserName() {
        return username.getAttribute("value");
    }

    public String getPassword() {
        return password.getAttribute("value");
    }


}
