package steps;

import io.cucumber.java.Before;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
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



@After
public void fechar(){

    DriverFactory.quit();
}
}
