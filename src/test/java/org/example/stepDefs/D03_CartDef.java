package org.example.stepDefs;

import io.cucumber.java.en.And;
import org.example.pages.P03_Cart;

public class D03_CartDef {
    P03_Cart p03Cart= new P03_Cart();
    @And("User Clicks Checkout")
    public void userClicksCheckout() {
        p03Cart.clicksCheckOut();

    }


}
