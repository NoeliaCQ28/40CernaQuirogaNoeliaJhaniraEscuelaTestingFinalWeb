package stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.es.Dado;
import net.serenitybdd.annotations.Steps;

public class LoginBCPStepDefinitions {
    public LoginBCPStepDefinitions() {
        @Steps
        LoginBCPHBSteps loginBCPHBSteps;

        @Dado("^que estoy en la página de inicio de sesión de HomeBanking BCP$")
        public void queEstoyEnLaPaginaDeInicioDeSesionDeHomeBankingBCP() {
            loginBCPHBSteps.abrirLoginBCP();
        }
    }
}
