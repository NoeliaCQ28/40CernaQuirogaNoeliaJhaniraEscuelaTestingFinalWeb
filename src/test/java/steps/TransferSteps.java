package steps;

import page.Login.NewLoginPage;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TransferSteps {
//    private TransferPage transferPage() {
//        return new TransferPage();
//    }

    private NewLoginPage newLoginPage(){
        return new NewLoginPage();
    }

    public void ingresoDatosDesde(String csv) throws InterruptedException, IOException {
        List<Map<String, String>> data = LoginSteps.obtenerDatosDesdeCSV(csv);
        boolean ejecucionExitosa = true;
        for (Map<String, String> fila : data) {
            newLoginPage().escribirDocumento(fila.get("documento"));
            newLoginPage().escribirTarjetaDebito(fila.get("tarjeta"));
            newLoginPage().escribirClaveInternet(fila.get("clave"));
            newLoginPage().clickBotonIngresar();
        }
    }

}
