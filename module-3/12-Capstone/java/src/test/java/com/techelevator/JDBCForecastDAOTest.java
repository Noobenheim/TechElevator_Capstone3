package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.techelevator.npgeek.model.Forecast;
import com.techelevator.npgeek.model.ForecastDAO;
import com.techelevator.npgeek.model.JDBCForecastDAO;

public class JDBCForecastDAOTest extends DAOIntegrationTest {
	
	private ForecastDAO dao = new JDBCForecastDAO(dataSource);
	
	@Test
	public void return_forecasts_by_park_code() {
		Forecast fakeForecast = createFakeForecast("GNP", 6, 0, 34, "cold"); 
		List<Forecast> fetchedForecast = dao.getForecastByParkCode(fakeForecast.getParkCode());
		assertEquals(6, fetchedForecast.size());
		assertEquals("GNP", fetchedForecast.get(0).getParkCode());
	}
	
	private Forecast createFakeForecast(String parkCode, int fiveDayForecastValue, int low, int high, String forecast) {

		Forecast fakeForecast = new Forecast();

		fakeForecast.setParkCode(parkCode);
		fakeForecast.setFiveDayForecastValue(fiveDayForecastValue);
		fakeForecast.setLow(low);
		fakeForecast.setHigh(high);
		fakeForecast.setForecast(forecast);

		String sqlInsertForecast = "INSERT INTO weather VALUES (?, ?, ?, ?, ?)";
		int numberOfNewParksInserted = jdbc.update(sqlInsertForecast, parkCode, fiveDayForecastValue, low, high, forecast);
		
		return fakeForecast;
	}

}
