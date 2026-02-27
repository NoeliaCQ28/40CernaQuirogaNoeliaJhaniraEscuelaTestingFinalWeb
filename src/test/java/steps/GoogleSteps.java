package steps;

import net.serenitybdd.annotations.Step;
import page.GooglePage;

public class GoogleSteps {

    GooglePage googlePage;

    @Step
    public void abrirGoogle() {
        googlePage.open();
    }
}
