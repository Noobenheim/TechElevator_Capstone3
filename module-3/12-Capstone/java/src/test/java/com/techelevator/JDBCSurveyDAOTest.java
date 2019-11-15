package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.techelevator.npgeek.model.JBDCSurveyDAO;
import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.SurveyDAO;
import com.techelevator.npgeek.model.SurveySummary;

public class JDBCSurveyDAOTest extends DAOIntegrationTest {
	
	private SurveyDAO dao = new JBDCSurveyDAO(dataSource);
	
	@Test
	public void create_fake_survey() {
		deleteAllSurveyResponsesForTesting();
		
		Park fakePark = createFakePark("USA", "USA National Park", "PA", 100, 100, 100, 100, "Sunny", 2019, 1,
				"to be or not to be a park", "Sarah", "pretty cool park", 0, 10);
		Survey fakeSurvey = createFakeSurvey("USA", "email@email.com", "PA", "lazy");
		List<SurveySummary> fetchedSurveys = dao.getSurveySummary(); 
		
		assertEquals(1, fetchedSurveys.size());
		
	}
	
	@Test
	public void create_fake_survey_summary_list() {
		deleteAllSurveyResponsesForTesting();
		
		Park fakePark = createFakePark("USA", "USA National Park", "PA", 100, 100, 100, 100, "Sunny", 2019, 1,
				"to be or not to be a park", "Sarah", "pretty cool park", 0, 10);
		Survey fakeSurvey1 = createFakeSurvey("USA", "email@email.com", "PA", "lazy");
		Survey fakeSurvey2 = createFakeSurvey("GNP", "lol@lol.com", "PA", "extremely lazy");
		List<SurveySummary> fetchedSurveys = dao.getSurveySummary(); 
		
		assertEquals(2, fetchedSurveys.size());
	}
	
	private void deleteAllSurveyResponsesForTesting () {
		String sqlDelete = "DELETE FROM survey_result"; 
		int deleted = jdbc.update(sqlDelete); 
		
	}
	
	private Survey createFakeSurvey (String parkCode, String emailAddress, String state, String activityLevel) {
		Survey fakeSurvey = new Survey();
		
		fakeSurvey.setParkCode(parkCode);
		fakeSurvey.setEmailAddress(emailAddress);
		fakeSurvey.setState(state);
		fakeSurvey.setActivityLevel(activityLevel);
		
		String sqlInsertSurveyForecast = "INSERT INTO survey_result VALUES (DEFAULT, ?, ?, ?, ?) RETURNING surveyid"; 
		Long surveyId = jdbc.queryForObject(sqlInsertSurveyForecast, Long.TYPE, parkCode, emailAddress, state, activityLevel);
		
		fakeSurvey.setSurveyId(surveyId);
		
		return fakeSurvey;
	}
	
	private Park createFakePark(String parkCode, String name, String state, int acreage, int elevationInFeet,
			double milesOfTrail, int numberOfCampsites, String climate, int yearFounded, int annualVisitorCount,
			String inspirationalQuote, String inspirationalQuoteSource, String parkDescription, int entryFee,
			int numberOfAnimalSpecies) {

		Park fakePark = new Park();

		fakePark.setParkCode(parkCode);
		fakePark.setParkName(name);
		fakePark.setState(state);
		fakePark.setAcreage(acreage);
		fakePark.setElevationInFeet(elevationInFeet);
		fakePark.setMilesOfTrail(milesOfTrail);
		fakePark.setNumberOfCampsites(numberOfCampsites);
		fakePark.setClimate(climate);
		fakePark.setYearFounded(yearFounded);
		fakePark.setAnnualVisitorCount(annualVisitorCount);
		fakePark.setInspirationalQuote(inspirationalQuote);
		fakePark.setInspirationalQuoteSource(inspirationalQuoteSource);
		fakePark.setParkDescription(parkDescription);
		fakePark.setEntryFee(entryFee);
		fakePark.setNumberOfAnimalSpecies(numberOfAnimalSpecies);

		String sqlInsertPark = "INSERT INTO park VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int numberOfNewParksInserted = jdbc.update(sqlInsertPark, parkCode, name, state, acreage,
				elevationInFeet, milesOfTrail, numberOfCampsites, climate, yearFounded, annualVisitorCount,
				inspirationalQuote, inspirationalQuoteSource, parkDescription, entryFee, numberOfAnimalSpecies);
		
		return fakePark;
	}

}
