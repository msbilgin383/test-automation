import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Cart extends BasePage{

    By deleteProduct = By.cssSelector("a[title='Sil']");
    String basketPrice = find(By.className("new-price")).getText();


    public Cart(WebDriver driver) {
        super(driver);
    }

    public void deleteProductFromCart() {
        click(deleteProduct);
    }

    public void countUp() throws InterruptedException {

        Select amount = new Select(driver.findElement(By.xpath("//select[@data-id]")));
        amount.selectByVisibleText("2");
        Thread.sleep(3000);
    }

    public String isCountedUp(){
        String amountOfProduct = driver.findElement(By.cssSelector("div[class='gg-d-16 detail-text']")).getText();
        return amountOfProduct;
    }

    public String isEmpty(){
        return driver.findElement(By.cssSelector("div[class='gg-d-16 detail-text']")).getText();
    }
}
