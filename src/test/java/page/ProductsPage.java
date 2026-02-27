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

    @FindBy(css = ".product_sort_container")
    private WebElementFacade sortDropdown;

    @FindBy(id = "react-burger-menu-btn")
    private WebElementFacade menuButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElementFacade logoutLink;

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

    public void removerProductoDelCarrito(String nombreProducto) {
        for (WebElementFacade item : productItems) {
            String itemName = item.find(By.cssSelector(".inventory_item_name")).getText();
            if (itemName.equals(nombreProducto)) {
                item.find(By.cssSelector("button[id^='remove']")).click();
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

    public void ordenarProductos(String criterio) {
        sortDropdown.selectByVisibleText(criterio);
    }

    public void abrirMenu() {
        menuButton.waitUntilClickable().click();
    }

    public void hacerLogout() {
        abrirMenu();
        logoutLink.waitUntilClickable().click();
    }

    public String obtenerPrecioProducto(String nombreProducto) {
        for (WebElementFacade item : productItems) {
            String itemName = item.find(By.cssSelector(".inventory_item_name")).getText();
            if (itemName.equals(nombreProducto)) {
                return item.find(By.cssSelector(".inventory_item_price")).getText();
            }
        }
        return "";
    }

    public int obtenerCantidadProductosVisibles() {
        return productItems.size();
    }
}
