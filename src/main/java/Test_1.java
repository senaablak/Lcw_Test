import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_1 {
    private WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\selenıum projesi\\chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void goToHomePage() {
        driver.get("https://www.lcwaikiki.com/tr-TR/TR");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe("https://www.lcwaikiki.com/tr-TR/TR"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.lcwaikiki.com/tr-TR/TR");
    }

    @Test(priority = 2)
    public void goToCategoryPage() {
        WebElement categoryLink = driver.findElement(By.xpath("//a[@href='https://www.lcwaikiki.com/tr-TR/TR/lp/32-33-kadin']"));
        categoryLink.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe("https://www.lcwaikiki.com/tr-TR/TR/lp/32-33-kadin"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article[@class='section5l flexcontainer']//img[@alt='SWEATSHIRT VE EŞOFMAN']")));
        WebElement categorypage = driver.findElement(By.xpath("//article[@class='section5l flexcontainer']//img[@alt='SWEATSHIRT VE EŞOFMAN']"));
        categorypage.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.lcwaikiki.com/tr-TR/TR/etiket/kadin-sweatshirt-esofmanalti");

    }

    @Test(priority = 3)
    public void goToProductPage() {

        WebElement productLink = driver.findElement(By.xpath("//img[@src='https://img-lcwaikiki.mncdn.com/mnresize/600/800/pim/productimages/20232/6674752/v1/l_20232-w3cp90z8-lgs-78-61-89-180_a.jpg']"));
        productLink.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='size-pop-up hidden-mobile']//a[.='S']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='pd_add_to_cart']")));

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.lcwaikiki.com/tr-TR/TR/urun/LC-WAIKIKI/kadin/Sweatshirt/6674752/3304532");

    }

    @Test(priority = 4)
    public void addToCart() {
        WebElement selectSize = driver.findElement(By.xpath("//div[@class='size-pop-up hidden-mobile']//a[.='S']"));
        selectSize.click();
        try {
            WebElement closeCookiePopup = driver.findElement(By.xpath("//*[@id=\"cookieseal-banner\"]/div/button[2]"));
            closeCookiePopup.click();
        } catch (Exception e) {
        }
        WebElement addToCartButton = driver.findElement(By.xpath("//a[@id='pd_add_to_cart']"));
        addToCartButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Sepetim']")));

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.lcwaikiki.com/tr-TR/TR/urun/LC-WAIKIKI/kadin/Sweatshirt/6674752/3304532");
    }

    @Test(priority = 5)
    public void goToCartPage() {
         WebElement cartLink = driver.findElement(By.xpath("//span[.='Sepetim']"));
         cartLink.click();
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.urlToBe("https://www.lcwaikiki.com/tr-TR/TR/sepetim"));

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.lcwaikiki.com/tr-TR/TR/sepetim");
    }



    @Test(priority = 6)
    public void goToHomePageAgain() {
        WebElement homeLink = driver.findElement(By.cssSelector("[version='1.0']"));
        homeLink.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe("https://www.lcwaikiki.com/tr-TR/TR"));

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.lcwaikiki.com/tr-TR/TR");
    }

   @AfterTest
    public void tearDown() {
      if (driver != null) {
          driver.quit();
        }
    }
}