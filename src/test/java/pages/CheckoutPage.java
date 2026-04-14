package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private WebDriver driver;

    private By campoUsuario = By.id("user-name");
    private By campoSenha = By.id("password");
    private By botaoLogin = By.id("login-button");

    private By adicionarProduto = By.id("add-to-cart-sauce-labs-backpack");
    private By iconeCarrinho = By.className("shopping_cart_link");
    private By botaoCheckout = By.id("checkout");

    private By campoNome = By.id("first-name");
    private By campoSobrenome = By.id("last-name");
    private By campoCep = By.id("postal-code");
    private By botaoContinuar = By.id("continue");

    private By botaoFinalizar = By.id("finish");
    private By tituloPagina = By.className("title");
    private By mensagemErro = By.cssSelector("[data-test='error']");
    private By mensagemSucesso = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    private void pausaCurta() {
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void acessarEtapaCheckout() {
        driver.get("https://www.saucedemo.com/");
        pausaCurta();
        driver.findElement(campoUsuario).sendKeys("standard_user");
        pausaCurta();
        driver.findElement(campoSenha).sendKeys("secret_sauce");
        pausaCurta();
        driver.findElement(botaoLogin).click();
        pausaCurta();

        driver.findElement(adicionarProduto).click();
        pausaCurta();
        driver.findElement(iconeCarrinho).click();
        pausaCurta();
        driver.findElement(botaoCheckout).click();
        pausaCurta();
    }

    public void preencherDados(String nome, String sobrenome, String cep) {
        driver.findElement(campoNome).clear();
        driver.findElement(campoNome).sendKeys(nome);
        pausaCurta();

        driver.findElement(campoSobrenome).clear();
        driver.findElement(campoSobrenome).sendKeys(sobrenome);
        pausaCurta();

        driver.findElement(campoCep).clear();
        driver.findElement(campoCep).sendKeys(cep);
        pausaCurta();
    }

    public void clicarContinuar() {
        driver.findElement(botaoContinuar).click();
        pausaCurta();
    }

    public void clicarFinalizar() {
        driver.findElement(botaoFinalizar).click();
        pausaCurta();
    }

    public String obterTituloPagina() {
        return driver.findElement(tituloPagina).getText();
    }

    public String obterMensagemErro() {
        return driver.findElement(mensagemErro).getText();
    }

    public String obterMensagemSucesso() {
        return driver.findElement(mensagemSucesso).getText();
    }
}
