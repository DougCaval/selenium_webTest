package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By addBackpack    = By.id("add-to-cart-sauce-labs-backpack");
    private By removeBackpack = By.id("remove-sauce-labs-backpack");
    private By cartBadge      = By.className("shopping_cart_badge");
    private By cartIcon       = By.className("shopping_cart_link");
    private By cartItemName   = By.className("inventory_item_name");

    public void adicionarProduto() {
        driver.findElement(addBackpack).click();
    }

    public void removerProduto() {
        driver.findElement(removeBackpack).click();
    }

    public boolean badgeEstaVisivelComValor(String valor) {
        return driver.findElement(cartBadge).getText().equals(valor);
    }

    public boolean badgeNaoEstaVisivel() {
        return driver.findElements(cartBadge).isEmpty();
    }

    public void acessarCarrinho() {
        driver.findElement(cartIcon).click();
    }

    public boolean produtoEstaNoCarrinho(String nomeProduto) {
        return driver.findElements(cartItemName).stream()
                .anyMatch(el -> el.getText().equals(nomeProduto));
    }
}