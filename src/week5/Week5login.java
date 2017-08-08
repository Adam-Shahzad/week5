package week5;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static java.util.concurrent.TimeUnit.SECONDS;
import java.util.NoSuchElementException;

public class Week5login {
	private WebDriver webDriver;
	private Login Login;
	Wait<WebDriver> wait;

	@After
	public void aftertest() {
		webDriver.quit();
	}

	@Before
	public void b4test() {
		webDriver = new ChromeDriver();
		Login = PageFactory.initElements(webDriver, Login.class);
		wait = new FluentWait<WebDriver>(webDriver).withTimeout(5, SECONDS).pollingEvery(1, SECONDS)
				.ignoring(NoSuchElementException.class);

	}

	@Test
	public void test_login() {

		webDriver.navigate().to("http://thedemosite.co.uk/addauser.php");
		Login.enter_username("test");
		Login.enter_password("test");
		Login.submit();
		
		
		
		WebElement check_user_name = wait.until(new Function <WebDriver, WebElement>()

		{
		
			public WebElement apply(WebDriver webDriver) {
				return webDriver.findElement(By.name("username"));
			}
		});

		webDriver.navigate().to("http://thedemosite.co.uk/login.php");
		Login.enter_username("test");
		Login.enter_password("test");
		Login.submit();

		assertEquals("**Successful Login**", Login.check_log_in());
	}

}
