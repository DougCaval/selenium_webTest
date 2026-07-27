package steps;

import io.cucumber.java.Before;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import util.DriverFactory;

public class CompraSteps {

    private LoginPage loginPage;
    private WebDriver driver;


    @Before
    public void iniciar(){

        loginPage = new LoginPage();   // ✅ cria objeto
    }

@E("validar os produtos no carrinho e realizar o checkout")
public void validar_Carrinho_e_realizar_checkout()throws InterruptedException {
    loginPage.validarCarrinho();
    loginPage.realizarCheckout();
}

@E("clique em continue")
public void clique_continue()throws InterruptedException {
    loginPage.botaoContinue();

}

@Entao("devo visualizar a mensagem de erro {string}")
public void mensagem_erro(String mensagemEsperada) {
    // Chama o método que localiza o elemento e pega o texto
    String mensagemReal = loginPage.obterTextoMensagemErro();

    // Faz a asserção comparando os dois
    Assert.assertEquals(mensagemEsperada, mensagemReal);
}

    @E("preencher as informações para compra")
    public void preencher_informacoes()throws InterruptedException {
        loginPage.inserirDadosCompras();

    }

    @Entao("clique em finish")
    public void clicar_em_finish()throws InterruptedException {
        loginPage.cliqueEmFinish();
    }

    @Dado("que o usuario esta em na tela de login")
    public void queOUsuarioEstaNaTelaDeLogin() throws InterruptedException {
        loginPage.realizarLogin();
    }

    @E("informa usuario e senha valido")
    public void informaUsuarioESenhaValido() throws InterruptedException{
        loginPage.inserirDados();
    }

    @Quando("clicar no botao Login")
    public void clicarNoBotaoEntrar() throws InterruptedException{
        loginPage.inserirDados();

    }

    @Entao("o sistema deve permitir o acesso do usuario")
    public void oSistemaDevePermitirOAcessoDoUsuario() throws InterruptedException{
        loginPage.inserirDados();

    }


    @Dado("que o usuário acessou a tela de login")
    public void queOUsuarioAcessouATelaDeLogin() {

    }

    @E("informa um usuário válido")
    public void informaUmUsuarioValido() {

    }

    @E("informa uma senha incorreta")
    public void informaUmaSenhaIncorreta() {

    }

    @Entao("o sistema não deve permitir o acesso")
    public void oSistemaNaoDevePermitirOAcesso() {

    }

    @E("deve exibir a mensagem {string}")
    public void deveExibirAMensagem(String mensagem) {

    }


    @Dado("que o usuário está na tela de login")
    public void queOUsuarioEstaNaTelaDeLoginSenha() {

    }

    @E("informa uma senha válida")
    public void informaUmaSenhaValida() {

    }

    @E("deixa o campo usuário em branco")
    public void deixaOCampoUsuarioEmBranco() {

    }

    @E("deve exibir uma mensagem informando que o campo usuário é obrigatório")
    public void deveExibirUmaMensagemInformandoQueOCampoUsuarioEObrigatorio() {

    }

    @E("deve permanecer na tela de login")
    public void devePermanecerNaTelaDeLogin() {

    }

@After
public void fechar(){

    DriverFactory.quit();
}
}
