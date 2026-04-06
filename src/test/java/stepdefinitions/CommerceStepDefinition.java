package stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.annotations.Steps;
import steps.CommerceSteps;

import java.io.IOException;

public class CommerceStepDefinition {
    @Steps
    CommerceSteps commerceSteps;

    @Cuando("ingreso los datos de commerce desde: {string}")
    public void ingresoLosDatosDesde(String ruta) throws IOException, InterruptedException {
        commerceSteps.ingresoDatosDesde(ruta);
    }

    @Y("hago clic en el botón de {string}")
    public void hagoClicEnElBotonDe(String boton) {
        commerceSteps.hagoClicEnBoton(boton);
    }

    @Entonces("debería ver la página de Inicio de Nop Commerce")
    public void deberiaVerLaPaginaDeInicioDeNopCommerce() {
        commerceSteps.deberiaVerLaPaginaDeInicio();
    }


}
