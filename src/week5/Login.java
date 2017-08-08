package week5;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {

	@FindBy(name = "username")
	private WebElement username_in;

	@FindBy(name = "password")
	private WebElement pass_in;

	@FindBy(name = "FormsButton2")
	private WebElement sub_btn;
	
	@FindBy(css = "big b")
	private WebElement login_lbl;
	
	

	public void enter_username(String username) 
	{
		username_in.sendKeys(username);
	}

	public void enter_password(String password) 
	{
		pass_in.sendKeys(password);
	}

	public void submit() 
	{
		sub_btn.click();
	}
	
	public String check_log_in()
	{
		
		return login_lbl.getText();
		
	} 

}
