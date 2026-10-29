package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import util.DriverFactory;


public class BrowserSteps {

    private LoginPage loginPage;
    private WebDriver driver;


    @Before
    public void iniciar(){

        loginPage = new LoginPage();   // ✅ cria objeto
    }

    @Dado("que abro o navegador")
    public void que_abro_o_navegador() throws InterruptedException {
        loginPage.realizarLogin();
        loginPage.inserirDados();


    }
@Dado("que o usuario esta em na tela de login")
public void abrirPaginaLogin() throws InterruptedException {
    loginPage.realizarLogin();
}
@E("informa usuario e senha valido")
public void informa_usuario_e_senha_valido() {
    loginPage.preencherLogin("standard_user", "secret_sauce");
}
@Quando("clicar no botão {string}")
public void clicar_no_botao_entrar(String botao) {
    loginPage.clicarLogin();
}
@Entao("o sistema deve permitir o acesso do usuario.")
public void validar_login_com_sucesso() {
    Assert.assertTrue("O login não foi realizado com sucesso",
            loginPage.loginFoiRealizado());
}
    @Quando("o usuario adiciona um produto no carrinho")
    public void adiciona_um_produto_no_carrinho() throws InterruptedException {
        loginPage.adicionarProduto();
        Thread.sleep(5000);


    }


    @After
    public void fechar(){

        DriverFactory.quit();
    }
}