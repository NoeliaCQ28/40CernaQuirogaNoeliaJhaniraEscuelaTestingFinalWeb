package steps;

import page.Login.NewLoginPage;
import net.serenitybdd.annotations.Step;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TransferSteps {

    // 1. Declaras la página como una variable (Serenity la inicializará sola, ¡no uses 'new'!)
    NewLoginPage loginPage;

    // 2. Usas la anotación @Step para que salga en tu reporte de Serenity
    @Step
    public void ingresoDatosDesde(String csv) throws InterruptedException, IOException {
        List<Map<String, String>> data = LoginSteps.obtenerDatosDesdeCSV(csv);

        for (Map<String, String> fila : data) {
            // 3. Llamas directamente a la variable
            loginPage.escribirDocumento(fila.get("Documento"));
            loginPage.escribirTarjetaDebito(fila.get("NumeroTarjeta"));
            loginPage.escribirClaveInternet(fila.get("Clave"));
            loginPage.clickBotonIngresar();
        }
    }

}