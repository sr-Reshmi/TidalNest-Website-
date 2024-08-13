import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void f() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\reshm\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		 driver.get("https://www.amazon.in/");
		 Thread.sleep(10000);
		 driver.findElement(By.id("twotabsearchtextbox")).sendKeys("perfume");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.linkText("Park Avenue Men Voyage Amazon Woods Liquid Perfume, 120Ml")).click();
		 Thread.sleep(2000);
		 String mainWindow = driver.getWindowHandle();
		 Set<String>s1 =driver.getWindowHandles();
		 Iterator<String>i1=s1.iterator();
		 while(i1.hasNext()){
			 String childWindow = i1.next();
			 if(! mainWindow.equalsIgnoreCase(childWindow)){
				 driver.switchTo().window(childWindow);
				// driver.switchTo().window(mainWindow);
				// Thread.sleep(2000);
				 //driver.findElement(By.linkText("SKINN BY TITAN Raw Perfume for Men, 50ml")).click();
				// Thread.sleep(2000);
			 }
			 
		 }
		 
		 driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).sendKeys(Keys.ENTER);
		 Thread.sleep(2000);
			 //driver.quit();
			 
		 
		 
		 
		 
	  
	  
	  
	  
  }
}
