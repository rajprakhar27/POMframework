package Functionality;

import org.testng.annotations.Test;

import WebElement.Registerpageelement;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.internal.org.jline.utils.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

@SuppressWarnings("restriction")
public class Registerpagefunctionality  {
	
  WebDriver driver;
  ChromeOptions cr;
  
  
  @Test
  public void registerpageTest() throws FileNotFoundException, IOException {
	
	Logger  log=LogManager.getLogger("Registerpagefunctionality");
	   
      Properties acessproperty=new Properties();
	  acessproperty.load(new FileInputStream("src//test//java//config.properties"));
	  log.info("getting path property from config.properties file");
	  String excelfilepath=acessproperty.getProperty("path");
	  log.info("Reading file from the path");

	  FileInputStream f2=new FileInputStream(excelfilepath);
	  log.info("opening the workbook");
      XSSFWorkbook workbook=new XSSFWorkbook(f2);
	  log.info("getting the individual sheet");

	  XSSFSheet sheet=workbook.getSheetAt(0);
	  for(int i=1;i<=sheet.getLastRowNum();i++)
	  {	  log.info("getting the rows");

		       XSSFRow r=sheet.getRow(i);
		 	  log.info("getting each cell values for the particular rows");

		String firstname= r.getCell(0).getStringCellValue();
		String lastname= r.getCell(1).getStringCellValue();
		String emailid= r.getCell(2).getStringCellValue();
		String newpassword= r.getCell(3).getStringCellValue();
		String confirmpassword= r.getCell(4).getStringCellValue();
		long mobileno= (long)r.getCell(5).getNumericCellValue();
		
		driver.get("https://www.thesouledstore.com/register?redirect=%2Fcart");
		PageFactory.initElements(driver,Registerpageelement.class);
		Registerpageelement.firstname.sendKeys(firstname);
		Registerpageelement.lastname.sendKeys(lastname);
		Registerpageelement.emailid.sendKeys(emailid);
		Registerpageelement.newpassword.sendKeys(newpassword);
		Registerpageelement.confirmpassword.sendKeys(confirmpassword);
		Registerpageelement.mobileno.sendKeys(String.valueOf(mobileno));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		//int count=1;
		/*if(count==1)
		{new WebDriverWait(driver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(Registerpageelement.alertpopup));
		Registerpageelement.alertpopup.click();
		count++;}*/
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		/*new WebDriverWait(driver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(Registerpageelement.gender));
		Registerpageelement.gender.click();
		System.out.println("gender");*/
	//	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()",Registerpageelement.registerbutton );
		  log.info("performing click operation on radio button");

		((JavascriptExecutor) driver).executeScript("arguments[0].click()", Registerpageelement.gender);
		  log.info("performing click operation on register button");

		((JavascriptExecutor) driver).executeScript("arguments[0].click()", Registerpageelement.registerbutton);
		//Registerpageelement.registerbutton.click();
		System.out.println("register");}
		File file=new File("G:\\cookies\\gettcookies1.data");
		  log.info("Creating new file");

		file.createNewFile();
		  log.info("Creating file writer");

        FileWriter writer=new FileWriter(file);
		  log.info("Creating buffer writer");

        BufferedWriter bwriter=new BufferedWriter(writer);
        
		  log.info("Getting all cookies");

		
		
		for(Cookie cookie:driver.manage().getCookies())
		{		  log.info("Getting cookies value");

			bwriter.write(cookie.getName());//+//":"+cookie.getValue()+":"+cookie.getExpiry());
		    bwriter.newLine();}
		bwriter.close();
		writer.close();
		
		  log.info("Task completed succesfuly.......");

		//getcookienamed()
	   //deleteAllcookies();---first step to delete all the previous cookies
	  //deleteCookieNmaed();
	  //deleteCookie(object);
	 //addCookie(name or object); for adding the cookies
	  
	  
	  
	  
  }
  @BeforeTest
  public void beforeTest() throws IOException {
	  Properties acessproperty=new Properties();
	  acessproperty.load(new FileInputStream("src//test//java//config.properties"));
	  String browsername=acessproperty.getProperty("browser");
	  if(browsername.equalsIgnoreCase("chrome")){
		  cr=new ChromeOptions();
		  cr.addArguments("incognito");
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver(cr);
	  }else if(browsername.equalsIgnoreCase("edge")){
		  WebDriverManager.edgedriver().setup();
		  driver=new EdgeDriver();
	  }else if(browsername.equalsIgnoreCase("firefox")){
		  WebDriverManager.firefoxdriver().setup();
		  driver=new FirefoxDriver();
	  }
	  
	  
	  
  }

}
