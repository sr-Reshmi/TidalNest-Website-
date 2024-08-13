import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
public class Dataprovider {
    WebDriver driver;
    
    @Test(dataProvider = "login")
    public void f(String username, String password) throws InterruptedException {
    	driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);
        
        // Add logic here to verify the login outcome if needed.
    }

    @DataProvider(name = "login")
    public Object[][] dp_method() {
        return new Object[][] {
            new Object[] { "standard_user", "secret_sauce" }, // both correct
            new Object[] { "locked_out_user", "malu_123" },   // correct user and incorrect password
            new Object[] { "problem_user", "deva_123" },      // correct user and incorrect password
            new Object[] { "performance_glitch_user", "malu@_123" },
        };
    }

    @BeforeTest
    public void beforeTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\reshm\\OneDrive\\Desktop\\Scope india\\programm files\\chrome driver\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        String Url = "https://www.saucedemo.com/";
        driver.get(Url);
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
