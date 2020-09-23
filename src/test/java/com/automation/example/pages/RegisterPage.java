package com.automation.example.pages;

import com.automation.example.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends AbstractPage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public static final String SH_UK_REGISTER_URL = "https://www.sh.uk/register";
    public static final By BY_FIRSTNAME = By.id("contentBody_txtFirstName");
    public static final By BY_LASTNAME = By.id("contentBody_txtLastName");
    public static final By BY_GENDERIDENTITY = By.id("contentBody_drpGender");
    public static final By BY_ASSIGNEDSEX = By.id("contentBody_drpAssignedSex");
    public static final By BY_PARTNERSEX = By.id("contentBody_drpPartnerSex");
    public static final By BY_DOBDAY = By.id("contentBody_drpDay");
    public static final By BY_DOBMONTH = By.id("contentBody_drpMonth");
    public static final By BY_DOBYEAR = By.id("contentBody_drpYear");
    public static final By BY_ETHNICITY = By.id("contentBody_drpEthnicity");
    public static final By BY_ADDRESSLINEONE = By.id("contentBody_ctlContact_txtAddress1");
    public static final By BY_TOWNCITY = By.id("contentBody_ctlContact_txtTownCity");
    public static final By BY_COUNTY = By.id("contentBody_ctlContact_txtCounty");
    public static final By BY_POSTCODE = By.id("contentBody_ctlContact_txtPostCode");
    public static final By BY_EMAILADDRESS = By.id("contentBody_txtEmailAddress");
    public static final By BY_MOBILENUMBER = By.id("contentBody_txtMobileNumber");
    public static final By BY_CONTACTPREFERENCE = By.xpath("//*[@id=\"contentBody_radContactPreference\"]/li[2]/label");
    public static final By BY_PASSWORD = By.id("contentBody_txtPassword");
    public static final By BY_CONFIRMPASSWORD = By.id("contentBody_txtPasswordConfirm");
    public static final By BY_RESEARCHCONSENT = By.id("contentBody_chkResearchConsent");
    public static final By BY_TERMS = By.id("contentBody_chkTerms");
    public static final By BY_REGISTER = By.name("ctl00$contentBody$btnRegister");

    public void navigateToRegisterPage() {
        getDriver().navigate().to(SH_UK_REGISTER_URL);
    }

    public void clearTextBoxAndSetValue(By locator, String text) {
        WebElement textbox = driverWait(10).until(ExpectedConditions.elementToBeClickable(locator));
        if (text instanceof String) {
            try {
                textbox.clear();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            text = "";
        }
        textbox.sendKeys(text);
    }

    public void clearTextBoxAndSetValue(By locator, Integer number) {
        WebElement textbox = driverWait(10).until(ExpectedConditions.elementToBeClickable(locator));
        if (number instanceof Integer) {
            try {
                textbox.clear();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            number = 0;
        }
        textbox.sendKeys(number.toString());
    }

    public void setDropdownByText(By locator, String textToSet) {
        WebElement element = driverWait(10).until(ExpectedConditions.elementToBeClickable(locator));
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(textToSet);
    }

    public void setDropdownByIndex(By locator, Integer indexToSelect) {
        WebElement element = driverWait(10).until(ExpectedConditions.elementToBeClickable(locator));
        Select dropdown = new Select(element);
        dropdown.selectByIndex(indexToSelect);
    }

    public void setDropdownByText(By locator, int textToSet) {
        WebElement element = driverWait(10).until(ExpectedConditions.elementToBeClickable(locator));
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(String.valueOf(textToSet));
    }

    public void setCheckBox(By locator, String specifiedOption) {
        WebElement checkbox = driverWait(10).until(ExpectedConditions.elementToBeClickable(locator));
        Boolean tickbox = (specifiedOption.equals("Yes") ? Boolean.TRUE : Boolean.FALSE);
        if (tickbox == Boolean.FALSE) {
            checkbox.click();
        }
    }

    public void selectRadioButton(By locator){
        WebElement radiobutton = getDriver().findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].click();", radiobutton);
    }

    public void submitButton(By locator){
        WebElement button = driverWait(10).until(ExpectedConditions.elementToBeClickable(locator));
        button.click();
    }

    public static boolean isElementDisplayed(WebElement element) {
        boolean displayed = false;
        try {
            if (element.isDisplayed()) {
                displayed = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return displayed;
    }

    public boolean isElementDisplayed(By locator) {
        boolean displayed = false;
        try {
            if (driverWait(10).until(ExpectedConditions.elementToBeClickable(locator)).isDisplayed()) {
                displayed = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return displayed;
    }
}

