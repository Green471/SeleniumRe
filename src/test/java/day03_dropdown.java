import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class day03_dropdown {
  static   WebDriver driver;
   @BeforeClass
    public static void setUp(){
       WebDriverManager.chromedriver().setup();
       driver= new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
   }

   @Test
    public void dropDown(){
       driver.get("https://www.amazon.com");

       WebElement dropDown= driver.findElement(By.cssSelector("#searchDropdownBox"));
       Select select= new Select(dropDown);
       select.getFirstSelectedOption();
       try {
           Thread.sleep(2000);
       } catch (InterruptedException e) {

       }
       select.selectByVisibleText("Baby");
       try {
           Thread.sleep(2000);
       } catch (InterruptedException e) {

       }
       select.selectByIndex(5);
       try {
           Thread.sleep(2000);
       } catch (InterruptedException e) {

       }
       List<WebElement> tümSecenekler=select.getOptions();

       for (WebElement w:tümSecenekler) {
           System.out.println(w.getText());

       }

       System.out.println("Size of Dropdown: "+tümSecenekler.size());


   }

}
