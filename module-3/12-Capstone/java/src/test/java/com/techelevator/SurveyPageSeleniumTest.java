package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.techelevator.npgeek.model.JBDCSurveyDAO;
import com.techelevator.npgeek.model.SurveyDAO;
import com.techelevator.pageobject.FavoritesPage;

public class SurveyPageSeleniumTest extends SeleniumTest {
	SurveyDAO surveyDAO = new JBDCSurveyDAO(dataSource); 

	@Test
	public void test_form_can_be_edited_and_submitted() throws InterruptedException {
		// go to the favorites page directly
		webDriver.get("http://localhost:8080/m3-java-capstone/favoriteParks");
		FavoritesPage favoritesPage = new FavoritesPage(webDriver);
		
		// get initial count
		String parkName = "Yellowstone National Park";
		int votes = favoritesPage.getFavoriteCount(parkName);
		
		favoritesPage = homePage.clickSurveyLink()
						.enterFavoriteNationalPark(parkName)
						.enterEmail("test@test")
						.enterState("Ohio")
						.enterActivityLevel("Active")
						.submitForm();
		
		assertEquals(votes+1, favoritesPage.getFavoriteCount(parkName)); 
	}
}
