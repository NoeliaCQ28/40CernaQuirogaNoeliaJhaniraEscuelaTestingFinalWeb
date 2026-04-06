package steps;

import page.Login.CommerceLoginPage;
import net.serenitybdd.annotations.Step;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CommerceSteps {

    // 1. Declaras la página como una variable (Serenity la inicializará sola, ¡no uses 'new'!)
    CommerceLoginPage loginPage;

    // 2. Usas la anotación @Step para que salga en tu reporte de Serenity
    @Step
    public void ingresoDatosDesde(String csv) throws InterruptedException, IOException {
        List<Map<String, String>> data = LoginSteps.obtenerDatosDesdeCSV(csv);

        for (Map<String, String> fila : data) {
            // 3. Llamas directamente a la variable
            loginPage.escribirEmail(fila.get("Email"));
            loginPage.escribirPassword(fila.get("Password"));
        }
    }

    @Step
    public void hagoClicEnBoton(String nombreBoton) {
        if ("Log In".equalsIgnoreCase(nombreBoton)) {
            loginPage.clickBotonIngresar();
        } else {
            throw new IllegalArgumentException("Botón no soportado en Commerce: " + nombreBoton);
        }
    }

    @Step
    public void deberiaVerLaPaginaDeInicio() {
        loginPage.validarPaginaDeInicio();
    }

}