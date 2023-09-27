package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.example.pages.P02_Inventory;
import org.example.pages.P04_Checkout;

import java.io.IOException;

public class D04_Checkout {

    P02_Inventory p02Inventory = new P02_Inventory();
    P04_Checkout p04Checkout =new P04_Checkout();
    @And("User Fill In The Checkout Info")
    public void userFillInTheCheckoutInfo() throws IOException, InvalidFormatException {
        p04Checkout.fillInCheckoutInfo();

    }

    @And("User Confirm the Order")
    public void userConfirmTheOrder() {
        p04Checkout.customerConfirmTheOrder();

    }

    @Then("The Order is Created Successfully")
    public void theOrderIsCreatedSuccessfully() {
        p04Checkout.assertSuccessfulOrder();
    }

    @And("UserLogout")
    public void userLogout() {
        p02Inventory.MenuButton.click();
        p02Inventory.logOutOption.isDisplayed();
        p02Inventory.logOutOption.click();

    }
}
