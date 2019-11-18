package com.techelevator;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.techelevator.npgeek.model.JDBCParkDAO;
import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.ParkDAO;
import com.techelevator.pageobject.DetailsPage;
import com.techelevator.pageobject.HomePage;
import com.techelevator.pageobject.SurveyPage;

public class HomePageSeleniumTest extends SeleniumTest {
	ParkDAO parkDAO = new JDBCParkDAO(dataSource);
	
	@Test
	public void ensure_park_list() {
		List<WebElement> parkList = homePage.getParkListElement();
		Assert.assertEquals(parkList.size(), parkDAO.getAllParks().size());
	}
	
	@Test
	public void goes_to_home_page_from_survey_using_header() {
		String original = homePage.getCurrentURL();
		SurveyPage surveyPage = homePage.clickSurveyLink();
		Assert.assertNotEquals(original, surveyPage.getCurrentURL());
		HomePage headerHomePage = homePage.clickHomePageLink();
		Assert.assertEquals(original, headerHomePage.getCurrentURL());
	}
	
	@Test
	public void goes_to_all_the_details() throws InterruptedException {
		List<Park> parks = parkDAO.getAllParks();
		
		for( Park park : parks ) {
			DetailsPage detailsPage = homePage.goToParkDetails(park.getParkName());
			Assert.assertEquals(detailsPage.getCurrentURL(), rootURL+"details/"+park.getParkCode());
			// go back home
			TimeUnit.SECONDS.sleep(1); // idk why but I need to wait before clicking?
			detailsPage.clickHomePageLink();
		}
	}
}
