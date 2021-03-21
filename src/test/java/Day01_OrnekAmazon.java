import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day01_OrnekAmazon {

    /*
    1- amazon'a git
    2-arama kutusuna "baby stroller" yaz
    3-ikinci ürüne tikla
    4-ürün toplam fiyatini alin
    5-ürün ortalama puanini alin
     */




    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("baby stroller");
        searchBox.submit();

        WebElement ikinciSiradakiÜrün= driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]"));
        ikinciSiradakiÜrün.click();

        WebElement ürünFiyati = driver.findElement(By.id("priceblock_saleprice_row"));
        String price=ürünFiyati.getText();
        System.out.println(price);

    }

    @Test
    public void test2(){
        /*
        1-google.com'a gecis yapalim.
        2-arama bölümüne "kemal özden" yazalim
        3-ekrana cikan sonucu yazdirin consola.
        */
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com");
        WebElement stimmeZuButton= driver.findElement(By.xpath("(//span[@class='RveJvd snByac'])[3]"));
        stimmeZuButton.submit();
        WebElement googleSearch= driver.findElement(By.id("q"));
        googleSearch.sendKeys("kemal özden");
        googleSearch.submit();


    }
}
