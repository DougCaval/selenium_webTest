package steps;

import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.inventarioPage;
import util.DriverFactory;

public class InventarioSteps {

    private LoginPage loginPage;
    private inventarioPage inventarioPage;
    private WebDriver driver;

    @Before
    public void iniciar() {

        loginPage = new LoginPage();
        inventarioPage = new inventarioPage();
        driver = DriverFactory.getDriver();
    }

    @Dado("que o usuário acessou a pagina de inventário")
    public void que_o_usuario_acessou_a_pagina_de_inventario() throws InterruptedException {
loginPage.realizarLogin();
        loginPage.inserirDados();
    }

    @Quando("a pagina for carregada")
    public void a_pagina_for_carregada() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue("A página de inventário não foi carregada corretamente.",
                inventarioPage.isPaginaInventarioCarregada());
    }

    @Entao("a lista de produtos deve ser exibida")
    public void a_lista_de_produtos_deve_ser_exibida() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue("A lista de produtos não está visível na página.",
                inventarioPage.isPaginaInventarioCarregada());
    }

    @Quando("clicar no botão {string} de um produto escolhido")
    public void clicar_no_botao_de_um_produto_escolhido(String botao) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue("A lista de produtos não está visível para selecionar um item.",
                inventarioPage.isPaginaInventarioCarregada());

        if (botao.equalsIgnoreCase("Adicionar ao carrinho")) {
            inventarioPage.clicarAdicionarAoCarrinho();
        }

        Thread.sleep(3000);
    }

    @Entao("o produto deve ser adicionado ao carrinho de compras")
    public void o_produto_deve_ser_adicionado_ao_carrinho_de_compras() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue("O produto não foi adicionado ao carrinho de compras.",
                inventarioPage.isProdutoAdicionadoAoCarrinho());
    }

    @E("se direcionar ao botão de filtragem a direita")
    public void se_direcionar_ao_botao_de_filtragem_a_direita() throws InterruptedException {
inventarioPage.clicarBotaoFiltragem();
    }

    @Quando("selecionar a opção {string}")
    public void selecionar_a_opcao(String opcao) throws InterruptedException {
        if (opcao.equalsIgnoreCase("Nome (A-Z)")) {
            inventarioPage.selecionarOpcaoNomeAZ();
        }
    }

    @Entao("os produtos devem ser exibidos em ordem alfabética crescente")
    public void os_produtos_devem_ser_exibidos_em_ordem_alfabetica() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue("Os produtos não foram exibidos em ordem alfabética crescente.",
                inventarioPage.isProdutosEmOrdemAlfabeticaCrescente());
    }

    @After
    public void fechar() {

        DriverFactory.quit();
    }
}
