package com.techelevator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.techelevator.npgeek.model.JBDCSurveyDAO;
import com.techelevator.npgeek.model.SurveyDAO;
import com.techelevator.pageobject.FavoritesPage;

public class SurveyPageSeleniumTest extends SeleniumTest {
	SurveyDAO surveyDAO = new JBDCSurveyDAO(dataSource); 

	
	@Test
	public void test_form_can_be_edited_and_submitted() {
		FavoritesPage favoritesPage = homePage.clickSurveyLink()
							.enterFavoriteNationalPark("Yellowstone National Park")
							.enterEmail("test@test")
							.enterState("Ohio")
							.enterActivityLevel("Active")
							.submitForm();
		
		assertEquals("2 Votes", favoritesPage.getFavoriteCount()); 
		
	}
	
	
}
