import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    By searchBoxLocator = By.cssSelector("input[data-cy='header-search-input']");
    By searchButton = By.cssSelector("button[data-cy='search-find-button']");

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void search(String text) {
        type(searchBoxLocator, text);
        click(searchButton);
    }

    private String getHomePageTitle(){
        return driver.getTitle();
    }
}
