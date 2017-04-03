package pl.lait.Cwiczenie;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CwiczenieTest {
	static FirefoxDriver driver;
				
	@BeforeClass
	public static void beforeClass(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		}
		
	@Test
	public void mainMenuTest(){
		driver.get("http://www.onet.pl");
		
		driver.findElement(By.linkText("Poczta")).click();
		
		WebElement loginName = driver.findElement(By.name("login"));
		loginName.clear();
		loginName.sendKeys("katarzyna@poczta.onet.pl");
		
		WebElement passW = driver.findElement(By.id("f_password"));
		passW.clear();
		passW.sendKeys("haselko");
		
		driver.findElement(By.xpath("id('loginForm')/div[2]/ul[1]/li[3]/input[2]")).click();
		
		Assert.assertTrue("Niepoprawne hasło", true);
		}
		
	
	@AfterClass
	public static void afterClass(){
		driver.close();
		driver.quit();
	}
}
 