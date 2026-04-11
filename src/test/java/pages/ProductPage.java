package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import util.DriverFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ProductPage {

    WebDriver driver;

    private By productsTitle = By.xpath("//span[@class='title']");
    private By productItems = By.className("inventory_item");
    private By sortContainer = By.className("product_sort_container");
    private By productName = By.className("inventory_item_name");
    private By productPrice = By.className("inventory_item_price");
    private By productImage = By.cssSelector(".inventory_item_img img");

    public ProductPage() {
        this.driver = DriverFactory.getDriver();
    }

    public boolean estaNaPaginaProdutos() {
        return driver.findElement(productsTitle).isDisplayed();
    }

    public int contarProdutosVisiveis() {
        return driver.findElements(productItems).size();
    }

    public void ordenarPorPrecoMenorMaior() {
        Select select = new Select(driver.findElement(sortContainer));
        select.selectByValue("lohi");
    }

    public void ordenarPorNomeAtoZ() {
        Select select = new Select(driver.findElement(sortContainer));
        select.selectByValue("az");
    }

    public List<Double> obterPrecosExibidos() {
        return driver.findElements(productPrice)
                .stream()
                .map(element -> Double.parseDouble(element.getText().replace("$", "")))
                .collect(Collectors.toList());
    }

    public List<String> obterNomesExibidos() {
        return driver.findElements(productName)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public boolean todosProdutosTemImagemNomePreco() {
        List<WebElement> items = driver.findElements(productItems);

        return items.stream().allMatch(item -> {
            String nome = item.findElement(productName).getText();
            String preco = item.findElement(productPrice).getText();
            boolean imagemVisivel = item.findElement(productImage).isDisplayed();
            return !nome.isEmpty() && !preco.isEmpty() && imagemVisivel;
        });
    }
}
