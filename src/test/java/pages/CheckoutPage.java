package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.DriverFactory;

public class CheckoutPage {

    By botaoCarrinho = By.id("shopping_cart_container");
    By botaoCheckout = By.id("checkout");
    By campoPrimeiroNome = By.id("first-name");
    By campoSobrenome = By.id("last-name");
    By campoCep = By.id("postal-code");
    By botaoContinuar = By.id("continue");
    By botaoFinalizar = By.id("finish");
    By mensagemSucesso = By.className("complete-header");
    By mensagemErro = By.cssSelector("[data-test='error']");
    By precoTotal = By.className("summary_total_label");
    By nomeProduto = By.className("inventory_item_name");

    WebDriver driver;

    public CheckoutPage() {
        driver = DriverFactory.getDriver();
    }

    public void acessarCarrinho() throws InterruptedException {
        driver.findElement(botaoCarrinho).click();
        Thread.sleep(5000);
    }

    public void clicarCheckout() throws InterruptedException {
        driver.findElement(botaoCheckout).click();
        Thread.sleep(3000);
    }

    public void preencherDados() throws InterruptedException {
        driver.findElement(campoPrimeiroNome).sendKeys("John");
        driver.findElement(campoSobrenome).sendKeys("Doe");
        driver.findElement(campoCep).sendKeys("12345");
        Thread.sleep(3000);
        driver.findElement(botaoContinuar).click();
        Thread.sleep(5000);
    }

    public void finalizarCompra() throws InterruptedException {
        driver.findElement(botaoFinalizar).click();
        Thread.sleep(3000);
    }

    public String obterMensagemSucesso() {
        return driver.findElement(mensagemSucesso).getText();
    }

    public String obterMensagemErro() {
        return driver.findElement(mensagemErro).getText();
    }

    public boolean resumoVisivelComDados() {
        return driver.findElement(precoTotal).isDisplayed()
                && driver.findElement(nomeProduto).isDisplayed();
    }
}