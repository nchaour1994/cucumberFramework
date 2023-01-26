package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.RegisterPage;

import java.util.Properties;

public class BaseClass {
   public WebDriver driver;
    public LoginPage loginPage;
    public HomePage homePage;
    public RegisterPage registerPage;
    public Logger logger=  LogManager.getLogger(BaseClass.class);
    public Properties properties;




    public  static String  generatePassword(){
        return RandomStringUtils.randomAlphanumeric(5);
    }



}
