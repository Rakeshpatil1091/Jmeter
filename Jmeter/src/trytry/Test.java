package trytry;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.xml.XmlSuite.ParallelMode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {
WebDriver driver=null;
int count =0;
	
	//@SuppressWarnings("deprecation")
	@BeforeMethod
	public void beforeMethod(){
		
		System.setProperty("webdriver.chrome.driver", "D:\\data\\Software\\chromedriver_win32\\chromedriver.exe");
		

		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless");
		//driver = new ChromeDriver(options);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("http://129.154.229.42:6500/ouaf/cis.jsp");
		
	}	
	
	@AfterMethod 
	public void afterMethod() {
		//driver.quit();
		//System.out.println("Success");
		
	}
	
	@org.testng.annotations.Test( dataProvider ="dataset1")
	public void Login1(String username, String password) throws InterruptedException {
         
		driver.findElement(By.id("userId")).sendKeys(username);
		WebElement pass =driver.findElement(By.id("password"));
		pass.sendKeys(password);
		pass.sendKeys(Keys.TAB);
		driver.findElement(By.id("loginButton")).click();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
		Date date = new Date();
		System.out.println("lOGIN CLICK TIME: "+dateFormat.format(date)); 
          count = count+1;
		System.out.println("count: " + count);
		}

	
	@DataProvider(parallel = false)
	public Object[][] dataset1(){
		return new Object[][]
	{
			{"uat1","cam!tH$dZ$"},		
			{"uat1","cam!tH$dZ$"}	
	};
		
	}

	}

