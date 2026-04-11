package steps;

import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductPage;
import util.DriverFactory;

import java.util.List;

public class ProductSteps {

    WebDriver driver;
    LoginPage loginPage;
    ProductPage productPage;

    @Dado("que o usuário está logado na página de produtos")
    public void queOUsuarioEstaLogadoNaPaginaDeProdutos() {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        productPage = new ProductPage();

        loginPage.acessarSite();
        loginPage.preencherUsuario("standard_user");
        loginPage.preencherSenha("secret_sauce");
        loginPage.clicarLogin();
    }

    @Entao("deve exibir todos os produtos")
    public void deveExibirTodosOsProdutos() {
        int quantidadeProdutos = productPage.contarProdutosVisiveis();
        Assert.assertTrue("Esperado que todos os produtos sejam exibidos", quantidadeProdutos > 0);
    }

    @Quando("ordenar produtos por preço menor a maior")
    public void ordenarProdutosPorPrecoMenorAMaior() {
        productPage.ordenarPorPrecoMenorMaior();
    }

    @Entao("os produtos devem ser exibidos por preço em ordem crescente")
    public void produtosDevemSerExibidosPorPrecoOrdemCrescente() {
        List<Double> precos = productPage.obterPrecosExibidos();
        for (int i = 1; i < precos.size(); i++) {
            Assert.assertTrue("O preço deve estar em ordem crescente", precos.get(i) >= precos.get(i - 1));
        }
    }

    @Quando("ordenar produtos por nome de A a Z")
    public void ordenarProdutosPorNomeDeAAZ() {
        productPage.ordenarPorNomeAtoZ();
    }

    @Entao("os produtos devem ser exibidos em ordem alfabética A a Z")
    public void produtosDevemSerExibidosOrdemAlfabetica() {
        List<String> nomes = productPage.obterNomesExibidos();
        for (int i = 1; i < nomes.size(); i++) {
            Assert.assertTrue("Os nomes devem estar em ordem alfabética A a Z", nomes.get(i).compareToIgnoreCase(nomes.get(i - 1)) >= 0);
        }
    }

    @Entao("cada item deve exibir imagem, nome e preço")
    public void cadaItemDeveExibirImagemNomePreco() {
        Assert.assertTrue("Cada produto deve exibir imagem, nome e preço", productPage.todosProdutosTemImagemNomePreco());
    }

    @After
    public void fechar() {
        DriverFactory.quit();
    }
}
