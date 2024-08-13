import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Task_pagetitle_assert {
	private WebDriver driver;
  @BeforeTest
   public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\reshm\\OneDrive\\Desktop\\Scope india\\programm files\\chrome driver\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
       driver = new ChromeDriver();
      driver.get("https://www.linkedin.com/");
	  }	
  @Test
  public void f() {
	  String actualTitle=driver.getTitle();
	  String expectedTitle="LinkedIn: Log In or Sign Up";
	  Assert.assertEquals(actualTitle, expectedTitle);
  }
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}

