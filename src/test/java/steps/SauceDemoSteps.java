package steps;

import net.serenitybdd.annotations.Step;
import page.CartPage;
import page.CheckoutPage;
import page.LoginPage;
import page.ProductsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class SauceDemoSteps {

    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @Step("Abrir la página de SauceDemo")
    public void abrirSauceDemo() {
        loginPage.open();
    }

    @Step("Iniciar sesión con usuario {0} y password {1}")
    public void iniciarSesion(String usuario, String password) {
        loginPage.login(usuario, password);
    }

    @Step("Verificar que la página de productos está visible")
    public void verificarPaginaProductos() {
        assertThat(productsPage.estaPaginaProductosVisible())
                .as("La página de productos debería estar visible")
                .isTrue();
    }

    @Step("Agregar producto '{0}' al carrito")
    public void agregarProductoAlCarrito(String nombreProducto) {
        productsPage.agregarProductoAlCarrito(nombreProducto);
    }

    @Step("Ir al carrito de compras")
    public void irAlCarrito() {
        productsPage.irAlCarrito();
    }

    @Step("Verificar cantidad de productos en carrito: {0}")
    public void verificarCantidadProductosEnCarrito(int cantidad) {
        assertThat(productsPage.obtenerCantidadProductosEnCarrito())
                .as("La cantidad de productos en el carrito debería ser " + cantidad)
                .isEqualTo(cantidad);
    }

    @Step("Proceder al checkout")
    public void procederAlCheckout() {
        cartPage.clickCheckout();
    }

    @Step("Ingresar datos de envío: {0} {1} {2}")
    public void ingresarDatosEnvio(String nombre, String apellido, String codigoPostal) {
        checkoutPage.ingresarDatosCheckout(nombre, apellido, codigoPostal);
        checkoutPage.clickContinuar();
    }

    @Step("Finalizar compra")
    public void finalizarCompra() {
        checkoutPage.clickFinalizar();
    }

    @Step("Verificar que la orden está completada")
    public void verificarOrdenCompletada() {
        assertThat(checkoutPage.estaOrdenCompletada())
                .as("La orden debería estar completada")
                .isTrue();
    }

    @Step("Obtener mensaje de orden completada")
    public String obtenerMensajeOrdenCompletada() {
        return checkoutPage.obtenerMensajeCompletado();
    }
}
