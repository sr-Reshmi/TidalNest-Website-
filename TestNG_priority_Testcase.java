import org.testng.Assert;
import org.testng.annotations.Test;
import java.sql.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestNG_priority_Testcase {
	public WebDriver driver;
  @Test(priority=1)
  public void apenBrowser() {
	  driver=new FirefoxDriver();  
  }
  @Test(priority=2)
  public void launchGoogle() {
   driver.get("https://www.google.co.in/?gws_rd=ssl");
}
  @Test(priority=3)
  public void searchandclicklink() throws InterruptedException { 
	  WebElement searchField = driver.findElement(By.name("q"));
     searchField.sendKeys("facebook");
     WebElement Googlesearch = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[4]/div[6]/center/input[1]"));
     Thread.sleep(3000);
     Googlesearch.click();
  }
  @Test(priority=4)
  public void xageTitleverification() throws InterruptedException {
	//driver.findElement(By.xpath(".//*[@value='Search']")).click();
	String title=driver.getTitle(); 
	System.out.println(title);
	
	 // Thread.sleep(3000);
	  Assert.assertEquals(driver.getTitle().contains(" Google search"),true);
  
  
  
  }
  
  
  }