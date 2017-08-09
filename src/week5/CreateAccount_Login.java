package week5;

import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.base.Function;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;
import java.util.List;

public class CreateAccount_Login {

	private WebDriver webDriver;
	Login l = new Login();
	Wait<WebDriver> wait;

	private static ExtentReports report;
	private ExtentTest test;
	private static String reportFilePath = "Report.html";


	@BeforeClass
	public static void bc() {
		report = new ExtentReports();
		ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(reportFilePath);
		extentHtmlReporter.config().setReportName("ReportName");
		extentHtmlReporter.config().setDocumentTitle("DocumentTitle");
		report.attachReporter(extentHtmlReporter);
	}

	@Before
	public void setUp() {
		System.out.println("Before");

		webDriver = new ChromeDriver();

		l = PageFactory.initElements(webDriver, Login.class);

		wait = new FluentWait<WebDriver>(webDriver).withTimeout(5, SECONDS).pollingEvery(1, SECONDS)
				.ignoring(NoSuchElementException.class);

	}

	@After
	public void aTest() {
		System.out.println("Test Complete.");
		webDriver.quit();

	}

	@AfterClass
	public static void AfterClass() {
		report.flush();
	}

	@Test
	public void CreateAcc_Login()  {
		test = report.createTest("actual test");
		
		 DataReader sheetReader = new DataReader(System.getProperty("user.dir") +"/orksheet.xlsx");
	        List<String> row = sheetReader.readRow(2, "adam");

	       
	        	webDriver.navigate().to("http://thedemosite.co.uk/addauser.php");
	    		l.enter_username(row.get(0).toString());
	    		l.enter_password(row.get(1).toString());
	    		l.submit();
	    		
	    		WebElement check_user_name = wait.until(new Function <WebDriver, WebElement>()

	    		{public WebElement apply(WebDriver webDriver) {return webDriver.findElement(By.name("username"));}});
	    		
	    		webDriver.navigate().to("http://thedemosite.co.uk/login.php");
	    		l.enter_username(row.get(0).toString());
	    		l.enter_password(row.get(1).toString());
	    		l.submit();
	        

		assertEquals("**Successful Login**", l.check_log_in());
		webDriver.quit();

	}
}