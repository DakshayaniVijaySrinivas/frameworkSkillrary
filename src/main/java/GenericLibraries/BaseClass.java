package GenericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomPages.ContactUsPage;
import pomPages.CoreJavaForSeleniumPage;
import pomPages.CoreJavaVideoPage;
import pomPages.HomePage;
import pomPages.SeleniumTrainingPage;
import pomPages.SkillraryDemoAppPage;
import pomPages.TestingPage;

public class BaseClass {

	protected PropertiesFileUtility property;
	protected ExcelUtility excel;
	protected webDriverUtility web;
	protected WebDriver driver;
	protected HomePage home;
	protected SkillraryDemoAppPage skillraryDemo;
	protected SeleniumTrainingPage selenium;
	protected TestingPage testing;
	protected CoreJavaForSeleniumPage coreJava;
	protected CoreJavaVideoPage javaVideo;
	protected ContactUsPage contact;
	protected long time;
	
	//@BeforeSuite
	//@BeforeTest
	
	@BeforeClass
	
	public void classConfiguaration()
	{
		property= new PropertiesFileUtility();
		excel=new ExcelUtility();
		web=new webDriverUtility();
		
		property.propertyFileInitialization(IConstantPath.PROPERTIES_FILE_PATH);
		excel.excelInitialization(IConstantPath.EXCEL_FILE_PATH);
		
	}
	
	
	@BeforeMethod
	public void methodConfiguaration()
	{
		time=Long.parseLong(property.fetchProperty("timeouts"));
		driver=web.openApplication(property.fetchProperty("browser"), property.fetchProperty("url"), time);
		
		home=new HomePage(driver);
		
		Assert.assertTrue(home.getLogo().isDisplayed());
		
		skillraryDemo= new SkillraryDemoAppPage(driver);
		selenium=new SeleniumTrainingPage(driver);
		coreJava=new CoreJavaForSeleniumPage(driver);
		javaVideo=new CoreJavaVideoPage(driver);
		testing=new TestingPage(driver);
		contact=new ContactUsPage(driver);
		
	}
	
	
	@AfterMethod
	public void methodTearDown()
	{
		web.quitBrowser();
	}
	
	@AfterClass
	public void classTearDown()
	{
		excel.closeExcel();
	}
	//@AfterTest
	//@AfterSuite
	
}
