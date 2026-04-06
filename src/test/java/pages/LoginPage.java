import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class standard_user {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void acessarSite() {
        driver.get("https://www.saucedemo.com/");
    }

    public void preencherUsuario(String usuario) {
        driver.findElement(By.id("user-name")).sendKeys(usuario);
    }

    public void preencherSenha(String senha) {
        driver.findElement(By.id("password")).sendKeys(senha);
    }

    public void clicarLogin() {
        driver.findElement(By.id("login-button")).click();
    }
}
package pages;

