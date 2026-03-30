package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import util.DriverFactory;


public class BrowserSteps {

    private LoginPage loginPage;
    private WebDriver driver;

    @Before
    public void iniciar(){

        loginPage = new LoginPage();   // ✅ cria objeto
    }

    @Dado("que abro o navegador")
    public void que_abro_o_navegador() throws InterruptedException {
        loginPage.realizarLogin();
        loginPage.inserirDados();


    }

    @Quando("o usuario adiciona um produto no carrinho")
    public void adiciona_um_produto_no_carrinho() throws InterruptedException {
        loginPage.adicionarProduto();
        Thread.sleep(5000);


    }



    @After
    public void fechar(){

        DriverFactory.quit();
    }
}