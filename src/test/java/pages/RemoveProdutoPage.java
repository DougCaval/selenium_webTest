// src/test/java/pages/RemoveProdutoPage.java

package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class RemoveProdutoPage {

    private WebDriver driver;

    private By campoUsername = By.id("user-name");
    private By campoPassword = By.id("password");
    private By botaoLogin = By.id("login-button");

    private By botaoAddBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private By iconeCarrinho = By.className("shopping_cart_link");
    private By botaoRemoveBackpack = By.id("remove-sauce-labs-backpack");
    private By itemNoCarrinho = By.className("cart_item");
    private By badgeCarrinho = By.className("shopping_cart_badge");

    public void abrirNavegador() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void acessarSauceDemo() {
        driver.get("https://www.saucedemo.com/");
    }

    public void fazerLogin(String usuario, String senha) {
        driver.findElement(campoUsername).sendKeys(usuario);
        driver.findElement(campoPassword).sendKeys(senha);
        driver.findElement(botaoLogin).click();
    }

    public void adicionarProdutoAoCarrinho(String produto) {
        if (produto.equals("Sauce Labs Backpack")) {
            driver.findElement(botaoAddBackpack).click();
        }
    }

    public void acessarCarrinho() {
        driver.findElement(iconeCarrinho).click();
    }

    public void removerProdutoDoCarrinho() {
        driver.findElement(botaoRemoveBackpack).click();
    }

    public void validarCarrinhoVazio() {
        boolean produtoExiste = driver.findElements(itemNoCarrinho).size() > 0;
        boolean badgeExiste = driver.findElements(badgeCarrinho).size() > 0;

        Assert.assertFalse("Ainda existe produto no carrinho.", produtoExiste);
        Assert.assertFalse("O badge do carrinho ainda está visível.", badgeExiste);
    }

    public void fecharNavegador() {
        if (driver != null) {
            driver.quit();
        }
    }
}
