import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class Day01_DriverKomutlari {

    @Test

    public void test1(){
        WebDriverManager.chromedriver().setup(); // Chrome Driver'i Kurduk
        WebDriver driver= new ChromeDriver(); //
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.google.com");


        driver.navigate().to("https://www.amazon.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.quit();//acik olan tüm sekmeleri kapatir: driver'i kapatir.
      //  driver.close();  acik olan sekmeyi kapatir.
    }
}
