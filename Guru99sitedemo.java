import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class Guru99sitedemo {
  WebDriver driver;
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\reshm\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
      driver = new ChromeDriver();
      String Url = "https://demo.guru99.com/V4";
      driver.get(Url);
      driver.manage().window().maximize();
      Thread.sleep(2000); 	  
  }  
  
  @DataProvider()
  public Object[][] dp() {
    return new Object[][] {
    	new Object[] { "mngr574422", "zehAgEr" }, // both correct
        new Object[] { "locked_out_user", "malu_123" },   // correct user and incorrect password
        new Object[] { "problem_user", "deva_123" },      // correct user and incorrect password
        new Object[] { "performance_glitch_user", "malu@_123" },
    };
  }
  @Test(dataProvider = "loginData")
  public void demo(String username, String password) {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      WebElement uidField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("uid")));
      uidField.sendKeys(username);

      WebElement passwordField = driver.findElement(By.name("password"));
      passwordField.sendKeys(password);

      WebElement loginButton = driver.findElement(By.name("btnLogin"));
      loginButton.click();

      wait.until(ExpectedConditions.urlContains("expected_url_after_login"));  // Replace with the actual URL part that confirms a successful login
  }

    
@AfterMethod
public void afterMethod() {
	driver.quit();  
	  	  
}
}



