package com.techelevator.pageobject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DetailsPage extends Page {

	public DetailsPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public DetailsPage switchTemperatureUnits() {
		webDriver.findElement(By.cssSelector("label.switch")).click();
		
		return new DetailsPage(webDriver);
	}

	public String getPageHeadingText() {
		return getTextByCSS(".park-name .value");
	}
	public String getState() {
		return getTextByCSS(".park-state .value");
	}
	public String getAcreage() {
		return getTextByCSS(".park-acreage .value");
	}
	public String getElevation() {
		return getTextByCSS(".park-elevation .value");
	}
	public String getMiles() {
		return getTextByCSS(".park-miles .value");
	}
	public String getCampsites() {
		return getTextByCSS(".park-campsites .value");
	}
	public String getClimate() {
		return getTextByCSS(".park-climate .value");
	}
	public String getYear() {
		return getTextByCSS(".park-year .value");
	}
	public String getVisitors() {
		return getTextByCSS(".park-visitors .value");
	}
	public String getEntry() {
		return getTextByCSS(".park-entry .value");
	}
	public String getAnimals() {
		return getTextByCSS(".park-animals .value");
	}
	public String getQuote() {
		return getTextByCSS(".park-quote .value");
	}
	public String getQuoteSource() {
		return getTextByCSS(".park-quote-source");
	}
	public String getDescription() {
		return getTextByCSS(".park-description .value");
	}
	public List<Forecast> getForecasts() {
		List<Forecast> forecasts = new ArrayList<>();
		
		List<WebElement> divs = webDriver.findElements(By.cssSelector(".five-day-forecast > div"));
		for( int i=1; i<divs.size(); i+=2 ) { // 1 to skip the unit switch
			Forecast forecast = new Forecast();
			
			WebElement forecastElement = divs.get(i);
			List<WebElement> advisoryElements = divs.get(i+1).findElements(By.className("forecast-advisory"));
			
			forecast.setImageUrl(forecastElement.findElement(By.cssSelector(".weather-image img")).getAttribute("src"));
			forecast.setHigh(forecastElement.findElement(By.className("forecast-high")).getText());
			forecast.setLow(forecastElement.findElement(By.className("forecast-low")).getText());
			
			if( advisoryElements != null && advisoryElements.size() > 0 ) {
				for( WebElement advisory : advisoryElements ) {
					forecast.addAdvisory(advisory.getText());
				}
			}
			
			forecasts.add(forecast);
		}
		
		return forecasts;
	}
	
	private String getTextByCSS(String css) {
		return webDriver.findElement(By.cssSelector(css)).getText().trim();
	}
	
	public class Forecast {
		private String imageUrl;
		private String high;
		private String low;
		private List<String> advisories = new ArrayList<>();
		
		public String getImageUrl() {
			return imageUrl;
		}
		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}
		public String getHigh() {
			return high;
		}
		public void setHigh(String high) {
			this.high = high;
		}
		public String getLow() {
			return low;
		}
		public void setLow(String low) {
			this.low = low;
		}
		public List<String> getAdvisories() {
			return advisories;
		}
		public void addAdvisory(String advisory) {
			advisories.add(advisory);
		}
	}
}
