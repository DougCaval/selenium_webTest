package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ValideCarrinhoPage {

    private WebDriver driver;

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");
    private By addBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private By cartBadge = By.className("shopping_cart_badge");

    public void abrirBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void acessarSite() {
        driver.get("https://www.saucedemo.com/");
    }

    public void login(String usuario, String senha) {
        driver.findElement(username).sendKeys(usuario);
        driver.findElement(password).sendKeys(senha);
        driver.findElement(loginButton).click();
    }

    public void adicionarProdutoAoCarrinho() {
        driver.findElement(addBackpack).click();
    }

    public void validarContadorCarrinho(String valorEsperado) {
        WebElement badge = driver.findElement(cartBadge);
        String valorAtual = badge.getText();
        Assert.assertEquals("O contador do carrinho está incorreto.", valorEsperado, valorAtual);
    }

    public void fecharBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}