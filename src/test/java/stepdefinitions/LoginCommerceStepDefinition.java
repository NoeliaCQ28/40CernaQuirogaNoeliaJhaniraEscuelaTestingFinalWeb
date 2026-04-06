package stepdefinitions;

import io.cucumber.java.Scenario;
import io.cucumber.java.es.Dado;
import net.serenitybdd.annotations.Steps;
import steps.LoginCommerceSteps;

public class LoginCommerceStepDefinition {
    @Steps
    LoginCommerceSteps loginCommerceSteps;

    private LoginCommerceSteps loginCommerceSteps() {
        return new LoginCommerceSteps();
    }

    private Scenario myScenario;

//    @Before()
//
//    public void before(Scenario scenario) {
//        saveVariableOnSession("scenario", scenario);
//        myScenario = scenario;
//    }

    @Dado("que estoy en la página de Nop Commerce")
    public void queEstoyEnLaPaginaDeNopCommerce() {
        loginCommerceSteps.cargarPaginaNopCommerce();
    }


}
