package steps;

import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BackgroundChangePage;
import pages.TestBase;

public class BackgroundChangePageSteps extends TestBase {
	
	BackgroundChangePage backgroundChangePage;
	@Before
	public void beforeRun() {
		init();
		backgroundChangePage=PageFactory.initElements(driver, BackgroundChangePage.class);
	}
	
	@Given("^\"([^\"]*)\" button exists$")
	public void button_exists(String button) throws Throwable {
		if(button.equalsIgnoreCase("Set SkyBlue Background")) {
			backgroundChangePage.blueskyBackgroundButtonExist();
			
		}
		else if(button.equalsIgnoreCase("Set White Background")){
			backgroundChangePage.whiteBackgroundbuttonExist();
			
		}
	  
	}

	@When("^I click on the \"([^\"]*)\" button$")
	public void i_click_on_the_button(String backgroundButton) throws Throwable {
		if(backgroundButton.equalsIgnoreCase("Set SkyBlue Background")) {
			backgroundChangePage.clickBlueBackgroundButton();
		}
		else if(backgroundButton.equalsIgnoreCase("Set White Background")) {
			backgroundChangePage.clickWhiteBackgroundButton();
			
		}
	  
	}

	@Then("^the background color will change to sky blue$")
	public void the_background_color_will_change_to_sky_blue() throws Throwable {
		backgroundChangePage.verifyBackgroundIsBlue();
		takeScreenshot(driver);
	  
	}

	@Then("^the background color will change to white$")
	public void the_background_color_will_change_to_white() throws Throwable {
		backgroundChangePage.verifyBackgroundIsWhite();
		takeScreenshot(driver);
	 
	}
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
