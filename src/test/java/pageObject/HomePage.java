package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(WebDriver driver){

        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//span[@class=\"inner-focus hide-on-mobile truncate\"]")
    WebElement accountBtn;

    @FindBy(xpath = "//a[@id=\"pf-dropdown-register\"]")
    WebElement registerBtn;
    @FindBy(xpath = "//ul[@class='default-dropdown account-dropdown show']")
    WebElement dropdown;



    public void clickOnAccountBtn(){
        accountBtn.click();
    }
    public void clickOnRegisterBtn(){
        registerBtn.click();
    }
    public boolean checkIfDropDownIsDisplayed(){
        return dropdown.isDisplayed();
    }
}
