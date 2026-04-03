package steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.model.di.ModelInfrastructure; // Nuevo import
import net.thucydides.model.util.EnvironmentVariables; // Este es el correcto ahora
import page.Login.NewLoginPage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginSteps {




    private NewLoginPage newLoginPage() {
        return new NewLoginPage();
    }

    public static List<Map<String, String>> obtenerDatosDesdeCSV(String ruta) throws IOException {
        EnvironmentVariables environmentVariables = ModelInfrastructure.getEnvironmentVariables();
        String ambienteActual = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("environment");
        List<Map<String, String>> listData = new ArrayList<>();
        List<String> cabeceras = new ArrayList<>();

        File file = new File(ruta);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String linea = "";

        int contador = 0;
        while ((linea = bufferedReader.readLine()) != null) {
            String[] valores = linea.split(",",-1);
            int index =0;
            Map<String, String> columnas = new HashMap<>();
            String ambiente = "";
            for(String valor : valores){
                if(contador == 0){
                    cabeceras.add(valor);
                }else{
                    if(index == 0 ){
                        ambiente = valor.toUpperCase();
                    }
                    if(ambiente.equals(ambienteActual.toUpperCase()))
                        columnas.put(cabeceras.get(index), valor);
                }
                index++;
            }
            if(contador > 0) {
                if(!columnas.isEmpty())
                    listData.add(columnas);

            }
            contador++;

        }
        return listData;
    }

    @Step("Cargar página de HomeBanking BCP")
    public void cargarPaginaHomeBanking() {
        // En Serenity 4.x, la forma recomendada de obtener las variables de entorno es:
        EnvironmentVariables environmentVariables = ModelInfrastructure.getEnvironmentVariables();

        String url = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("url.homebanking");

        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("La propiedad 'url.homebanking' no está definida en serenity.conf");
        }

        newLoginPage().openUrl(url);
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("URL de HomeBanking abierta: " + url);
    }

    @Step("Escribir Tarjeta de Débito")
    public void escribirTarjetaDebito(String tarjeta) {
        newLoginPage().escribirTarjetaDebito(tarjeta);
    }

    @Step("Escribir Clave de Internet")
    public void escribirClaveInternet(String clave) throws InterruptedException {
        newLoginPage().escribirClaveInternet(clave);
    }

    @Step("Click en el botón Ingresar")
    public void clickBotonIngresar() {
        newLoginPage().clickBotonIngresar();
    }


}