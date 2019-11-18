package com.techelevator;

import java.text.DecimalFormat;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.techelevator.npgeek.model.Forecast;
import com.techelevator.npgeek.model.ForecastDAO;
import com.techelevator.npgeek.model.JDBCForecastDAO;
import com.techelevator.npgeek.model.JDBCParkDAO;
import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.ParkDAO;
import com.techelevator.pageobject.DetailsPage;

public class DetailsPageSeleniumTest extends SeleniumTest {
	ParkDAO parkDAO = new JDBCParkDAO(dataSource);
	ForecastDAO forecastDAO = new JDBCForecastDAO(dataSource);
	
	@Test
	public void test_details_on_details_pages() {
		List<Park> parks = parkDAO.getAllParks();
		
		for( Park park : parks ) {
			List<Forecast> parkForecasts = forecastDAO.getForecastByParkCode(park.getParkCode());
			
			DetailsPage detailsPage = homePage.goToParkDetails(park.getParkName());
			Assert.assertEquals(park.getParkName().trim(), detailsPage.getPageHeadingText());
			
			Assert.assertEquals(park.getState().trim(), detailsPage.getState());
			Assert.assertEquals(format(park.getAcreage()), detailsPage.getAcreage());
			Assert.assertEquals(format(park.getElevationInFeet()), detailsPage.getElevation());
			Assert.assertEquals(format(park.getMilesOfTrail(), "#,###.0"), detailsPage.getMiles());
			Assert.assertEquals(format(park.getNumberOfCampsites()), detailsPage.getCampsites());
			Assert.assertEquals(park.getClimate().trim(), detailsPage.getClimate());
			Assert.assertEquals(Integer.toString(park.getYearFounded()), detailsPage.getYear());
			Assert.assertEquals(format(park.getAnnualVisitorCount()), detailsPage.getVisitors());
			Assert.assertEquals(format(park.getEntryFee()), detailsPage.getEntry());
			Assert.assertEquals(format(park.getNumberOfAnimalSpecies()), detailsPage.getAnimals());
			
			Assert.assertEquals(park.getInspirationalQuote().trim(), detailsPage.getQuote());
			Assert.assertEquals(park.getInspirationalQuoteSource().trim(), detailsPage.getQuoteSource());
			
			Assert.assertEquals(park.getParkDescription().trim(), detailsPage.getDescription());
			
			checkTemps(parkForecasts, detailsPage.getForecasts(), true);
			// change to celsius
			detailsPage = detailsPage.switchTemperatureUnits();
			checkTemps(parkForecasts, detailsPage.getForecasts(), false);
			// go home and make sure it's still celsius
			homePage = detailsPage.clickHomePageLink();
			detailsPage = homePage.goToParkDetails(park.getParkName());
			checkTemps(parkForecasts, detailsPage.getForecasts(), false);
			// change to fahrenheit
			detailsPage = detailsPage.switchTemperatureUnits();
			checkTemps(parkForecasts, detailsPage.getForecasts(), true);
			
			detailsPage.clickHomePageLink();
		}
	}
	public void checkTemps(List<Forecast> parkForecasts, List<DetailsPage.Forecast> detailsForecast, boolean fahrenheit) {
		Assert.assertEquals(5, parkForecasts.size());
		Assert.assertEquals(5, detailsForecast.size());
		
		final String degF = "°F";
		final String degC = "°C";
		
		String deg = fahrenheit?degF:degC;
		
		for( int i=0; i<parkForecasts.size(); i++ ) {
			Forecast forecast = parkForecasts.get(i);
			int high = fahrenheit?forecast.getHigh():forecast.getHighInCelsius();
			int low = fahrenheit?forecast.getLow():forecast.getLowInCelsius();
			
			String parkHigh = high+" "+deg;
			String parkLow = low+" "+deg;
			
			Assert.assertEquals(parkHigh, detailsForecast.get(i).getHigh());
			Assert.assertEquals(parkLow, detailsForecast.get(i).getLow());
			
			Assert.assertEquals(parkForecasts.get(i).getAdvisories().length, detailsForecast.get(i).getAdvisories().size());
			
			for( int j=0; j<parkForecasts.get(i).getAdvisories().length; j++ ) {
				Assert.assertEquals(parkForecasts.get(i).getAdvisories()[j], detailsForecast.get(i).getAdvisories().get(j));
			}
		}
	}
	
	public String format(Object obj) {
		return format(obj, "#,###");
	}
	public String format(Object obj, String format) {
		DecimalFormat formatter = new DecimalFormat(format);
		return formatter.format(obj);
	}
}
