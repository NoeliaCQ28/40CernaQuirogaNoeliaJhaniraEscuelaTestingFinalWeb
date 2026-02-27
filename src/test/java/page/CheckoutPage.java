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

    public void ingresarDatosCheckout(String nombre, String apellido, String codigoPostal) {
        firstNameInput.waitUntilVisible().type(nombre);
        lastNameInput.type(apellido);
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
}
