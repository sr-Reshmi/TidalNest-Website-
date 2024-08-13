import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Auto_it_programme {

	public static void main(String[] args) throws InterruptedException, IOException {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\reshm\\OneDrive\\Desktop\\Scope india\\programm files\\chrome driver\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
	    WebDriver  driver = new ChromeDriver();
	      driver.get( "https://demo.guru99.com/test/upload");
	      driver.manage().window().maximize();
	      Thread.sleep(2000); 	
		
		WebElement choose_file=driver.findElement(By.name("uploadfile_0"));
		//choose_file.click();
		Actions point=new Actions(driver);
		point.moveToElement(choose_file).click().perform();
		Runtime.getRuntime().exec("C:\\Users\\reshm\\OneDrive\\Desktop\\fileupload.exe");
		WebElement accept_terms=driver.findElement(By.xpath("//*[@id=\"terms\"]"));
		accept_terms.click();
		
		WebElement submit=driver.findElement(By.xpath("//*[@id=\"submitbutton\"]"));
		submit.click();
		
		
		
		//driver.quit();		
		
		

	}

}
