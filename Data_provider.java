import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class Data_provider {
	WebDriver driver;
  
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\reshm\\OneDrive\\Desktop\\Scope india\\programm files\\chrome driver\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
      driver = new ChromeDriver();
      String Url = "https://www.saucedemo.com/";
      driver.get(Url);
      driver.manage().window().maximize();
      Thread.sleep(2000); 	  
  }
  @DataProvider(name="loginData")
  public Object[][] dp() {
	  return new Object[][] {
          new Object[] { "standard_user", "secret_sauce" }, // both correct
          new Object[] { "locked_out_user", "malu_123" },   // correct user and incorrect password
          new Object[] { "problem_user", "deva_123" },      // correct user and incorrect password
          new Object[] { "performance_glitch_user", "malu@_123" },
      };
  }
  @Test(dataProvider = "loginData")
  public void logindata(String username, String password) throws InterruptedException {
  	 driver.findElement(By.id("user-name")).sendKeys(username);
      driver.findElement(By.id("password")).sendKeys(password);
      driver.findElement(By.id("login-button")).click();
      Thread.sleep(2000);
  }
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }	  
	  
	
}
