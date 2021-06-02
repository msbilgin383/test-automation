import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class TestSetting extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
    Products products;
    ProductDetail productDetail;
    Cart cart;
    String baseUrl = "https://www.gittigidiyor.com/";


    @Test
    @Order(1)
    public void login() throws InterruptedException {
        loginPage = new LoginPage(driver);
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl);
        Log4j.info("Connected home page");
        Thread.sleep(2000);
        loginPage.login();
        Log4j.info("Directed login page");
    }

    @Test
    @Order(2)
    public void searchProduct(){
        homePage = new HomePage(driver);
        homePage.search("Bilgisayar");
        products = new Products(driver);
        products.goNextPage();
        Assert.assertEquals(products.isSecondPage(), true);
        Log4j.info("On the second page");
    }

    @Test
    @Order(3)
    public void selectProduct(){
        products.selectProduct();
    }

    @Test
    @Order(4)
    public void addProductToCart() throws InterruptedException {
        productDetail = new ProductDetail(driver);
        productDetail.addProductToCart();
        productDetail.goToBasket();
    }

    @Test
    @Order(5)
    public void checkPrice(){
        cart = new Cart(driver);
        Assert.assertEquals(productDetail.price(), cart.basketPrice);
        Log4j.info("Prices are equal.");
    }

    @Test
    @Order(6)
    public void increaseAmount() throws InterruptedException {
        cart.countUp();
        Thread.sleep(2000);
        Assert.assertEquals(cart.isCountedUp(), "Ürün Toplamı (2 Adet)");
        Log4j.info("Amount of product succesfully increased");
    }

    @Test
    @Order(7)
    public void deleteProductFromCart() throws InterruptedException {
        cart.deleteProductFromCart();
        Log4j.info("Succesfully deleted from cart.");
        Thread.sleep(2000);
    }

    @Test
    @Order(8)
    public void isEmpty(){
        Assert.assertEquals(cart.isEmpty(), "Ürün Toplamı (0 Adet)");
        Log4j.info("Empty cart.");
    }


}
