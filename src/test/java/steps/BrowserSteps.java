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
@Dado("que o usuário está na tela de login")
public void abrirPaginaLogin() throws InterruptedException {
    loginPage.realizarLogin();
}
@E("informa uma senha válida")
public void informar_senha_valida() {
    loginPage.preencherLogin("", "secret_sauce");
}
@E("deixa o campo usuário em branco")
public void deixar_campo_usuario_em_branco() {
    loginPage.preencherLogin("", "secret_sauce");
}
@E("informa usuario e senha valido")
public void informa_usuario_e_senha_valido() {
    loginPage.preencherLogin("standard_user", "secret_sauce");
}
@E("informa um usuário válido")
public void informar_usuario_valido() {
    loginPage.preencherLogin("standard_user", "");
}
@E("informa uma senha incorreta")
public void informar_senha_incorreta() {
    loginPage.preencherLogin("standard_user", "senha_errada");
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
@Entao("o sistema não deve permitir o acesso")
public void validar_login_bloqueado() {
    Assert.assertFalse(
        "O sistema permitiu um login que deveria ser bloqueado",
        loginPage.loginFoiRealizado()
    );
}
@E("deve exibir a mensagem {string}")
public void validar_mensagem_erro(String mensagem) {
    Assert.assertEquals(
        "A mensagem de erro está incorreta",
        "Epic sadface: Username and password do not match any user in this service",
        loginPage.obterMensagemErro()
    );
}
@E("deve exibir uma mensagem informando que o campo usuário é obrigatório")
public void validar_usuario_obrigatorio() {
    Assert.assertEquals(
        "A mensagem de usuário obrigatório está incorreta",
        "Epic sadface: Username is required",
        loginPage.obterMensagemErro()
    );
}
@E("deve permanecer na tela de login.")
public void validar_permanencia_tela_login() {
    Assert.assertFalse(
        "O usuário não deveria ter acessado a página de produtos",
        loginPage.loginFoiRealizado()
    );
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