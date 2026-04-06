package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import net.serenitybdd.annotations.Steps;
import steps.LoginSteps;
import steps.TransferSteps;

import java.io.IOException;

import static utils.CredencialesHelper.saveVariableOnSession;

public class LoginStepDefinition {
    @Steps
    LoginSteps loginSteps;

    private LoginSteps loginSteps() {
        return new LoginSteps();
    }

    private Scenario myScenario;

//    @Before()
//
//    public void before(Scenario scenario) {
//        saveVariableOnSession("scenario", scenario);
//        myScenario = scenario;
//    }

    @Dado("que estoy en la página de HomeBanking BCP")
    public void queEstoyEnLaPáginaDeHomeBankingBCP() {
        loginSteps.cargarPaginaHomeBanking();
    }


}
