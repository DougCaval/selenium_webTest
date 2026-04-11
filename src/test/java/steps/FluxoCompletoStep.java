package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import pages.FluxoCompletoPage;
import util.DriverFactory;

public class FluxoCompletoStep {

    private FluxoCompletoPage fluxoCompletoPage;

    @Before
    public void iniciar() {
        DriverFactory.getDriver();
        fluxoCompletoPage = new FluxoCompletoPage();
    }

    @After
    public void encerrar() {
        DriverFactory.quit();
    }

    @Dado("que o usuario realiza login com sucesso")
    public void que_o_usuario_realiza_login_com_sucesso() throws InterruptedException {
        fluxoCompletoPage.fazerLogin();
    }

    @Quando("adiciona um produto ao carrinho")
    public void adiciona_um_produto_ao_carrinho() throws InterruptedException {
        fluxoCompletoPage.adicionarUmProduto();
    }

    @Quando("adiciona multiplos produtos ao carrinho")
    public void adiciona_multiplos_produtos_ao_carrinho() throws InterruptedException {
        fluxoCompletoPage.adicionarMultiplosProdutos();
    }

    @E("acessa o carrinho e inicia o checkout")
    public void acessa_o_carrinho_e_inicia_o_checkout() throws InterruptedException {
        fluxoCompletoPage.acessarCarrinhoEIniciarCheckout();
    }

    @E("preenche os dados de entrega")
    public void preenche_os_dados_de_entrega() throws InterruptedException {
        fluxoCompletoPage.preencherDadosEntrega();
    }

    @Entao("a compra e finalizada com sucesso")
    public void a_compra_e_finalizada_com_sucesso() {
        String mensagem = fluxoCompletoPage.obterMensagemSucesso();
        Assert.assertEquals("Thank you for your order!", mensagem);
    }
}
