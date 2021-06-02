import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    By loginOrRegisterButton = By.cssSelector("div[data-cy='header-user-menu']");
    By loginButton = By.cssSelector("a[data-cy='header-login-button']");
    By userName = By.id("L-UserNameField");
    By password = By.id("L-PasswordField");

    //Login simulation with fake variables.

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login() throws InterruptedException {
        click(loginOrRegisterButton);
        Thread.sleep(2000);
        click(loginButton);
        Thread.sleep(2000);
        type(userName, "username");
        Thread.sleep(2000);
        type(password, "password");
        Thread.sleep(2000);
        driver.get("https://gittigidiyor.com");
    }
}
