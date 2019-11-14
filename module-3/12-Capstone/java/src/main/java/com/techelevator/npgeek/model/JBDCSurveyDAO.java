package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JBDCSurveyDAO implements SurveyDAO{

	private JdbcTemplate jdbcTemplate; 
	
	@Autowired
	public JBDCSurveyDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}

	@Override
	public List<SurveySummary> getSurveySummary() {
		List<SurveySummary> surveyResponses = new ArrayList<>(); 
		String sqlQuery = "SELECT park.parkcode, park.parkname, COUNT(*) AS numberOfSurveys " + 
						  "FROM survey_result" + 
						  "INNER JOIN park USING(parkcode) " + 
						  "GROUP BY park.parkcode " + 
						  "ORDER BY numberOfSurveys DESC, park.parkname"; 
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery); 
		
		while (results.next()) {
			SurveySummary surveySummary = mapRowToSurveySummary(results); 
			surveyResponses.add(surveySummary);	
		}
			
		return surveyResponses;
	}

	@Override
	public Survey createSurveyResponse(Survey survey) {
		String sqlQuery = "INSERT INTO survey_result " +
						  "VALUES (DEFAULT, ?, ?, ?, ?) " +
						  "RETURNING surveyid";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, survey.getParkCode(), survey.getEmailAddress(), 
							survey.getState(), survey.getActivityLevel()); 
		
		if (results.next()) {
			Long surveyId = results.getLong("surveyid"); 
			survey.setSurveyId(surveyId);
		}
		
		return survey;
	}
	
	private SurveySummary mapRowToSurveySummary(SqlRowSet results) {
		Park park = new Park(); 
		SurveySummary surveySummary = new SurveySummary();
		
		park.setParkCode(results.getString("parkcode"));
		park.setParkName(results.getString("parkname"));
		
		surveySummary.setPark(park);
		surveySummary.setCount(results.getInt("numberOfSurveys"));
		
		return surveySummary; 
	
	}
	
}
