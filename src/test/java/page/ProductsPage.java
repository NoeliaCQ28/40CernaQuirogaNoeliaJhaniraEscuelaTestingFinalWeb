package page;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends PageObject {

    @FindBy(css = ".title")
    private WebElementFacade pageTitle;

    @FindBy(css = ".inventory_item")
    private List<WebElementFacade> productItems;

    @FindBy(css = ".shopping_cart_link")
    private WebElementFacade shoppingCartLink;

    @FindBy(css = ".shopping_cart_badge")
    private WebElementFacade cartBadge;

    public boolean estaPaginaProductosVisible() {
        return pageTitle.waitUntilVisible().getText().equals("Products");
    }

    public void agregarProductoAlCarrito(String nombreProducto) {
        for (WebElementFacade item : productItems) {
            String itemName = item.find(By.cssSelector(".inventory_item_name")).getText();
            if (itemName.equals(nombreProducto)) {
                item.find(By.cssSelector("button[id^='add-to-cart']")).click();
                break;
            }
        }
    }

    public void irAlCarrito() {
        shoppingCartLink.waitUntilClickable().click();
    }

    public int obtenerCantidadProductosEnCarrito() {
        if (cartBadge.isPresent()) {
            return Integer.parseInt(cartBadge.getText());
        }
        return 0;
    }

    public List<WebElementFacade> obtenerListaProductos() {
        return productItems;
    }
}
