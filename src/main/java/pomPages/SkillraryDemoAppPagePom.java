package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLibraries.webDriverUtility;


public class SkillraryDemoAppPagePom {
	
	//Declaration
	@FindBy(xpath = "//div[@Class='navbar-header']")	private WebElement pageHeader;
	@FindBy(id="course")								private WebElement courseTab;
	@FindBy(xpath="//span[@class='wrappers']/a[text()='Selenium Training']")
														private WebElement SeleniumTrainingLink;
	@FindBy(name="addresstype")							private WebElement categoryDropdown;
	@FindBy(xpath="//a[text()='Contact us']")			private WebElement contactUsLink;
	
	//Initialization
	public  SkillraryDemoAppPagePom(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getPageHeader() {
		return pageHeader;
	}
	
	public void mouseHoverToCourse(webDriverUtility web) {
		web.mouseHover(courseTab);
	}
	
	public void clickSeleniumTraining() {
		SeleniumTrainingLink.click();
	}
	
	public void selectCategory(webDriverUtility web, int index) {
		web.dropdown(categoryDropdown, index);
	}
	
	public void clickContactUs() {
		contactUsLink.click();
	}
}
