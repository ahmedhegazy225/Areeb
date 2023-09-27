package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static org.example.stepDefs.Hooks.wait;

public class P02_Inventory {
    public P02_Inventory(){
        PageFactory.initElements(Hooks.driver,this);
    }

    @FindBy(className = "app_logo")
    public WebElement appLogo;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public  WebElement backPack;
    @FindBy(id = "shopping_cart_container")
    public WebElement shoppingCart;

    @FindBy (id = "react-burger-menu-btn")
    public WebElement MenuButton;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logOutOption;

    public void assertUserOnInventoryPage(){
        wait.until(ExpectedConditions.visibilityOf(appLogo));
        String logoText = "Swag Labs";   // expected
        String loginLogoText = appLogo.getText();  // actual
        Assert.assertTrue(logoText.contains(loginLogoText));
    }
    public void selectBackPackItem(){
        backPack.isDisplayed();
        backPack.click();
    }
    public void goToShoppingCart(){
        shoppingCart.isDisplayed();
        shoppingCart.click();
    }
}
