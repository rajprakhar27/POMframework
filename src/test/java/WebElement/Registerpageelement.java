package WebElement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Registerpageelement {
	
	@FindBy(xpath="//input[contains(@placeholder,\"First Name *\")]")
	public static WebElement firstname;
	
	@FindBy(xpath="//input[contains(@placeholder,\"Last Name\")]")
	public static WebElement lastname;
	
	@FindBy(xpath="//input[contains(@placeholder,\"Email ID *\")]")
	public static WebElement emailid;
	
	@FindBy(xpath="//input[contains(@placeholder,\"Choose New Password *\")]")
	public static WebElement newpassword;
	
	@FindBy(xpath="//input[contains(@placeholder,\"Confirm Password *\")]")
	public static WebElement confirmpassword;
	
	@FindBy(xpath="//input[contains(@placeholder,\"Mobile Number(For order status update) *\")]")
	public static WebElement mobileno;
	
	@FindBy(xpath="//*[@id=\"moe-dontallow_button\"]")
	public static WebElement alertpopup;
	
	
	
	@FindBy(xpath="//*[@id=\"radio1\"]")
	public static WebElement gender;
	
	@FindBy(xpath="//button[contains(@type,\"submit\")]")
	public static WebElement registerbutton;
	
	
	
	
	}
