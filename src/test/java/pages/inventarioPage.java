package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.DriverFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class inventarioPage {
    private final By botaoAZ = By.cssSelector("option[value='az']");
    private final By botaoFiltragem = By.cssSelector(".product_sort_container");
    private final By nomesProdutos = By.cssSelector(".inventory_item_name");
    private final WebDriver driver;
    private final By listaProdutos = By.cssSelector(".inventory_list");
    private final By botaoAdicionarCarrinho = By.cssSelector(".inventory_item .btn_inventory");
    private final By badgeCarrinho = By.cssSelector(".shopping_cart_badge");

    public inventarioPage() {
        driver = DriverFactory.getDriver();
    }

    public boolean isPaginaInventarioCarregada() {
        return driver.findElement(listaProdutos).isDisplayed();
    }

    public void clicarAdicionarAoCarrinho() {
        driver.findElements(botaoAdicionarCarrinho).get(0).click();
    }

    public boolean isProdutoAdicionadoAoCarrinho() {
        return driver.findElement(badgeCarrinho).isDisplayed();
    }

    public void clicarBotaoFiltragem() {
        driver.findElement(botaoFiltragem).click();
    }

    public void clicarBotaoAZ() {
        driver.findElement(botaoAZ).click();
    }

    public void selecionarOpcaoNomeAZ() {
        clicarBotaoFiltragem();
        clicarBotaoAZ();
    }

    public boolean isProdutosEmOrdemAlfabeticaCrescente() {
        List<WebElement> elementos = driver.findElements(nomesProdutos);
        List<String> nomes = new ArrayList<>();

        for (WebElement elemento : elementos) {
            nomes.add(elemento.getText().trim().toLowerCase());
        }

        List<String> nomesOrdenados = new ArrayList<>(nomes);
        Collections.sort(nomesOrdenados);

        return nomes.equals(nomesOrdenados);
    }
}
