package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.example.dataProvider.P01_loginDataProvider;
import org.example.pages.P01_Login;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class D01_LoginDef {

    P01_Login p01Login = new P01_Login();

    @Given("User Opens The Login Page")
    public void userOpensTheLoginPage() {
        p01Login.assertUserOnLoginPage();
    }

    @When("User Enters Valid Credentials")
    public void userEntersValidCredentials() throws IOException, InvalidFormatException {
        p01Login.validCredentials();

    }


    @Given("User Logged In")
    public void userLoggedIn() throws IOException, InvalidFormatException {
        p01Login.validCredentials();
        p01Login.clicksLoginButton();


    }

    @And("User Clicks Login")
    public void userClicksLogin() {
        p01Login.clicksLoginButton();

    }
}
