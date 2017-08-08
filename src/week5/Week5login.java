package week5;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;



public class Week5login {
	private WebDriver webDriver;
	
	@After
	public void aftertest() {
		 webDriver.quit();
	}

	@Before
	public void b4test() {
		webDriver = new ChromeDriver();
	}
	

	@Test
	public void test_login() {
		webDriver.navigate().to("http://thedemosite.co.uk/addauser.php");
		webDriver.findElement(By.name("username")).sendKeys("test");
		webDriver.findElement(By.name("password")).sendKeys("test");
		webDriver.findElement(By.name("FormsButton2")).click();
		
		webDriver.navigate().to("http://thedemosite.co.uk/login.php");
		webDriver.findElement(By.name("username")).sendKeys("test");
		webDriver.findElement(By.name("password")).sendKeys("test", Keys.RETURN);
		webDriver.findElement(By.name("FormsButton2")).click();
		
		assertEquals("**Successful Login**", webDriver.findElement(By.cssSelector("big  b")).getText());
	}

}


