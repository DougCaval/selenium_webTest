package steps;

import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;
import util.DriverFactory;

public class CheckoutSteps {

    private WebDriver driver;
    private CheckoutPage checkoutPage;

    @Dado("que o usuario acessa a etapa de checkout")
    public void acessarEtapaDeCheckout() {
        driver = DriverFactory.getDriver();
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.acessarEtapaCheckout();
    }

    @Quando("ele preenche nome {string} sobrenome {string} e cep {string}")
    public void preencherDados(String nome, String sobrenome, String cep) {
        checkoutPage.preencherDados(nome, sobrenome, cep);
    }

    @E("clica em continuar no checkout")
    public void clicarContinuarNoCheckout() {
        checkoutPage.clicarContinuar();
    }

    @Entao("deve acessar a tela de overview")
    public void validarTelaOverview() {
        Assert.assertEquals("Checkout: Overview", checkoutPage.obterTituloPagina());
    }

    @Entao("deve exibir erro {string}")
    public void validarMensagemErro(String mensagemEsperada) {
        Assert.assertTrue(checkoutPage.obterMensagemErro().contains(mensagemEsperada));
    }

    @E("clica em finalizar compra")
    public void clicarFinalizarCompra() {
        checkoutPage.clicarFinalizar();
    }

    @Entao("deve exibir mensagem de sucesso da compra")
    public void validarMensagemSucesso() {
        Assert.assertEquals("Thank you for your order!", checkoutPage.obterMensagemSucesso());
    }

    @After
    public void fechar() {
        DriverFactory.quit();
    }
}
