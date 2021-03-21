import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day02_Xpath {
   static WebDriver driver;
   //Junit 4.13 ile birlikte @BeforeClass ve @AfterClass "static" olmak zorunda.
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        //driver nesnesi olusturduk
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void test1(){

        driver.get("http://a.testaddressbook.com");
       WebElement signInLinki= driver.findElement(By.cssSelector("#sign-in"));
       signInLinki.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
        List<WebElement> allLink= driver.findElements(By.tagName("a")); // By.xpath("//a")

        for (WebElement w:allLink) {
            System.out.println(w.getText());

        }

        WebElement eMail=driver.findElement(By.cssSelector("#session_email"));
        eMail.sendKeys("testtechproed@gmail.com");
        WebElement pass=driver.findElement(By.cssSelector("#session_password"));
        pass.sendKeys("Test1234!");
        WebElement sign = driver.findElement(By.cssSelector(".btn.btn-primary"));
        sign.click();

        List<WebElement> allText= driver.findElements(By.xpath("//body[.]"));
        for (WebElement w:allText) {
            System.out.println(w.getText());

        }



    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

}
