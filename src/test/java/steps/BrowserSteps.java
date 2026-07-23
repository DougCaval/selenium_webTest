package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
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
    @Dado("que o usuario esta na tela de login")
    public void que_o_usuario_esta_na_tela_de_login() {
        loginPage.acessarTelaLogin();
    }
    @E("informa o usuario {string} e a senha {string}")
    public void informa_o_usuario_e_a_senha(String usuario, String senha) {
        loginPage.inserirCredenciais(usuario, senha);
    }
    @Quando("clicar no botao {string}")
    public void clicar_no_botao(String botao) {
        loginPage.clicarBotao(botao);
        
    }
    @E("tambem clicar no botao {string}")
    public void tambem_clicar_no_botao(String botao) {
        loginPage.clicarBotao(botao);
        
    }
    @Entao("o sistema deve encerrar a sessao do usuario")
    public void o_sistema_deve_encerrar_a_sessao_do_usuario() {
        loginPage.validarAuth();

    }
    @E("redirecionar para a tela de login")
    public void redirecionar_para_a_tela_de_login() {
        loginPage.validarlogout();
    }
    @Entao("o sistema não deve permitir o acesso")
    public void o_sistema_não_deve_permitir_o_acesso() {
        loginPage.validarlogout();
    }
    @E("deve exibir a mensagem {string}")
    public void deve_exibir_a_mensagem(String mensagem) {
        loginPage.validarMensagem(mensagem);
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