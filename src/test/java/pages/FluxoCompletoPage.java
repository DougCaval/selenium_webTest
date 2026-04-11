package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.DriverFactory;

public class FluxoCompletoPage {

    private WebDriver driver = DriverFactory.getDriver();

    By campoUsuario   = By.id("user-name");
    By campoSenha     = By.id("password");
    By botaoLogin     = By.id("login-button");
    By adicionarProduto  = By.id("add-to-cart-sauce-labs-backpack");
    By adicionarProduto2 = By.id("add-to-cart-sauce-labs-bike-light");
    By iconeCarrinho  = By.className("shopping_cart_link");
    By botaoCheckout  = By.id("checkout");
    By campoNome      = By.id("first-name");
    By campoSobrenome = By.id("last-name");
    By campoCep       = By.id("postal-code");
    By botaoContinuar = By.id("continue");
    By botaoFinalizar = By.id("finish");
    By mensagemSucesso = By.className("complete-header");

    public void fazerLogin() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);
        driver.findElement(campoUsuario).sendKeys("standard_user");
        driver.findElement(campoSenha).sendKeys("secret_sauce");
        driver.findElement(botaoLogin).click();
        Thread.sleep(1000);
    }

    public void adicionarUmProduto() throws InterruptedException {
        driver.findElement(adicionarProduto).click();
        Thread.sleep(1000);
    }

    public void adicionarMultiplosProdutos() throws InterruptedException {
        driver.findElement(adicionarProduto).click();
        Thread.sleep(500);
        driver.findElement(adicionarProduto2).click();
        Thread.sleep(1000);
    }

    public void acessarCarrinhoEIniciarCheckout() throws InterruptedException {
        driver.findElement(iconeCarrinho).click();
        Thread.sleep(2000);
        driver.findElement(botaoCheckout).click();
        Thread.sleep(1000);
    }

    public void preencherDadosEntrega() throws InterruptedException {
        driver.findElement(campoNome).sendKeys("Joao");
        driver.findElement(campoSobrenome).sendKeys("Silva");
        driver.findElement(campoCep).sendKeys("12345");
        driver.findElement(botaoContinuar).click();
        Thread.sleep(1000);
        driver.findElement(botaoFinalizar).click();
        Thread.sleep(1000);
    }

    public String obterMensagemSucesso() {
        return driver.findElement(mensagemSucesso).getText();
    }
}