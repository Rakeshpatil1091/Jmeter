package ClickPerformance;

import java.io.IOException;
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
import org.openqa.selenium.support.ui.Select;

import Utility.ExcelSheet;


public class DashBoardNameSearch extends ExcelSheet {
	
	WebDriver driver=null;
	DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
	@Before
	public void beforeTest(){
		
		System.setProperty("webdriver.chrome.driver", "D:\\data\\Software\\chromedriver_win32\\chromedriver.exe");
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless");
		//driver = new ChromeDriver(options);
		driver = new ChromeDriver();
			
		driver.manage().window().maximize();
		
		driver.get("http://129.154.229.42:6500/ouaf/cis.jsp");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.id("userId")).sendKeys("uat1");
		driver.findElement(By.id("password")).sendKeys("cam!tH$dZ$");
		driver.findElement(By.id("loginButton")).click();
		
		Date date = new Date();
		System.out.println("lOGIN CLICK TIME: "+dateFormat.format(date)); 
	}	
	
	@After
	public void afterTest() {
		System.out.println("Success");
		
	}
	
	@Test
	public void Test() throws IOException {

		WebElement parentIframe=driver.findElement(By.xpath("//frame[@title='Main Frame']"));
		driver.switchTo().frame(parentIframe);
		System.out.println("AFTER MAIN FRAME");
		
		WebElement childIframe=driver.findElement(By.xpath("//iframe[@id='tabPage']"));
		driver.switchTo().frame(childIframe);
		System.out.println("AFTER TAB PAGE");
		
		
		WebElement dropdown=driver.findElement(By.xpath("//select[@id='multiQueryZoneFilters1']"));
		System.out.println("AFTER DROPDOWN");
		
		//Select se=new Select(dropdown);
		//se.selectByVisibleText("Account ID");
		//se.selectByIndex(1);
		dropdown.sendKeys("Account ID");

		
		//System.out.println("SEARCH NAME AND ADDRESS");
		//System.out.println(ExcelSheet.getData(5, 0));
		WebElement AccNoTextBox= driver.findElement(By.xpath("//input[@id='accountId1']"));
		AccNoTextBox.sendKeys(ExcelSheet.getData(7, 0));
		System.out.println("AFTER TYPING ACCOUNT NUMBER");
		
		
		//WebElement AccNameTextBox= driver.findElement(By.xpath("//input[@id='entityName1']"));
		//AccNameTextBox.sendKeys("test");
		//System.out.println("AFTER TYPING NAME AND ADDRESS");
		
		WebElement SearchButton = driver.findElement(By.xpath(" //input[@id='anTLZ1Refresh']"));
		SearchButton.click();

	DateFormat dateFormat2 = new SimpleDateFormat("yyyyMMdd_HHmmss");
		Date date2 = new Date();
		System.out.println("SEARCH CLICK TIME: "+dateFormat.format(date2));
		System.out.println("SEARCHED");
	}
}

