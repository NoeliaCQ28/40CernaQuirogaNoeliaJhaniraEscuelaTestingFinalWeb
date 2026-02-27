package page;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.saucedemo.com")
public class LoginPage extends PageObject {

    @FindBy(id = "user-name")
    private WebElementFacade usernameInput;

    @FindBy(id = "password")
    private WebElementFacade passwordInput;

    @FindBy(id = "login-button")
    private WebElementFacade loginButton;

    @FindBy(css = "[data-test='error']")
    private WebElementFacade errorMessage;

    @FindBy(css = ".error-button")
    private WebElementFacade errorButton;

    public void ingresarUsuario(String usuario) {
        usernameInput.waitUntilVisible().type(usuario);
    }

    public void ingresarPassword(String password) {
        passwordInput.waitUntilVisible().type(password);
    }

    public void clickLogin() {
        loginButton.waitUntilClickable().click();
    }

    public void login(String usuario, String password) {
        ingresarUsuario(usuario);
        ingresarPassword(password);
        clickLogin();
    }

    public String obtenerMensajeError() {
        return errorMessage.waitUntilVisible().getText();
    }

    public boolean seVisualizaMensajeError() {
        return errorMessage.isVisible();
    }

    public void limpiarCampos() {
        usernameInput.clear();
        passwordInput.clear();
    }

    public boolean estaCampoUsuarioVacio() {
        return usernameInput.getValue().isEmpty();
    }

    public boolean estaCampoPasswordVacio() {
        return passwordInput.getValue().isEmpty();
    }
}
