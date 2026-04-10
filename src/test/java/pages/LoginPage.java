package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import util.DriverFactory;

import java.io.File;

public class LoginPage {

    // Elementos salvos em variáveis
    By campoUsuario = By.id("user-name");
    By campoSenha = By.id("password");
    By botaoLogin = By.id("login-button");

    By adicionarProduto = By.id("add-to-cart-sauce-labs-backpack");

    private By errorMessage = By.xpath("//h3[@data-test='error']");
    private By productsTitle = By.xpath("//span[@class='title']");

    WebDriver driver;

    public LoginPage() {
        driver = DriverFactory.getDriver();
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void realizarLogin() throws InterruptedException {

        driver.get("https://www.saucedemo.com");
        Thread.sleep(5000);
        System.out.println("Abriu site Sauce Demo");
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
        Thread.sleep(5000);
        driver.findElement(campoUsuario).sendKeys("standard_user");
        Thread.sleep(5000);
        driver.findElement(campoSenha).sendKeys("secret_sauce");
        Thread.sleep(5000);
        driver.findElement(botaoLogin).click();
        Thread.sleep(5000);

    }

    public void adicionarProduto() throws InterruptedException {
        driver.findElement(adicionarProduto).click();
        Thread.sleep(5000);
    }

    public void acessarSite() {
        driver.get("https://www.saucedemo.com/");
    }

    public void preencherUsuario(String user) {
        driver.findElement(campoUsuario).sendKeys(user);
    }

    public void preencherSenha(String pass) {
        driver.findElement(campoSenha).sendKeys(pass);
    }

    public void clicarLogin() {
        driver.findElement(botaoLogin).click();
    }

    public String obterMensagemErro() {
        return driver.findElement(errorMessage).getText();
    }

    public boolean estaNaPaginaProdutos() {
        return driver.findElement(productsTitle).isDisplayed();
    }

}
