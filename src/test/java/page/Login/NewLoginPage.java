package page.Login;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class NewLoginPage extends PageObject {

    @FindBy(xpath = "//input[@id='bcp-input-1']")
    private WebElement InputDocumento;

    @FindBy(xpath = "//input[@name='ciam-input-card']")
    private WebElement InputTarjeta;

    @FindBy(xpath = "//bcp-keyboard-input")
    private WebElement InputPassword;

    @FindBy(xpath = "//button[@class='bcp-ffw-btn bcp-ffw-btn-primary bcp-ffw-btn-lg bcp-ffw-btn-block']")
    private WebElement btnIngresar;

    public void escribirTarjetaDebito(String tarjeta) {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOf(InputTarjeta));
        InputTarjeta.sendKeys(tarjeta);

        String textoIngresado = InputTarjeta.getAttribute("value");
        if(!textoIngresado.equals(tarjeta)) {
            throw new RuntimeException("El texto ingresado en el campo de tarjeta no coincide con el valor esperado.");
        }
    }

    public void escribirDocumento(String documento) {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2000));
        wait.until(ExpectedConditions.visibilityOf(InputDocumento));
        InputDocumento.sendKeys(documento);

        String textoIngresado = InputDocumento.getAttribute("value");
        if(!textoIngresado.equals(documento)) {
            throw new RuntimeException("El texto ingresado en el campo de tarjeta no coincide con el valor esperado.");
        }
    }

    public void escribirClaveInternet(String clave) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOf(InputPassword));
        InputPassword.click();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        String teclaActual ="";
        for (String numero : clave.split("")){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i=0; i<10; i++){
                teclaActual = "bcp-keyboard-key[index='"+ (i + 1) +"']";
                String valor = (String)
                        (jsExecutor.executeScript("return document.querySelector(\"bcp-keyboard-input\")shadowRoot.querySeñector(\"" + teclaActual + "\").innerText"));
                System.out.println(valor);
                valor = (valor == null) ? "" : valor;
                System.out.println("En el index " + (i + 1) + " se encuentra el numero: " + valor);
                if (valor.equals(numero)){
                    String query = "return document.querySelector(\"bcp-keyboard-input\").shadowRoot.querySelector(\"" + teclaActual + "\")";
                    WebElement teclaEncontrada = (WebElement) jsExecutor.executeScript(query);
                    System.out.println("Se hizo click en el numero: " + numero);
                    if(teclaEncontrada != null)
                        teclaEncontrada.click();
                    break;
                }
            }

        }

        String textoIngresado = InputPassword.getAttribute("value");
        if(!textoIngresado.equals(clave)) {
            throw new RuntimeException("El texto ingresado en el campo de clave no coincide con el valor esperado.");
        }
    }

    public void clickBotonIngresar() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(btnIngresar));
        btnIngresar.click();
    }
}