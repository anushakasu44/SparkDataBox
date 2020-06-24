package pages;

import java.awt.Desktop.Action;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Com.Util.BaseClass;


public class HomePage extends BaseClass {
	static Logger log=Logger.getLogger(HomePage.class);

	@FindBy(xpath="(//div//a[text()='Sign Up'])[position()=2]")
	WebElement signup;
	
	@FindBy(xpath="//input[@placeholder='Search For Courses']")
	WebElement searchbox;
	
	@FindBy(xpath="/html/body/section[1]/div/div/div/nav/form/div/div/button/i")
	WebElement searchicon;
	
	@FindBy(xpath="//a[text()='Javascript - Introduction for Beginners']")
	WebElement JavaScriptCourseTitle;
	
	@FindBy(xpath="//a[text()='Java Interview Questions']")
	WebElement javainterviewQuestCourseTitle;
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement submit;
	
	@FindBy(xpath="//div[@class='video-btn vb-self']")
	WebElement previewcourse;
	
	@FindBy(xpath="//a[@class='course-title']")
	List<WebElement> querysearch;
	
	@FindBy(xpath="(//a[text()='Log In'])[2]")
	WebElement login;
	
	@FindBy(xpath="//h5[@class='title']")
	List<WebElement> liveandselfpacedcourses;
	
	@FindBy(xpath="//a[text()='Python Complete reference : Go from Beginner to Advanced']")
	WebElement freecouponcours;
	
	@FindBy(xpath="//a[text()='Develop RESTful Java Web Services using JAX-RS and Jersey']")
	WebElement JAXRSandJersey;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateCourseTitle() {
		log.info("validating course title");
		return JavaScriptCourseTitle.getText();
		
	}
	public void searchcourse(String query) {
		log.info("searching course name");
		searchbox.sendKeys(query);
		searchicon.click();
		
	}
	
	public void searchSpecificCourse(String specificcourse) {
		searchbox.sendKeys(specificcourse);
		searchicon.click();
	}
	
	public void validateQuerySearch(String course) {
		for(int i=0;i<querysearch.size();i++) {
			WebElement ele= querysearch.get(i);
		    ScrollElementIntoView(ele);
		     querysearch.get(i).getText().contains(course);
		     Boolean bool=querysearch.get(i).isDisplayed();
		     Assert.assertTrue(bool);
		    }
		
		
	}
	
	public GetEnrolledPage searchfreecourse(String course) {
		
		for(int i=0;i<querysearch.size();i++) {
		     querysearch.get(i).getText().equals(course);
		     Boolean bool=querysearch.get(i).isDisplayed();
		     Assert.assertTrue(bool);
		     WebElement ele=querysearch.get(i);
		     javaScriptClick(ele);
		    
		      }
		return new GetEnrolledPage();
	}
	
	
	public void clickOnCourseTitle() {
		log.info("clicking on course title");
		JavaScriptCourseTitle.click();
	}
	
	public SignUp clickOnSignUp() {
		log.info("clicking on signup Page");
		signup.click();
		return new SignUp();
	}
	public CoursePreview clickOnpreviewCourse() {
		ScrollElementIntoView(previewcourse);
		javaScriptClick(previewcourse);
		return new CoursePreview();
	}
	
	public String verifytitle() {
		log.info("verifying homepage title");
		return driver.getTitle();
	}
	
	public LoginPage clickOnLogin() {
		login.click();
		return new LoginPage();
	}
	
	public GetEnrolledPage selectLiveAndSelfPacedCourses(String LiveAndSelfPaced) {
		for(int i=0;i<liveandselfpacedcourses.size();i++) {
			if(liveandselfpacedcourses.get(i).getText().equalsIgnoreCase(LiveAndSelfPaced)) {
				Boolean bool=liveandselfpacedcourses.get(i).isDisplayed();
				Assert.assertTrue(bool);
				liveandselfpacedcourses.get(i).click();
				
			}
		}
		return new GetEnrolledPage();
	}
	
	public GetEnrolledPage clickOnfreecouponcours() {
		freecouponcours.click();
		return new GetEnrolledPage();
	}
}
