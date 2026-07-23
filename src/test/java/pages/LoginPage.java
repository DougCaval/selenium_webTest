package pages;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.Assert;
import org.openqa.selenium.*;

import util.DriverFactory;

import java.io.File;
import java.time.Duration;

public class LoginPage {

    // Elementos salvos em variáveis
    By campoUsuario = By.id("user-name");
    By campoSenha = By.id("password");
    By botaoLogin = By.id("login-button");
    By botaoMenu = By.id("react-burger-menu-btn");
    By botaoLogout = By.id("logout_sidebar_link");
    By adicionarProduto = By.id("add-to-cart-sauce-labs-backpack");
    By validarCarrinho = By.id("shopping_cart_container");
    By realizarChekcout = By.id("checkout");
    By botaoContinue = By.id("continue");
    By firts_name = By.id("first-name");
    By last_name = By.id("last-name");
    By postal_code = By.id("postal-code");
    By botaoFinish = By.id("finish");


    WebDriver driver;

    public LoginPage() {

        driver = DriverFactory.getDriver();
    }


    public void realizarLogin() throws InterruptedException {

        driver.get("https://www.saucedemo.com");
        Thread.sleep(5000);
        System.out.println("Abriu site Sauce Demo");
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
        Thread.sleep(5000);
        driver.findElement(campoUsuario).sendKeys("standard_user");
        Thread.sleep(5000);
        driver.findElement(campoSenha).sendKeys("secret_sauce");
        Thread.sleep(5000);
        driver.findElement(botaoLogin).click();
        Thread.sleep(5000);

    }

    public void adicionarProduto() throws InterruptedException {
        driver.findElement(adicionarProduto).click();
        Thread.sleep(5000);

    }
    public void acessarTelaLogin() {
        driver.get("https://www.saucedemo.com");
    }
    public void inserirCredenciais(String usuario, String senha) {
        driver.findElement(campoUsuario).sendKeys(usuario);
        driver.findElement(campoSenha).sendKeys(senha);
    }
    public void clicarBotao(String botao) {
        switch (botao) {
            case "botaoLogin":
                driver.findElement(botaoLogin).click();
                break;
            case "botaoLogout":
                driver.findElement(botaoMenu).click();
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.elementToBeClickable(botaoLogout)).click();
                break;
            default:
                throw new IllegalArgumentException("Botão desconhecido: " + botao);
        }
    }

    public void validarAuth() {
        String urlAtual = driver.getCurrentUrl();
        if (urlAtual.equals("https://www.saucedemo.com/inventory.html")) {
            System.out.println("Login bem-sucedido!");
        } else {
            System.out.println("Falha no login.");
        }
    }
    public void validarlogout() {
        String urlAtual = driver.getCurrentUrl();
        if (urlAtual.equals("https://www.saucedemo.com/")) {
            System.out.println("Logout bem-sucedido!");
        } else {
            System.out.println("Falha no logout.");
        }
    }
    public void validarMensagem(String mensagemEsperada) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String mensagemExibida = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3[data-test='error']")))
                .getText();
        if (mensagemExibida.equals(mensagemEsperada) || mensagemExibida.endsWith(mensagemEsperada)) {
            System.out.println("Mensagem exibida corretamente: " + mensagemExibida);
        } else {
            System.out.println("Mensagem incorreta. Esperada: " + mensagemEsperada + ", Exibida: " + mensagemExibida);
        }
    }

    public void validarCarrinho() throws InterruptedException {
        driver.findElement(validarCarrinho).click();
        Thread.sleep(5000);
    }

    public void realizarCheckout() throws InterruptedException {
        driver.findElement(realizarChekcout).click();
        Thread.sleep(5000);
    }

    public void botaoContinue() throws InterruptedException {
        driver.findElement(botaoContinue).click();
        Thread.sleep(5000);
    }

    private By mensagemErro = By.cssSelector("h3[data-test='error']");

    public String obterTextoMensagemErro() {
        return driver.findElement(mensagemErro).getText();

    }

    public void inserirDadosCompras() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(firts_name).sendKeys("Joao Lucas");
        Thread.sleep(5000);
        driver.findElement(last_name).sendKeys("Gonzaga");
        Thread.sleep(5000);
        driver.findElement(postal_code).sendKeys("38414102");
        Thread.sleep(5000);

    }

    public void cliqueEmFinish() throws InterruptedException {
        driver.findElement(botaoFinish).click();
        Thread.sleep(5000);
    }
}

