package com.qaprosoft.carina.demo.gui.pages.gsmarena;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.CartItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends AbstractPage {
    @FindBy(xpath = "//div[@class='cart-item']")
    private List<CartItem> cartItemsTitles;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<CartItem> getCartItemsTitles() {
        return cartItemsTitles;
    }
}
