package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.DriverFactory;

public class CarrinhoPage {

    private WebDriver driver;

    private By campoUsuario = By.id("user-name");
    private By campoSenha = By.id("password");
    private By botaoLogin = By.id("login-button");
    private By botaoAdicionarProduto = By.id("add-to-cart-sauce-labs-backpack");
    private By botaoRemoverProduto = By.id("remove-sauce-labs-backpack");
    private By badgeCarrinho = By.className("shopping_cart_badge");
    private By iconeCarrinho = By.className("shopping_cart_link");
    private By nomeItemCarrinho = By.className("inventory_item_name");

    public CarrinhoPage() {
        driver = DriverFactory.getDriver();
    }

    public void fazerLogin() {
        driver.get("https://www.saucedemo.com");
        driver.findElement(campoUsuario).sendKeys("standard_user");
        driver.findElement(campoSenha).sendKeys("secret_sauce");
        driver.findElement(botaoLogin).click();
    }

    public void adicionarProduto() {
        driver.findElement(botaoAdicionarProduto).click();
    }

    public void removerProduto() {
        driver.findElement(botaoRemoverProduto).click();
    }

    public String obterContadorCarrinho() {
        return driver.findElement(badgeCarrinho).getText();
    }

    public void acessarCarrinho() {
        driver.findElement(iconeCarrinho).click();
    }

    public boolean carrinhoEstaVazio() {
        return driver.findElements(badgeCarrinho).size() == 0;
    }

    public boolean produtoEstaNoCarrinho() {
        return driver.findElements(nomeItemCarrinho).size() > 0;
    }
}
