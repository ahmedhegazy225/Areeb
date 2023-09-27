package org.example.pages;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.example.dataProvider.P01_loginDataProvider;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import static org.example.stepDefs.Hooks.wait;

public class P01_Login {

    public P01_Login(){
        PageFactory.initElements(Hooks.driver,this);
    }
    @FindBy(className = "login_logo")
    public WebElement loginLogo;

    @FindBy(id = "user-name")
    public WebElement userInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "login-button")
    public WebElement loginButton;
    @DataProvider
    public Object[][] test_data() throws IOException, InvalidFormatException {
        P01_loginDataProvider obj = new P01_loginDataProvider();
        return obj.read_login();

    }

    public void assertUserOnLoginPage(){
        wait.until(ExpectedConditions.visibilityOf(loginLogo));
        String logoText = "Swag Labs";
        String loginLogoText = loginLogo.getText();
        Assert.assertTrue(logoText.contains(loginLogoText));
    }
    public void validCredentials() throws IOException, InvalidFormatException {

        Object[][] testData = test_data();
        for (Object[] testDatum : testData) {
            String username = (String) testDatum[0];
            String password = (String) testDatum[1];
            wait.until(ExpectedConditions.visibilityOf(userInput)).sendKeys(username);
            passwordInput.sendKeys(password);

        }

}
    public void clicksLoginButton() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.isDisplayed();
        loginButton.isEnabled();
        loginButton.click();
    }

}
