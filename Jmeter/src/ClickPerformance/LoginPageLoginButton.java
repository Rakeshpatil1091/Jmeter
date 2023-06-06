package ClickPerformance;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class LoginPageLoginButton {
	
	WebDriver driver=null;
	
	@Before
	public void beforeTest(){
		
		System.setProperty("webdriver.chrome.driver", "D:\\data\\Software\\chromedriver_win32\\chromedriver.exe");
		
		
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless");
		//driver = new ChromeDriver(options);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		 
		 

	}	
	
	@After
	public void afterTest() {
		System.out.println("Success");
		
	}
	
	@Test
	public void Login() {
		driver.get("http://129.154.229.42:6500/ouaf/cis.jsp");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.id("userId")).sendKeys("uat1");
		driver.findElement(By.id("password")).sendKeys("cam!tH$dZ$");
		driver.findElement(By.id("loginButton")).click();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
		Date date = new Date();
		System.out.println("lOGIN CLICK TIME: "+dateFormat.format(date)); 
		
	}
}

