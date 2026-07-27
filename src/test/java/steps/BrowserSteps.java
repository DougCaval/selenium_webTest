package steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.LoginPage;
import util.DriverFactory;


public class BrowserSteps {

    private LoginPage loginPage;
    private WebDriver driver;


    @Before
    public void iniciar(){
        loginPage = new LoginPage();
        driver = DriverFactory.getDriver();
    }

    // ---- Cenario 1: Acessar carrinho pelo icone com itens adicionados ----

    @Dado("que eu adicionei Sauce Labs Backpack ao carrinho")
    public void adicionar_backpack_ao_carrinho() throws InterruptedException {
        loginPage.realizarLogin();
        loginPage.inserirDados();
        loginPage.adicionarProduto();
        loginPage.validarContadorCarrinho(1);
    }

    @E("estou na pagina de inventario")
    public void estou_na_pagina_de_inventario(){
        // vazio: login/inventario ja garantidos pelo Dado acima
    }

    @Quando("eu clicar no icone do carrinho")
    public void clicar_no_icone_do_carrinho() throws InterruptedException {
        loginPage.validarCarrinho();
    }

    @Entao("devo ser redirecionado para cart.html")
    public void devo_ser_redirecionado_para_cart_html() throws InterruptedException {
        Assert.assertEquals("https://www.saucedemo.com/cart.html", driver.getCurrentUrl());
    }

    @Entao("o produto Sauce Labs Backpack deve estar listado no carrinho")
    public void validar_produto_no_carrinho() throws InterruptedException {
        loginPage.obterNomeProduto();
    }

    // ---- Cenario 2: Validar atualizacao do contador do carrinho ----

    @Dado("que estou na pagina de inventario")
    public void que_estou_na_pagina_de_inventario() throws InterruptedException {
        loginPage.realizarLogin();
        loginPage.inserirDados();
    }

    @Quando("eu adicionar um produto ao carrinho")
    public void eu_adicionar_um_produto_ao_carrinho() throws InterruptedException {
        loginPage.adicionarProduto();
    }

    @Entao("o contador do carrinho deve exibir {int}")
    public void o_contador_do_carrinho_deve_exibir(Integer quantidadeEsperada) {
    loginPage.validarContadorCarrinho(quantidadeEsperada);
    }

    @After
    public void fechar(){
        DriverFactory.quit();
    }
}