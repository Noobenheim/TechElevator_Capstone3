package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCParkDAO implements ParkDAO {
	private JdbcTemplate jdbcTemplate;
	
	public JDBCParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Park> getAllParks() {
		List<Park> parks = new ArrayList<>();
		String sqlQuery = "SELECT parkCode, parkName, state, acreage, elevationInFeet, milesOfTrail, " +
						  "numberOfCampsites, climate, yearFounded, annualVisitorCount, inspirationalQuote, " +
						  "inspirationalQuoteSource, parkDescription, entryFee, numberOfAnimalSpecies "+
						  "FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery);
		
		while( results.next() ) {
			Park park = mapRowToPark(results);
			parks.add(park);
		}
		
		return parks;
	}

	/*
	 * 	parkCode VARCHAR(10) PRIMARY KEY,
		parkName VARCHAR(200) NOT NULL,
		state VARCHAR(30) NOT NULL,
		acreage INTEGER NOT NULL,
		elevationInFeet INTEGER NOT NULL,
		milesOfTrail REAL NOT NULL,
		numberOfCampsites INTEGER NOT NULL,
		climate VARCHAR(100) NOT NULL,
		yearFounded INTEGER NOT NULL,
		annualVisitorCount INTEGER NOT NULL,
		inspirationalQuote TEXT NOT NULL,
		inspirationalQuoteSource VARCHAR(200) NOT NULL,
		parkDescription TEXT NOT NULL,
		entryFee INTEGER NOT NULL,
		numberOfAnimalSpecies INTEGER NOT NULL
	 */
	
	public Park mapRowToPark(SqlRowSet results) {
		Park park = new Park();

		park.setParkCode(results.getString("parkCode"));
		park.setParkName(results.getString("parkName"));
		park.setState(results.getString("state"));
		park.setParkCode(results.getString("parkCode"));
		park.setAcreage(results.getInt("acreage"));
		park.setElevationInFeet(results.getInt("elevationInFeet"));
		park.setMilesOfTrail(results.getDouble("milesOfTrail"));
		park.setNumberOfCampsites(results.getInt("numberOfCampsites"));
		park.setClimate(results.getString("climate"));
		park.setYearFounded(results.getInt("yearFounded"));
		park.setInspirationalQuote(results.getString("inspirationalQuote"));
		park.setInspirationalQuoteSource(results.getString("inspirationalQuoteSource"));
		park.setParkDescription(results.getString("parkDescription"));
		park.setEntryFee(results.getInt("entryFee"));
		park.setNumberOfAnimalSpecies(results.getInt("numberOfAnimalSpecies"));
		
		return park;
	}
}
