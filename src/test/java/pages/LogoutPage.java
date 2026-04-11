package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.DriverFactory;

public class LogoutPage {

    private WebDriver driver = DriverFactory.getDriver();

    By campoUsuario = By.id("user-name");
    By campoSenha   = By.id("password");
    By botaoLogin   = By.id("login-button");
    By menuBurguer  = By.id("react-burger-menu-btn");
    By botaoLogout  = By.id("logout_sidebar_link");

    public void fazerLogin() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);
        driver.findElement(campoUsuario).sendKeys("standard_user");
        driver.findElement(campoSenha).sendKeys("secret_sauce");
        driver.findElement(botaoLogin).click();
        Thread.sleep(1000);
    }

    public void realizarLogout() throws InterruptedException {
        driver.findElement(menuBurguer).click();
        Thread.sleep(1500);
        driver.findElement(botaoLogout).click();
        Thread.sleep(1000);
    }

    public String obterUrlAtual() {
        return driver.getCurrentUrl();
    }
}