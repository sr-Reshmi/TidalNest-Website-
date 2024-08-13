import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class Object_repos {
	WebDriver driver;
  @Test
  public void loadPropertiesAndLogin() throws IOException, InterruptedException {
      // Load properties from the file
      Properties props = new Properties();
      FileInputStream ip = new FileInputStream("D:\\eclipse\\TestNG_demo\\Objectrepos.properties");
      props.load(ip);
      ip.close();
      
     
      driver.findElement(By.name(props.getProperty("username_name"))).sendKeys(props.getProperty("Username"));
      Thread.sleep(2000);
      driver.findElement(By.name(props.getProperty("password_name"))).sendKeys(props.getProperty("Password"));
      
      
      WebElement submit = driver.findElement(By.id("submit"));
      submit.click();
  }   
  

  @BeforeMethod
  public void setUp() throws InterruptedException {
      System.setProperty("webdriver.chrome.driver", "C:\\Users\\reshm\\OneDrive\\Desktop\\Scope india\\programm files\\chrome driver\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
      driver = new ChromeDriver();
      String url = "https://practicetestautomation.com/practice-test-login/";
      driver.get(url);
      driver.manage().window().maximize();
      Thread.sleep(2000);   
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

  
  
  
  
  
 
}
