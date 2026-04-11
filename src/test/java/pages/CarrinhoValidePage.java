package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class CarrinhoValidePage {

    private WebDriver driver;

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");
    private By cartButton = By.className("shopping_cart_link");
    private By cartItems = By.className("inventory_item_name");

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

    public void adicionarProduto(String nomeProduto) {
        String idBotao;

        switch (nomeProduto) {
            case "Sauce Labs Backpack":
                idBotao = "add-to-cart-sauce-labs-backpack";
                break;
            case "Sauce Labs Bike Light":
                idBotao = "add-to-cart-sauce-labs-bike-light";
                break;
            case "Sauce Labs Bolt T-Shirt":
                idBotao = "add-to-cart-sauce-labs-bolt-t-shirt";
                break;
            case "Sauce Labs Fleece Jacket":
                idBotao = "add-to-cart-sauce-labs-fleece-jacket";
                break;
            case "Sauce Labs Onesie":
                idBotao = "add-to-cart-sauce-labs-onesie";
                break;
            case "Test.allTheThings() T-Shirt (Red)":
                idBotao = "add-to-cart-test.allthethings()-t-shirt-(red)";
                break;
            default:
                throw new IllegalArgumentException("Produto não encontrado: " + nomeProduto);
        }

        driver.findElement(By.id(idBotao)).click();
    }

    public void acessarCarrinho() {
        driver.findElement(cartButton).click();
    }

    public void validarProdutoNoCarrinho(String nomeProdutoEsperado) {
        List<WebElement> produtos = driver.findElements(cartItems);
        boolean encontrado = false;

        for (WebElement produto : produtos) {
            if (produto.getText().equals(nomeProdutoEsperado)) {
                encontrado = true;
                break;
            }
        }

        Assert.assertTrue("Produto não encontrado no carrinho: " + nomeProdutoEsperado, encontrado);
    }

    public void fecharBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
