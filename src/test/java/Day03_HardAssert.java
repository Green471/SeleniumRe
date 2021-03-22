import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day03_HardAssert {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }

    @Ignore
    @Test
    public void test() {
        driver.get("http://www.amazon.com");
        String title = driver.getTitle();
        System.out.println(title);
        boolean iceriyorMu = title.contains("Araba");
        Assert.assertFalse(iceriyorMu);


    }

    @Test
    public void test2() {
        driver.get("http://www.amazon.com");
        String title1 = driver.getTitle();
        System.out.println(title1);
        // boolean varmi=title1.contains("Google");
        Assert.assertFalse(title1.contains("Google"));
    }

    @Test
    public void test3() {
        driver.get("http://www.amazon.com");
        String baslik1 = driver.getTitle();
        System.out.println("title: "+baslik1);
        Assert.assertEquals("Amazon.com", baslik1);


    }
    @Test
    public void softAssertTest(){
        driver.get("http://www.amazon.com");
        //softAssert icin softAssert class'indan nesne üretmek zorundayiz
        //test fail edrse bile calismya devam eder.
        //Assert denilince akla hardAssert gelir.
        //verify denilince akla softassert gelir


    }
}