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
        WebElement categoryLink = driver.findElement(By.xpath("//a[.='Outlet']"));
        categoryLink.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe("https://www.lcwaikiki.com/tr-TR/TR/katalog/outlet"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-list']")));

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.lcwaikiki.com/tr-TR/TR/katalog/outlet");

    }

    @Test(priority = 3)
    public void goToProductPage() {
        WebElement productLink = driver.findElement(By.xpath("//img[@src='https://img-lcwaikiki.mncdn.com/mnresize/600/800/pim/productimages/20212/5640361/l_20212-w1ks05z8-hkl_a.jpg']"));
        productLink.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='size-pop-up hidden-mobile']//a[.='XL']")));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='pd_add_to_cart']")));

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.lcwaikiki.com/tr-TR/TR/urun/outlet/Markalar/kadin/Tayt/5640361/2261621");

    }

    @Test(priority = 4)
    public void addToCart() {
        WebElement selectSize = driver.findElement(By.xpath("//div[@class='size-pop-up hidden-mobile']//a[.='S']"));
        selectSize.click();
        WebElement addToCartButton = driver.findElement(By.cssSelector("#pd_add_to_cart"));
        addToCartButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe("https://www.lcwaikiki.com/tr-TR/TR/urun/outlet/Markalar/kadin/Tayt/5640361/2261621"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Sepetim']")));

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.lcwaikiki.com/tr-TR/TR/urun/outlet/Markalar/kadin/Tayt/5640361/2261621");
    }

    @Test(priority = 5)
    public void goToCartPage() {
         WebElement cartLink = driver.findElement(By.xpath("//span[.='Sepetim']"));
         cartLink.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
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