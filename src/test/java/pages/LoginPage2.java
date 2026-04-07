package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.DriverFactory;

public class LoginPage2 {

    WebDriver driver;
    By campoUsuario = By.id("user-name");
    By campoSenha = By.id("password");
    By botaoLogin = By.id("login-button");
    By mensagemErro = By.cssSelector("[data-test='error']");

    public LoginPage2() {
        driver = DriverFactory.getDriver();
    }

    public void abrirSite() throws InterruptedException {
        driver.get("https://www.saucedemo.com");
        Thread.sleep(2000);
    }

    public void inserirCredenciais(String usuario, String senha) throws InterruptedException {
        driver.findElement(campoUsuario).sendKeys(usuario);
        driver.findElement(campoSenha).sendKeys(senha);
        driver.findElement(botaoLogin).click();
        Thread.sleep(2000);
    }

    public void clicarLoginSemPreencher() throws InterruptedException {
        driver.findElement(botaoLogin).click();
        Thread.sleep(2000);
    }

    public String obterUrlAtual() {
        return driver.getCurrentUrl();
    }

    public String obterMensagemErro() {
        return driver.findElement(mensagemErro).getText();
    }
}