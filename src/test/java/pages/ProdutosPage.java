package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import util.DriverFactory;

import java.util.List;

public class ProdutosPage {

    private WebDriver driver = DriverFactory.getDriver();

    By campoUsuario = By.id("user-name");
    By campoSenha = By.id("password");
    By botaoLogin = By.id("login-button");
    By dropdownOrdenacao = By.className("product_sort_container");

    public void fazerLogin() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);
        driver.findElement(campoUsuario).sendKeys("standard_user");
        driver.findElement(campoSenha).sendKeys("secret_sauce");
        driver.findElement(botaoLogin).click();
        Thread.sleep(1000);
    }

    public int contarProdutos() {
        List<WebElement> produtos = driver.findElements(By.className("inventory_item"));
        return produtos.size();
    }

    public void ordenarPorMenorPreco() throws InterruptedException {
        Select select = new Select(driver.findElement(dropdownOrdenacao));
        select.selectByValue("lohi");
        Thread.sleep(1000);
    }

    public void ordenarDeAaZ() throws InterruptedException {
        Select select = new Select(driver.findElement(dropdownOrdenacao));
        select.selectByValue("az");
        Thread.sleep(1000);
    }

    public boolean primeiroProdutoEOMaisBarato() {
        List<WebElement> precos = driver.findElements(By.className("inventory_item_price"));
        double primeiroPreco = Double.parseDouble(precos.get(0).getText().replace("$", ""));
        double menorPreco = precos.stream()
                .mapToDouble(e -> Double.parseDouble(e.getText().replace("$", "")))
                .min()
                .orElse(Double.MAX_VALUE);
        return primeiroPreco == menorPreco;
    }

    public boolean produtosEstaoOrdenadosAaZ() {
        List<WebElement> nomes = driver.findElements(By.className("inventory_item_name"));
        for (int i = 0; i < nomes.size() - 1; i++) {
            String atual = nomes.get(i).getText().toLowerCase();
            String proximo = nomes.get(i + 1).getText().toLowerCase();
            if (atual.compareTo(proximo) > 0) return false;
        }
        return true;
    }

    public boolean todosProdutosTemNomePrecoEImagem() {
        List<WebElement> itens = driver.findElements(By.className("inventory_item"));
        for (WebElement item : itens) {
            if (item.findElements(By.className("inventory_item_name")).isEmpty()) return false;
            if (item.findElements(By.className("inventory_item_price")).isEmpty()) return false;
            if (item.findElements(By.tagName("img")).isEmpty()) return false;
        }
        return true;
    }
}
