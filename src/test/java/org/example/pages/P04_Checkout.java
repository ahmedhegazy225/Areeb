package org.example.pages;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.example.dataProvider.P01_loginDataProvider;
import org.example.dataProvider.P02_CheckOutInfoDataProvider;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import static org.example.stepDefs.Hooks.wait;

public class P04_Checkout {

    public P04_Checkout(){
        PageFactory.initElements(Hooks.driver,this);
    }
    @FindBy (id = "first-name")
    public WebElement firstNameInput;

    @FindBy (id = "last-name")
    public WebElement lastNameInput;

    @FindBy(id = "postal-code")
    public WebElement postalCodeInput;

    @FindBy(id = "continue")
    public WebElement continueButton;

    @FindBy(id = "finish")
    public WebElement finishButton;

    @FindBy(className = "complete-header")
    public WebElement orderSuccessMessage;

    @DataProvider
    public Object[][] test_data() throws IOException, InvalidFormatException {
        P02_CheckOutInfoDataProvider obj = new P02_CheckOutInfoDataProvider();
        return obj.read_checkout();

    }

    public void fillInCheckoutInfo() throws IOException, InvalidFormatException {
        Object[][] testData = test_data();
        for (Object[] testDatum : testData) {
            String firstname = (String) testDatum[0];
            String lastname = (String) testDatum[1];
            String postalcode = (String) testDatum[2];
            firstNameInput.sendKeys(firstname);
            lastNameInput.sendKeys(lastname);
            postalCodeInput.sendKeys(postalcode);
            continueButton.click();
        }


    }

    public void customerConfirmTheOrder(){
        finishButton.isDisplayed();
        finishButton.click();
    }

    public void assertSuccessfulOrder(){
        wait.until(ExpectedConditions.visibilityOf(orderSuccessMessage));
        String successMessage = "Thank you for your order!";   // expected
        String getSuccessMessage = orderSuccessMessage.getText();  // actual
        Assert.assertTrue(successMessage.contains(getSuccessMessage));
    }
}
