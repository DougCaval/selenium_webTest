package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;
import pages.LoginPage;
import util.DriverFactory;

public class CheckoutSteps {

    private LoginPage loginPage;
    private CheckoutPage checkoutPage;
    private WebDriver driver;

    @Before
    public void iniciar() {
        loginPage = new LoginPage();
        checkoutPage = new CheckoutPage();
        driver = DriverFactory.getDriver();
    }

    @E("adiciono um produto ao carrinho")
    public void adiciono_um_produto_ao_carrinho() throws InterruptedException {
        loginPage.adicionarProduto();
    }

    @Quando("acesso o carrinho sem produtos")
    public void acesso_o_carrinho_sem_produtos() throws InterruptedException {
        checkoutPage.acessarCarrinho();
    }

    @Entao("devo ver o carrinho vazio")
    public void devo_ver_o_carrinho_vazio() {
        Assert.assertTrue(driver.getPageSource().contains("Your cart is empty")
                || driver.findElements(By.className("cart_item")).isEmpty());
    }

    @Quando("acesso o checkout e preencho os dados corretamente")
    public void acesso_o_checkout_e_preencho_os_dados() throws InterruptedException {
        checkoutPage.acessarCarrinho();
        checkoutPage.clicarCheckout();
        checkoutPage.preencherDados();
    }

    @Entao("devo ver a tela de resumo da compra")
    public void devo_ver_resumo() {
        Assert.assertTrue(checkoutPage.resumoVisivelComDados());
    }

    @Quando("acesso o checkout e clico em continuar sem preencher os dados")
    public void acesso_checkout_sem_dados() throws InterruptedException {
        checkoutPage.acessarCarrinho();
        checkoutPage.clicarCheckout();
        driver.findElement(By.id("continue")).click();
    }

    @Entao("devo ver uma mensagem de erro")
    public void devo_ver_mensagem_erro() {
        Assert.assertFalse(checkoutPage.obterMensagemErro().isEmpty());
    }

    @Quando("acesso o checkout preencho os dados e finalizo a compra")
    public void finalizo_compra() throws InterruptedException {
        checkoutPage.acessarCarrinho();
        checkoutPage.clicarCheckout();
        checkoutPage.preencherDados();
        checkoutPage.finalizarCompra();
    }

    @Entao("devo ver a mensagem de pedido confirmado")
    public void devo_ver_pedido_confirmado() {
        Assert.assertEquals("Thank you for your order!", checkoutPage.obterMensagemSucesso());
    }

    @Entao("devo ver o nome do produto o preco e as taxas")
    public void devo_ver_resumo_com_dados() {
        Assert.assertTrue(checkoutPage.resumoVisivelComDados());
    }

    @After
    public void fechar() {
        DriverFactory.quit();
    }
}