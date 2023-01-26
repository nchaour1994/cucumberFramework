package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.RegisterPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class Steps extends BaseClass {
    @Before
    public void setup(){
        properties=new Properties();
        try {
            FileInputStream configPro=new FileInputStream("config.properties");
            properties.load(configPro);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String browser=properties.getProperty("browser");
        if(browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", properties.getProperty("chromeDriver"));
            driver = new ChromeDriver();
        }
        driver.get(properties.getProperty("url"));
        Assert.assertEquals(driver.getTitle(), "Sign In or Register to Get Started Using Walgreens.com");


    }


    @Given("user is on login page")
    public void user_is_on_login_page() {
        loginPage = new LoginPage(driver);
        logger.info("open browser");
    }

    @When("user enters user as {string} and pass as {string}")
    public void user_enters_user_as_and_pass_as(String user, String pass) {
        System.out.println("step1");
        loginPage.typeOnUsername(user);
        logger.info("enter user");
        loginPage.typeOnPassword(pass);
        logger.info("enter password");
        Assert.assertEquals(loginPage.username.getAttribute("value"), user);
        Assert.assertEquals(loginPage.password.getAttribute("value"), pass);


    }

    @When("click on login button")
    public void click_on_login_button() {
        loginPage.clickOnSignInBtn();
        logger.info("sing in button clicked");
    }

    @Then("user is navigated to homepage")
    public void user_is_navigated_to_homepage() {
        System.out.println("step3 ");
    }

    @Then("user should be on {string}")
    public void user_should_be_on(String title) {
        logger.info("driver closed");
        driver.close();

    }
//create account


    @When("user enter the url {string}")
    public void user_enter_the_url(String string) {
        driver.get(string);
    }

    @Then("walgreen homepage  should appears")
    public void walgreen_homepage_should_appears() {
        Assert.assertEquals(driver.getTitle(), "Walgreens: Pharmacy, Health & Wellness, Photo & More for You");
        logger.info("home page appeared");
    }

    @When("user click on account button")
    public void user_click_on_account_button() {
        homePage = new HomePage(driver);
        homePage.clickOnAccountBtn();
        logger.info("button clicked");
    }

    @Then("drop down should appears")
    public void drop_down_should_appears() {
        homePage.checkIfDropDownIsDisplayed();
        logger.info("dropdown displayed");
    }

    @Then("user click on register button")
    public void user_click_on_register_button() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.clickOnRegisterBtn();
        logger.info("register button clicked");
    }

    @Then("registration page should appears")
    public void registration_page_should_appears() {
        Assert.assertEquals(driver.getTitle(), "Create Your Account | Walgreens");
    }

    @When("user enter first name as {string}")
    public void user_enter_first_name(String n) {
        registerPage = new RegisterPage(driver);
        registerPage.typeOnFirstNameField(n);
        logger.info("enter user");
    }

    @When("user enter last name as {string}")
    public void user_enter_last_name_as_admin(String s) {
        registerPage.typeOnLastNameField(s);
        logger.info("last nem entred");
    }

    @When("user enter email as {string}")
    public void user_enter_email_as(String string) {
        registerPage.typeOnEmailField(string);
        logger.info("email entred");
    }

    @When("user enter password as {string}")
    public void user_enter_password_as(String string) {
        registerPage.typeOnPasswordField(string);
        logger.info("password entred");
    }

    @When("user check the box agreement")
    public void user_check_the_box_agreement() {
        registerPage.flagCheckBoxAgreement();
        logger.info("box checked");
    }

    @When("click on continue button")
    public void click_on_continue_button() {

    }

    @When("landing page appears")
    public void landing_page_appears() {

    }

    @Then("close the browser")
    public void close_the_browser() {

    }

}
