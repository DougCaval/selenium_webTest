package steps;

import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.ValideCarrinhoPage;

public class ValideCarrinhoStep {

    ValideCarrinhoPage page = new ValideCarrinhoPage();

    @Dado("que o usuario acessa o SauceDemo")
    public void queOUsuarioAcessaOSauceDemo() {
        page.abrirBrowser();
        page.acessarSite();
    }

    @Dado("faz login com usuario {string} e senha {string}")
    public void fazLoginComUsuarioESenha(String usuario, String senha) {
        page.login(usuario, senha);
    }

    @Quando("adiciona um produto ao carrinho")
    public void adicionaUmProdutoAoCarrinho() {
        page.adicionarProdutoAoCarrinho();
    }

    @Entao("o contador do carrinho deve mostrar {string}")
    public void oContadorDoCarrinhoDeveMostrar(String valorEsperado) {
        page.validarContadorCarrinho(valorEsperado);
    }

    @After
    public void finalizar() {
        page.fecharBrowser();
    }
}