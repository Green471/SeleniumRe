import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class day03Ornek {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }
    @Test
    public void amazonDropDownTest(){
        driver.get("https://www.amazon.com");

        WebElement dropDown= driver.findElement(By.cssSelector("#searchDropdownBox"));
        Select select= new Select(dropDown);
        select.selectByVisibleText("Books");
        WebElement searchBox=driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        searchBox.sendKeys("Java"+ Keys.ENTER);

        WebElement firstProduct=driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
        firstProduct.click();
        WebElement backToResult= driver.findElement(By.cssSelector("#breadcrumb-back-link"));
        boolean isDisplayed=backToResult.isDisplayed();
        System.out.println("is displayed:"+isDisplayed);
        Assert.assertTrue(isDisplayed);




    }
}
