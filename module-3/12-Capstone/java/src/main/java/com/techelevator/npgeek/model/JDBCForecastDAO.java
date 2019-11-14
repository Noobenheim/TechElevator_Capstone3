package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCForecastDAO implements ForcecastDAO {
	private JdbcTemplate jdbcTemplate; 
	
	@Autowired
	public public JDBCForecastDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}
	
	@Override
	public List<Forecast> getForecastByParkCode(String parkCode) {
		parkCode = parkCode.toUpperCase(); 
		
		List<Forecast> forecasts = new ArrayList<E>();
		String sqlQuery = "SELECT parkcode, fivedayforecastvalue, low, high, forecast " +
						  "FROM weather WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQuery, parkCode);
		
		while (results.next()) {
			Forecast forecast = mapRowToForecast(results);
			forecasts.add(forecast); 
		}
		return forecasts;
	}
	
	private Forecast mapRowToForecast(SqlRowSet results) {
		Forecast forecast = new Forecast(); 
		
		forecast.setParkCode(results.getString("parkcode"));
		forecast.setFiveDayForecastValue(results.getInt("fivedayforecastvalue"));
		forecast.setLow(results.getInt("low"));
		forecast.setHigh(results.getInt("high"));
		forecast.setForecast(results.getString("forecast"));
		
		return forecast; 
	}

}
