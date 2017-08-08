package week5;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;



public class Week5login {
	private WebDriver webDriver;
	private Login Login;
	
	@After
	public void aftertest() {
		 webDriver.quit();
	}

	@Before
	public void b4test() {
		webDriver = new ChromeDriver();
		Login = PageFactory.initElements(webDriver, Login.class);
		
	}
	

	@Test
	public void test_login() {
		
		
		webDriver.navigate().to("http://thedemosite.co.uk/addauser.php");
		Login.enter_username("test");
		Login.enter_password("test");
		Login.submit();
		
	
		webDriver.navigate().to("http://thedemosite.co.uk/login.php");
		Login.enter_username("test");
		Login.enter_password("test");
		Login.submit();
		
		
		assertEquals("**Successful Login**", Login.check_log_in());
	}

}


