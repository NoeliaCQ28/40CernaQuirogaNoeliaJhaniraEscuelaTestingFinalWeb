package steps;

import net.serenitybdd.annotations.Step;
import page.CartPage;
import page.CheckoutPage;
import page.LoginPage;
import page.ProductsPage;
import utils.CredencialesHelper;

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

    @Step("Iniciar sesión con usuario tipo {0}")
    public void iniciarSesionConTipoUsuario(String tipoUsuario) {
        String username = CredencialesHelper.obtenerUsername(tipoUsuario);
        String password = CredencialesHelper.obtenerPassword(tipoUsuario);
        loginPage.login(username, password);
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

    @Step("Remover producto '{0}' del carrito")
    public void removerProductoDelCarrito(String nombreProducto) {
        productsPage.removerProductoDelCarrito(nombreProducto);
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

    @Step("Ingresar solo nombre de envío: {0}")
    public void ingresarSoloNombre(String nombre) {
        checkoutPage.ingresarNombre(nombre);
    }

    @Step("Ingresar solo apellido de envío: {0}")
    public void ingresarSoloApellido(String apellido) {
        checkoutPage.ingresarApellido(apellido);
    }

    @Step("Ingresar solo código postal: {0}")
    public void ingresarSoloCodigoPostal(String codigoPostal) {
        checkoutPage.ingresarCodigoPostal(codigoPostal);
    }

    @Step("Continuar con el checkout")
    public void continuarCheckout() {
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

    @Step("Verificar mensaje de error en login: {0}")
    public void verificarMensajeErrorLogin(String mensajeEsperado) {
        assertThat(loginPage.obtenerMensajeError())
                .as("El mensaje de error debería contener el texto esperado")
                .contains(mensajeEsperado);
    }

    @Step("Verificar que se muestra mensaje de error en login")
    public void verificarSeVisualizaMensajeErrorLogin() {
        assertThat(loginPage.seVisualizaMensajeError())
                .as("Debería mostrarse un mensaje de error")
                .isTrue();
    }

    @Step("Verificar mensaje de error en checkout")
    public void verificarMensajeErrorCheckout(String mensajeEsperado) {
        assertThat(checkoutPage.obtenerMensajeError())
                .as("El mensaje de error en checkout debería contener el texto esperado")
                .contains(mensajeEsperado);
    }

    @Step("Remover producto '{0}' desde el carrito")
    public void removerProductoDesdeCarrito(String nombreProducto) {
        cartPage.removerProducto(nombreProducto);
    }

    @Step("Verificar que el carrito está vacío")
    public void verificarCarritoVacio() {
        assertThat(cartPage.carritoEstaVacio())
                .as("El carrito debería estar vacío")
                .isTrue();
    }

    @Step("Continuar comprando")
    public void continuarComprando() {
        cartPage.clickContinuarComprando();
    }

    @Step("Cancelar checkout")
    public void cancelarCheckout() {
        checkoutPage.clickCancelar();
    }

    @Step("Ordenar productos por {0}")
    public void ordenarProductos(String criterio) {
        productsPage.ordenarProductos(criterio);
    }

    @Step("Hacer logout")
    public void hacerLogout() {
        productsPage.hacerLogout();
    }

    @Step("Verificar que se está en carrito")
    public void verificarEstaEnCarrito() {
        assertThat(cartPage.estaEnCarrito())
                .as("Debería estar en la página del carrito")
                .isTrue();
    }

    @Step("Verificar cantidad de productos en carrito page: {0}")
    public void verificarCantidadProductosEnCartPage(int cantidad) {
        assertThat(cartPage.obtenerCantidadProductos())
                .as("La cantidad de productos en el carrito debería ser " + cantidad)
                .isEqualTo(cantidad);
    }

    @Step("Verificar que está en página de checkout información")
    public void verificarEstaEnCheckoutInfo() {
        assertThat(checkoutPage.estaEnPaginaCheckoutInfo())
                .as("Debería estar en la página de información de checkout")
                .isTrue();
    }

    @Step("Verificar que está en página de checkout resumen")
    public void verificarEstaEnCheckoutOverview() {
        assertThat(checkoutPage.estaEnPaginaCheckoutOverview())
                .as("Debería estar en la página de resumen de checkout")
                .isTrue();
    }

    @Step("Volver a productos desde checkout completo")
    public void volverAProductos() {
        checkoutPage.volverAProductos();
    }

    @Step("Verificar cantidad de productos visibles: {0}")
    public void verificarCantidadProductosVisibles(int cantidad) {
        assertThat(productsPage.obtenerCantidadProductosVisibles())
                .as("La cantidad de productos visibles debería ser " + cantidad)
                .isEqualTo(cantidad);
    }
}
