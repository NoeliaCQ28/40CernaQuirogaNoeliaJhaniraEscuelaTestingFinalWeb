package stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.annotations.Steps;
import steps.SauceDemoSteps;

public class SauceDemoStepDefinitions {

    @Steps
    SauceDemoSteps sauceDemoSteps;

    @Dado("que el usuario abre la página de SauceDemo")
    public void queElUsuarioAbreLaPaginaDeSauceDemo() {
        sauceDemoSteps.abrirSauceDemo();
    }

    @Cuando("ingresa las credenciales {string} y {string}")
    public void ingresaLasCredencialesY(String usuario, String password) {
        sauceDemoSteps.iniciarSesion(usuario, password);
    }

    @Entonces("debería ver la página de productos")
    public void deberiaVerLaPaginaDeProductos() {
        sauceDemoSteps.verificarPaginaProductos();
    }

    @Y("agrega el producto {string} al carrito")
    public void agregaElProductoAlCarrito(String nombreProducto) {
        sauceDemoSteps.agregarProductoAlCarrito(nombreProducto);
    }

    @Y("va al carrito de compras")
    public void vaAlCarritoDeCompras() {
        sauceDemoSteps.irAlCarrito();
    }

    @Y("procede al checkout con los datos {string} {string} {string}")
    public void procedeAlCheckoutConLosDatos(String nombre, String apellido, String codigoPostal) {
        sauceDemoSteps.procederAlCheckout();
        sauceDemoSteps.ingresarDatosEnvio(nombre, apellido, codigoPostal);
        sauceDemoSteps.finalizarCompra();
    }

    @Entonces("debería ver el mensaje de orden completada")
    public void deberiaVerElMensajeDeOrdenCompletada() {
        sauceDemoSteps.verificarOrdenCompletada();
    }

    @Entonces("el carrito debería mostrar {int} productos")
    public void elCarritoDeberiaMostrarProductos(int cantidad) {
        sauceDemoSteps.verificarCantidadProductosEnCarrito(cantidad);
    }
}
