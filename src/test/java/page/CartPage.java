package page;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends PageObject {

    @FindBy(css = ".cart_item")
    private List<WebElementFacade> cartItems;

    @FindBy(id = "checkout")
    private WebElementFacade checkoutButton;

    @FindBy(id = "continue-shopping")
    private WebElementFacade continueShopping;

    @FindBy(css = ".title")
    private WebElementFacade pageTitle;

    public int obtenerCantidadProductos() {
        return cartItems.size();
    }

    public void clickCheckout() {
        checkoutButton.waitUntilClickable().click();
    }

    public void clickContinuarComprando() {
        continueShopping.waitUntilClickable().click();
    }

    public boolean estaEnCarrito() {
        return pageTitle.waitUntilVisible().getText().equals("Your Cart");
    }

    public List<WebElementFacade> obtenerProductosEnCarrito() {
        return cartItems;
    }
}
