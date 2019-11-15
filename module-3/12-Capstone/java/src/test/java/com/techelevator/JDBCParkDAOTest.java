package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.npgeek.model.JDBCParkDAO;
import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.ParkDAO;

public class JDBCParkDAOTest extends DAOIntegrationTest {
	
	private ParkDAO dao = new JDBCParkDAO(dataSource);

	@Test
	public void return_park_by_park_code() {
		Park fakePark = createFakePark("USA", "USA National Park", "PA", 100, 100, 100, 100, "Sunny", 2019, 1,
				"to be or not to be a park", "Sarah", "pretty cool park", 0, 10);
		Park fetchedPark = dao.getParkByParkCode(fakePark.getParkCode());
		assertEquals(fakePark.getParkName(), fetchedPark.getParkName());
		assertEquals(fakePark, fetchedPark);
	}

	@Test
	public void return_all_parks() {
		List<Park> allParks = dao.getAllParks();
		Park fakePark = createFakePark("USA", "USA National Park", "PA", 100, 100, 100, 100, "Sunny", 2019, 1,
				"to be or not to be a park", "Sarah", "pretty cool park", 0, 10);
		List<Park> allParksPlusOne = dao.getAllParks();
		Assert.assertEquals(allParksPlusOne.size(), allParks.size() + 1);
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
