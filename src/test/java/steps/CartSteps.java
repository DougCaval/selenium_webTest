package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.LoginPage;
import util.DriverFactory;

public class CartSteps {

    WebDriver driver;
    LoginPage loginPage;
    CartPage cartPage;

    @Before
    public void setup() {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);
        loginPage.acessarSite();
        loginPage.preencherUsuario("standard_user");
        loginPage.preencherSenha("secret_sauce");
        loginPage.clicarLogin();
    }

    @Quando("o usuario adiciona o produto ao carrinho")
    public void adicionarProduto() {
        cartPage.adicionarProduto();
    }

    @Quando("o usuario remove o produto do carrinho")
    public void removerProduto() {
        cartPage.adicionarProduto();
        cartPage.removerProduto();
    }

    @Entao("o produto deve estar no carrinho")
    public void validarProdutoAdicionado() {
        Assert.assertTrue(cartPage.badgeEstaVisivelComValor("1"));
    }

    @Entao("o carrinho deve estar vazio")
    public void validarCarrinhoVazio() {
        Assert.assertTrue(cartPage.badgeNaoEstaVisivel());
    }

    @Entao("o badge do carrinho deve exibir {string}")
    public void validarBadge(String valor) {
        Assert.assertTrue(cartPage.badgeEstaVisivelComValor(valor));
    }

    @Quando("o usuario acessa o carrinho")
    public void acessarCarrinho() {
        cartPage.adicionarProduto();
        cartPage.acessarCarrinho();
    }

    @Entao("deve exibir o produto {string} na lista")
    public void validarItemNoCarrinho(String nomeProduto) {
        Assert.assertTrue(cartPage.produtoEstaNoCarrinho(nomeProduto));
    }

    @After
    public void fechar() {
        DriverFactory.quit();
    }
}