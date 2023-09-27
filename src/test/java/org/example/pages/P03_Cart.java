package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P03_Cart {
    public P03_Cart(){
        PageFactory.initElements(Hooks.driver,this);
    }

    @FindBy(id = "checkout")
    public WebElement checkOut;

    public void clicksCheckOut(){
        checkOut.isDisplayed();
        checkOut.click();
    }

}
