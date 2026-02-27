package page;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends PageObject {

    @FindBy(id = "first-name")
    private WebElementFacade firstNameInput;

    @FindBy(id = "last-name")
    private WebElementFacade lastNameInput;

    @FindBy(id = "postal-code")
    private WebElementFacade postalCodeInput;

    @FindBy(id = "continue")
    private WebElementFacade continueButton;

    @FindBy(id = "finish")
    private WebElementFacade finishButton;

    @FindBy(id = "cancel")
    private WebElementFacade cancelButton;

    @FindBy(css = ".complete-header")
    private WebElementFacade completeHeader;

    @FindBy(css = ".summary_total_label")
    private WebElementFacade totalLabel;

    @FindBy(css = ".title")
    private WebElementFacade pageTitle;

    @FindBy(css = "[data-test='error']")
    private WebElementFacade errorMessage;

    @FindBy(id = "back-to-products")
    private WebElementFacade backButton;

    @FindBy(css = ".summary_subtotal_label")
    private WebElementFacade subtotalLabel;

    @FindBy(css = ".summary_tax_label")
    private WebElementFacade taxLabel;

    public void ingresarDatosCheckout(String nombre, String apellido, String codigoPostal) {
        firstNameInput.waitUntilVisible().type(nombre);
        lastNameInput.type(apellido);
        postalCodeInput.type(codigoPostal);
    }

    public void ingresarNombre(String nombre) {
        firstNameInput.waitUntilVisible().type(nombre);
    }

    public void ingresarApellido(String apellido) {
        lastNameInput.type(apellido);
    }

    public void ingresarCodigoPostal(String codigoPostal) {
        postalCodeInput.type(codigoPostal);
    }

    public void clickContinuar() {
        continueButton.waitUntilClickable().click();
    }

    public void clickFinalizar() {
        finishButton.waitUntilClickable().click();
    }

    public void clickCancelar() {
        cancelButton.waitUntilClickable().click();
    }

    public String obtenerMensajeCompletado() {
        return completeHeader.waitUntilVisible().getText();
    }

    public boolean estaOrdenCompletada() {
        return completeHeader.isVisible() && 
               completeHeader.getText().contains("Thank you for your order");
    }

    public String obtenerTotal() {
        return totalLabel.getText();
    }

    public String obtenerTituloPagina() {
        return pageTitle.waitUntilVisible().getText();
    }

    public String obtenerMensajeError() {
        return errorMessage.waitUntilVisible().getText();
    }

    public boolean seVisualizaMensajeError() {
        return errorMessage.isVisible();
    }

    public void volverAProductos() {
        backButton.waitUntilClickable().click();
    }

    public boolean estaEnPaginaCheckoutInfo() {
        return pageTitle.getText().equals("Checkout: Your Information");
    }

    public boolean estaEnPaginaCheckoutOverview() {
        return pageTitle.getText().equals("Checkout: Overview");
    }

    public String obtenerSubtotal() {
        return subtotalLabel.getText();
    }

    public String obtenerImpuesto() {
        return taxLabel.getText();
    }
}
