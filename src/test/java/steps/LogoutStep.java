package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import pages.LogoutPage;
import util.DriverFactory;

public class LogoutStep {

    private LogoutPage logoutPage;

    @Before
    public void iniciar() {
        DriverFactory.getDriver();
        logoutPage = new LogoutPage();
    }

    @After
    public void encerrar() {
        DriverFactory.quit();
    }

    @Dado("que o usuario esta logado no sistema")
    public void que_o_usuario_esta_logado_no_sistema() throws InterruptedException {
        logoutPage.fazerLogin();
    }

    @Quando("o usuario acessa o menu e clica em logout")
    public void o_usuario_acessa_o_menu_e_clica_em_logout() throws InterruptedException {
        logoutPage.realizarLogout();
    }

    @Entao("o usuario e redirecionado para a tela de login")
    public void o_usuario_e_redirecionado_para_a_tela_de_login() {
        String urlAtual = logoutPage.obterUrlAtual();
        Assert.assertEquals("https://www.saucedemo.com/", urlAtual);
    }
}
