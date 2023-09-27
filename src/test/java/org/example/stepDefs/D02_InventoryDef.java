package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_Inventory;

public class D02_InventoryDef {

    P02_Inventory p02Inventory = new P02_Inventory();
    @Then("User Login Successfully")
    public void userLoginSuccessfully() {
        p02Inventory.assertUserOnInventoryPage();


    }

    @When("User Adds An Item To Cart")
    public void userAddsAnItemToCart() {
        p02Inventory.selectBackPackItem();
    }

    @And("User Opens The Cart")
    public void userOpensTheCart() {
        p02Inventory.goToShoppingCart();
    }


}
