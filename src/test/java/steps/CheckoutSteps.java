package steps;

import io.cucumber.java.Before;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import util.DriverFactory;

public class CheckoutSteps {

    private LoginPage loginPage;
    private WebDriver driver;


    @Before
    public void iniciar(){

        loginPage = new LoginPage();
        driver = DriverFactory.getDriver();
    }

@Dado("que abro o navegador")
public void que_abro_o_navegador() throws InterruptedException {
    loginPage.realizarLogin();
    loginPage.inserirDados();
}

@E("que o usuario possui ao menos um produto no carrinho")
public void usuario_possui_ao_menos_um_produto_no_carrinho()throws InterruptedException {
    loginPage.adicionarProduto();
    loginPage.validarCarrinho();
}

@E("esta na pagina de checkout")
    public void esta_na_pagina_de_checkout() throws InterruptedException {
        loginPage.realizarCheckout();
}

@Quando("preencher os dados de checkout")
    public void preencher_os_dados_de_checkout() throws InterruptedException {
        loginPage.preencherDadosCheckout();
}

@E("clicar em continue")
public void clique_continue()throws InterruptedException {
    loginPage.botaoContinue();

}

@Entao("deve ser direcionado para a pagina de overview do pedido")
public void direcionado_para_overview()throws InterruptedException {
    loginPage.lerEValidarOverview();
}

@Dado("que abre o navegador")
public void que_abre_o_navegador() throws InterruptedException {
    loginPage.realizarLogin();
    loginPage.inserirDados();
    }

@E("que o usuario possui pelo menos um produto no carrinho")
public void usuario_possui_pelo_menos_um_produto_no_carrinho()throws InterruptedException {
    loginPage.adicionarProduto();
    loginPage.validarCarrinho();
    }

@E("esteja na pagina de checkout")
    public void esteja_na_pagina_de_checkout() throws InterruptedException {
        loginPage.realizarCheckout();
    }

@Quando("clicar no botão Cancel")
    public void clicar_botão_cancel() throws InterruptedException {
        loginPage.clicarBotaoCancel();
    }

@Entao("deve ser direcionado para a pagina do carrinho")
    public void direcionado_para_carrinho()throws InterruptedException {
        loginPage.lerEValidarCarrinho();

}

@After
public void fechar(){

    DriverFactory.quit();
}
}
