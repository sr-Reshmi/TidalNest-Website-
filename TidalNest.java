import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;


import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class TidalNest {
	WebDriver driver;
	
	
	@Test
  public void A_tidalnest_header() throws InterruptedException {
	driver.findElement(By.xpath("/html/body/header/div[1]/div/div[1]/ul/li[1]/a")).click() ;
	Thread.sleep(1000);
	driver.findElement(By.xpath("/html/body/header/div[1]/div/div[1]/ul/li[2]/a")).click() ;
	Thread.sleep(1000);
	driver.findElement(By.xpath("/html/body/header/div[1]/div/div[2]/ul/li/ul/li[1]/a/i")).click() ;
	Thread.sleep(1000);
	driver.findElement(By.xpath("/html/body/header/div[1]/div/div[2]/ul/li/ul/li[2]/a/i+")).click() ;
	Thread.sleep(1000);
	
	}
	
	
	
	
  @Test
  public void A_Homepage() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"responsive-menu\"]/li[1]/a")).click() ;
	Thread.sleep(1000);
	driver.findElement(By.xpath("/html/body/section[1]/div/div[1]/div[1]/div[4]/div/a")).click() ;
	driver.navigate().back();
	driver.findElement(By.xpath("/html/body/section[2]/div/div[2]/div/div[1]/div/a")).click() ;
	driver.navigate().back();
	driver.findElement(By.xpath("/html/body/section[3]/div/div/div[1]/div/a")).click() ;
	driver.navigate().back();
    Thread.sleep(2000);
    driver.findElement(By.xpath("/html/body/section[5]/div/div[2]/div/div[1]/div/div/button/i")).click() ;
    Thread.sleep(1000);
    driver.findElement(By.xpath("//button[@aria-label='Close the modal by clicking here']")).click() ;
  }

	
  @Test
  public void B_About() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"responsive-menu\"]/li[2]/a")).click();
	Thread.sleep(1000);
	
  }	

  
  @Test
  public void C_Rooms() throws InterruptedException {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

      driver.findElement(By.xpath("//*[@id=\"responsive-menu\"]/li[3]/a")).click();
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section[2]/div/div/div/div[1]/div/div[2]/div[3]/a"))).click();
      
      List<WebElement> checkboxes = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@type='checkbox']")));
      for (WebElement checkbox : checkboxes) {
          if (!checkbox.isSelected()) {
              try {
                  // Attempt to click using standard method
                  checkbox.click();
              } catch (Exception e) {
                  // Fallback to JavaScript click if standard click fails
                  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
              }
          }
      }
  
	
	//Locate the element
  WebElement firstname = driver.findElement(By.xpath("/html/body/section[2]/div/div/div/div[1]/div/div[3]/form/div/div[1]/div/input"));
    firstname.sendKeys("Reshmi");
    Thread.sleep(1000);
    
    WebElement lastname = driver.findElement(By.xpath("/html/body/section[2]/div/div/div/div[1]/div/div[3]/form/div/div[2]/div/input"));
    lastname.sendKeys("SR");
    Thread.sleep(1000);
    
    WebElement dob = driver.findElement(By.xpath("/html/body/section[2]/div/div/div/div[1]/div/div[3]/form/div/div[3]/div/input"));
    dob.sendKeys("10/12/2000");
    Thread.sleep(1000);
    
    WebElement country = driver.findElement(By.xpath("/html/body/section[2]/div/div/div/div[1]/div/div[3]/form/div/div[4]/div/input"));
    country.sendKeys("India");
    Thread.sleep(1000);
    
    
    WebElement email = driver.findElement(By.xpath("/html/body/section[2]/div/div/div/div[1]/div/div[3]/form/div/div[5]/div/input"));
    email.sendKeys("srreshmi123@gmail.com");
    Thread.sleep(1000);
    
    WebElement phone = driver.findElement(By.xpath("/html/body/section[2]/div/div/div/div[1]/div/div[3]/form/div/div[6]/div/input"));
    phone.sendKeys("8075847494");
    Thread.sleep(1000);
    
    WebElement message = driver.findElement(By.xpath("/html/body/section[2]/div/div/div/div[1]/div/div[3]/form/div/div[7]/div/textarea"));
    message.clear();
    message.sendKeys("Room booking");
    Thread.sleep(1000);
    
  }
  
    @Test
    public void D_services() throws InterruptedException {
  	driver.findElement(By.xpath("//*[@id=\"responsive-menu\"]/li[4]/a")).click();
  	Thread.sleep(1000);
  	
    }	
    

    
    @Test
    
    public void E_contactus() throws InterruptedException {
        // Navigate to the Contact Us page
        driver.findElement(By.xpath("//*[@id=\"responsive-menu\"]/li[5]/a")).click();
        Thread.sleep(1000);

        
     // Get the main window handle
        String originalWindow = driver.getWindowHandle();
        
        WebElement map = driver.findElement(By.xpath("/html/body/section[2]/div/div[1]/div/div[1]/div/div[2]/p/a"));
        map.click();
        Thread.sleep(4000);
        
        
       
        
       Set<String> allWindows = driver.getWindowHandles();
        
        // Iterate through the window handles
        for (String window : allWindows) {
            if (!window.equals(originalWindow)) {
                // Switch to the new window
                driver.switchTo().window(window);
                break;
            }
        }

        driver.close();
  	
  	
  	
        driver.switchTo().window(originalWindow);
        Thread.sleep(1000);
    
   WebElement phone = driver.findElement(By.xpath("/html/body/section[2]/div/div[1]/div/div[2]/div/div[2]/p[1]/a"));
   phone.click();
   Thread.sleep(1000);
   
   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   try {
       Alert alert = wait.until(ExpectedConditions.alertIsPresent());
       alert.dismiss();
   } catch (org.openqa.selenium.TimeoutException e) {
       System.out.println("No alert present after clicking the phone link.");
   }

    
    WebElement email = driver.findElement(By.xpath("/html/body/section[2]/div/div[1]/div/div[3]/div/div[2]/p/a"));
    email.click();
    Thread.sleep(1000);
    } 
    
@Test
    
    public void F_Book_now() throws InterruptedException {
    
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/div/a")).click();
        Thread.sleep(1000);
    
  
	WebElement first_name = driver.findElement(By.name("first_name"));
	first_name.sendKeys("malu");
   
    Thread.sleep(1000);
    
    
    WebElement Last_name = driver.findElement(By.name("last_name"));
	Last_name.sendKeys("sr");
    Thread.sleep(1000);
    
    
    WebElement email_in_keepintouch = driver.findElement(By.name("email"));
    email_in_keepintouch.sendKeys("abcd@gmail.com");
    Thread.sleep(1000);
    
    
    WebElement phone_in_keepintouch = driver.findElement(By.name("phone"));
    phone_in_keepintouch.sendKeys("1234567890");
    Thread.sleep(1000);
    
    
    WebElement enter_a_message = driver.findElement(By.name("comments"));
    enter_a_message.sendKeys("book a room");
    
    Thread.sleep(1000);
    
    
//    WebElement sendmessage = driver.findElement(By.id("submit"));
//    sendmessage.click();
//    Thread.sleep(1000);

    
}
    
    
    
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\reshm\\OneDrive\\Desktop\\Scope india\\programm files\\chrome driver\\chromedriver-win64 (3)\\chromedriver-win64\\chromedriver.exe");
      driver = new ChromeDriver();
      String Url = "https://tidalnest.com/";
      driver.get(Url);
      driver.manage().window().maximize();
      Thread.sleep(2000); 	    
	    
  }

  @AfterTest
  public void afterTest() {
	  
	  //driver.quit();
  }

}
