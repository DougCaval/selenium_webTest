package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import pages.CarrinhoPage;
import util.DriverFactory;

public class CarrinhoSteps {

    private CarrinhoPage carrinhoPage;

    @Before
    public void iniciar() {
        carrinhoPage = new CarrinhoPage();
    }

    @Dado("que o usuario fez login no site")
    public void queOUsuarioFezLoginNoSite() {
        carrinhoPage.fazerLogin();
    }

    @Quando("o usuario adiciona um produto ao carrinho")
    public void oUsuarioAdicionaUmProdutoAoCarrinho() {
        carrinhoPage.adicionarProduto();
    }

    @Quando("o usuario remove o produto do carrinho")
    public void oUsuarioRemoveOProdutoDoCarrinho() {
        carrinhoPage.removerProduto();
    }

    @Quando("o usuario acessa o carrinho")
    public void oUsuarioAcessaOCarrinho() {
        carrinhoPage.acessarCarrinho();
    }

    @Entao("o contador do carrinho deve ser 1")
    public void oContadorDoCarrinhoDeveSer1() {
        Assert.assertEquals("1", carrinhoPage.obterContadorCarrinho());
    }

    @Entao("o carrinho deve estar vazio")
    public void oCarrinhoDeveEstarVazio() {
        Assert.assertTrue("O carrinho nao esta vazio", carrinhoPage.carrinhoEstaVazio());
    }

    @Entao("o produto deve estar listado no carrinho")
    public void oProdutoDeveEstarListadoNoCarrinho() {
        Assert.assertTrue("Nenhum produto encontrado no carrinho", carrinhoPage.produtoEstaNoCarrinho());
    }

    @After
    public void fechar() {
        DriverFactory.quit();
    }
}
