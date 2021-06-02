import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetail extends BasePage {
    By addToCart = By.id("add-to-basket");
    String productPrice= find(By.id("sp-price-discountPrice")).getText();
    By goToBasketButton= By.className("robot-header-iconContainer-cart");

    public ProductDetail(WebDriver driver) {
        super(driver);
    }

    public void addProductToCart() throws InterruptedException {
        By winnersClub = By.className("wis-clsbtn-98395"); //For winners club notification. You can disable if it is not necessary.
        click(winnersClub);                                //For winners club notification.You can disable if it is not necessary.
        By cookie = By.className("policy-alert-v2-buttons"); //Closing the cookies. You can disable if it is not necessary.
        Thread.sleep(3000);
        click(cookie);                                      //You can disable if it is not necessary.
        Thread.sleep(3000);
        click(addToCart);
        Thread.sleep(3000);
    }

    public void goToBasket(){
        click(goToBasketButton);
    }

    public String price(){
        return productPrice;
    }


}
