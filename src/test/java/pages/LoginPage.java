package pages;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.DriverFactory;

public class LoginPage {

    By campoUsuario = By.id("user-name");
    By campoSenha = By.id("password");
    By botaoLogin = By.id("login-button");

    By adicionarProduto = By.id("add-to-cart-sauce-labs-backpack");
    By validarCarrinho = By.id("shopping_cart_container");
    By nomeProduto = By.className("inventory_item_name");
    By contadorCarrinho = By.className("shopping_cart_badge");
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
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(campoUsuario)).sendKeys("standard_user");
    driver.findElement(campoSenha).sendKeys("secret_sauce");
    driver.findElement(botaoLogin).click();
    wait.until(ExpectedConditions.urlContains("inventory.html"));
    }  

    public void adicionarProduto() throws InterruptedException {
    System.out.println("URL atual antes de adicionar: " + driver.getCurrentUrl()); // debug
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(adicionarProduto)).click();
    }

    public void validarCarrinho() throws InterruptedException {
        driver.findElement(validarCarrinho).click();
        Thread.sleep(1000);
    }

    public void realizarCheckout() throws InterruptedException {
        driver.findElement(realizarChekcout).click();
        Thread.sleep(1000);
    }

    public void botaoContinue() throws InterruptedException {
        driver.findElement(botaoContinue).click();
        Thread.sleep(1000);
    }

    private By mensagemErro = By.cssSelector("h3[data-test='error']");

    public void  obterTextoMensagemErro() {
        String texto = driver.findElement(mensagemErro).getText();
    }

    public void validarContadorCarrinho(int quantidadeEsperada) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement badge = wait.until(ExpectedConditions.visibilityOfElementLocated(contadorCarrinho));
    Assert.assertEquals(String.valueOf(quantidadeEsperada), badge.getText());
    }

    public void obterNomeProduto() {
        String nome = driver.findElement(nomeProduto).getText();
        System.out.println("Nome do produto: " + nome);
        Assert.assertEquals("Sauce Labs Backpack", nome);
    }

    public void inserirDadosCompras() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(firts_name).sendKeys("Joao Lucas");
        Thread.sleep(1000);
        driver.findElement(last_name).sendKeys("Gonzaga");
        Thread.sleep(1000);
        driver.findElement(postal_code).sendKeys("38414102");
        Thread.sleep(1000);

    }

    public void cliqueEmFinish() throws InterruptedException {
        driver.findElement(botaoFinish).click();
        Thread.sleep(1000);
    }
}
