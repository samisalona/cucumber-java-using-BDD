package com.automation.example.stepdefs;

import com.automation.example.pages.RegisterPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.LocalDate;

import static com.automation.example.pages.RegisterPage.*;
import static common.ReadXML.*;

public class RegisterSteps {

    private WebDriver driver;
    private RegisterPage registerPage;

    @Before(value = "@web", order = 1)
    public void initReadXML() {
        ReadXMLFile();
    }

    @Before(value = "@web", order = 2)
    public void initWebDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Before(value = "@register", order = 3)
    public void initRegisterPage() {
        registerPage = new RegisterPage(driver);
    }

    @Given("^a user is on the Register page$")
    public void a_user_is_on_the_Register_page()  {
        registerPage.navigateToRegisterPage();
    }

    @When("^the About You details are entered$")
    public void the_About_You_details_are_entered() {

        LocalDate currentdate = LocalDate.now();
        int currentDay = currentdate.getDayOfMonth();
        int currentMonth = currentdate.getMonthValue();
        int currentYear = (currentdate.getYear() - 18);

        registerPage.clearTextBoxAndSetValue(BY_FIRSTNAME, FirstName);
        registerPage.clearTextBoxAndSetValue(BY_LASTNAME, LastName);
        registerPage.setDropdownByIndex(BY_GENDERIDENTITY, GenderIdentity);
        registerPage.setDropdownByIndex(BY_ASSIGNEDSEX, AssignedSex);
        registerPage.setDropdownByIndex(BY_PARTNERSEX, PartnerSex);
        registerPage.setDropdownByIndex(BY_DOBDAY, currentDay);
        registerPage.setDropdownByIndex(BY_DOBMONTH, currentMonth);
        registerPage.setDropdownByText(BY_DOBYEAR, currentYear);
        registerPage.setDropdownByText(BY_ETHNICITY, Ethnicity);
    }

    @And("^the Where You Live details are entered$")
    public void the_Where_You_Live_details_are_entered() {
        registerPage.clearTextBoxAndSetValue(BY_ADDRESSLINEONE, AddressLineOne);
        registerPage.clearTextBoxAndSetValue(BY_TOWNCITY, TownCity);
        registerPage.clearTextBoxAndSetValue(BY_COUNTY, County);
        registerPage.clearTextBoxAndSetValue(BY_POSTCODE, PostCode);
    }

    @And("^the Contact Preferences are entered$")
    public void the_Contact_Preferences_are_entered() {
        registerPage.clearTextBoxAndSetValue(BY_EMAILADDRESS, EmailAddress);
        registerPage.clearTextBoxAndSetValue(BY_MOBILENUMBER, MobileNumber);
        registerPage.selectRadioButton(BY_CONTACTPREFERENCE);
    }

    @And("^the Your Password details are entered$")
    public void the_Your_Password_details_are_entered() {
        registerPage.clearTextBoxAndSetValue(BY_PASSWORD,Password);
        registerPage.clearTextBoxAndSetValue(BY_CONFIRMPASSWORD,ConfirmPassword);
    }

    @And("^the Agree And Consent are selected$")
    public void the_Agree_And_Consent_are_selected() {
        registerPage.setCheckBox(BY_RESEARCHCONSENT, ResearchConsent);
        registerPage.setCheckBox(BY_TERMS, Terms);
    }

    @Then("^the expected results validation is displayed$")
    public void the_expected_results_validation_is_displayed() {
        registerPage.submitButton(BY_REGISTER);
        By validationX = By.xpath("//*[@id=\"upBody\"]/div/div[2]/div[2]/div[1]/div[1]/div/span[1]");
        WebElement emailValidation = driver.findElement(validationX);
        Assert.assertTrue(isElementDisplayed(emailValidation));
    }

    @After(value = "@web")
    public void disposeWebDriver() {
        driver.quit();
    }
}
