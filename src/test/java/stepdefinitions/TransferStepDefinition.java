package stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.es.Cuando;
import net.serenitybdd.annotations.Steps;
import steps.TransferSteps;

import java.io.IOException;

public class TransferStepDefinition {
    @Steps
    TransferSteps transferSteps;

    private TransferSteps transferSteps() {
        return new TransferSteps();
    }

    @Cuando("ingreso los datos desde: {string}")
    public void ingresoLosDatosDesde(String ruta) throws IOException, InterruptedException {
        transferSteps.ingresoDatosDesde(ruta);
    }
}
