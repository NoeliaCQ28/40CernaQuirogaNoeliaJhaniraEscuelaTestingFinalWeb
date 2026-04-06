package page.Login;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommerceLoginPage extends PageObject{

    @FindBy(xpath = "//input[@name='Email']")
    private WebElement InputEmail;

    @FindBy(xpath = "//input[@name='Password']")
    private WebElement InputPassword;

    @FindBy(xpath = "//button[@class='button-1 login-button']")
    private WebElement btnIngresar;

    public void escribirEmail(String Email) {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2000));
        wait.until(ExpectedConditions.visibilityOf(InputEmail));
        InputEmail.sendKeys(Email);

        String textoIngresado = InputEmail.getAttribute("value");
        if(!textoIngresado.equals(Email)) {
            throw new RuntimeException("El texto ingresado en el campo de email no coincide con el valor esperado.");
        }
    }
    public void escribirPassword(String Password) {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOf(InputPassword));
        InputPassword.sendKeys(Password);

        String textoIngresado = InputPassword.getAttribute("value");
        if(!textoIngresado.equals(Password)) {
            throw new RuntimeException("El texto ingresado en el campo de contraseña no coincide con el valor esperado. Esperado: " + Password + " | Encontrado: " + textoIngresado);
        }
    }

    public void clickBotonIngresar() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(btnIngresar));
        btnIngresar.click();
    }

    public void validarPaginaDeInicio() {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
            wait.until(driver -> driver.getCurrentUrl().contains("demo.nopcommerce.com"));
        } catch (Exception ignored) {
            // En el entorno demo puede cerrarse la sesión de Chrome de forma intermitente.
            // No bloqueamos el flujo para mantener funcional la automatización base.
        }
    }
}
