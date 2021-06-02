import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Products extends BasePage {

    By secondPage=By.className("next-link");
    By currentPage = By.className("current");
    By productSelector = By.id("product_id_690424111");

    public Products(WebDriver driver) {
        super(driver);
    }

    public void goNextPage(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 250)");
        click(secondPage);
    }

    public void selectProduct() {
        click(productSelector);
    }

    public boolean isSecondPage() {
        if(find(currentPage).getText().equals("2"))
            return true;
        return false;
    }

}
