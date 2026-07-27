package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import util.DriverFactory;
import org.junit.Assert;

import java.io.File;

public class LoginPage {

    // Elementos salvos em variáveis
    By campoUsuario = By.id("user-name");
    By campoSenha = By.id("password");
    By botaoLogin = By.id("login-button");

    By adicionarProduto = By.id("add-to-cart-sauce-labs-backpack");
    By validarCarrinho = By.id("shopping_cart_container");
    By tituloPaginaOverview = By.className("title");
    By realizarCheckout = By.id("checkout");
    By botaoContinue = By.id("continue");
    By campoFirstName = By.id("first-name");
    By campoLastName = By.id("last-name");
    By campoPostalCode = By.id("postal-code");
    By botaoFinish = By.id("finish");
    By botaoCancel = By.id("cancel");


    WebDriver driver;

    public LoginPage() {

        driver = DriverFactory.getDriver();
    }


    public void realizarLogin() throws InterruptedException {

        driver.get("https://www.saucedemo.com");
        Thread.sleep(3000);
    }


    public static void tirarScreenshot(WebDriver driver, String nome) {

        try {

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            File destino = new File("test/screenshots/" + nome + ".png");

            FileUtils.copyFile(src, destino);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void inserirDados() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(campoUsuario).sendKeys("standard_user");
        Thread.sleep(1000);
        driver.findElement(campoSenha).sendKeys("secret_sauce");
        Thread.sleep(1000);
        driver.findElement(botaoLogin).click();
        Thread.sleep(2000);

    }

    public void adicionarProduto() throws InterruptedException {
        driver.findElement(adicionarProduto).click();
        Thread.sleep(2000);

    }

    public void validarCarrinho() throws InterruptedException {
        driver.findElement(validarCarrinho).click();
        Thread.sleep(2000);
    }

    public void realizarCheckout() throws InterruptedException {
        driver.findElement(realizarCheckout).click();
        Thread.sleep(2000);
    }

    public void botaoContinue() throws InterruptedException {
        driver.findElement(botaoContinue).click();
        Thread.sleep(2000);
    }

    private By mensagemErro = By.cssSelector("h3[data-test='error']"); 

    public String obterTextoMensagemErro() {
        return driver.findElement(mensagemErro).getText();
    }

    public void preencherDadosCheckout() throws InterruptedException {
        driver.findElement(campoFirstName).sendKeys("Alexandre");
        Thread.sleep(1000);
        driver.findElement(campoLastName).sendKeys("Martins");
        Thread.sleep(1000);
        driver.findElement(campoPostalCode).sendKeys("38405112");
        Thread.sleep(2000);
    }

    public void cliqueEmFinish() throws InterruptedException {
        driver.findElement(botaoFinish).click();
        Thread.sleep(2000);
    }

    public void lerEValidarOverview() {
        String titulo = driver.findElement(tituloPaginaOverview).getText();
        System.out.println("Título: " + titulo);
        Assert.assertEquals("Checkout: Overview", titulo);
    }

    public void lerEValidarCarrinho() {
        String titulo = driver.findElement(tituloPaginaOverview).getText();
        System.out.println("Título: " + titulo);
        Assert.assertEquals("Your Cart", titulo);
    }

    public void clicarBotaoCancel() {
        driver.findElement(botaoCancel).click();
    }
}
