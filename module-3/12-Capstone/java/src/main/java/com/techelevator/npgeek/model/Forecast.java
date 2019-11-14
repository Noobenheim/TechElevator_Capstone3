package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

public class Forecast {
	public enum Weather {
		SNOW("snow", "snow"),
		PARTLY_CLOUDY("partly cloudy", "partlyCloudy"),
		CLOUDY("cloudy", "cloudy"),
		RAIN("rain", "rain"),
		SUNNY("sunny", "sunny"),
		THUNDERSTORMS("thunderstorms", "thunderstorms");
		
		private String description;
		private String imageName;
		
		private Weather(String description, String imageName) {
			this.description = description;
			this.imageName = imageName;
		}
		
		public static Weather getWeatherByDescription(String description) {
			if( description == null ) {
				return null;
			}
			for( Weather weather : Weather.values() ) {
				if( weather.description.toLowerCase().equals(description.toLowerCase()) ) {
					return weather;
				}
			}
			return null;
		}
		public String getDescription() {
			return this.description;
		}
		public String getImageName() {
			return this.imageName;
		}
	}
	
	private String parkCode;
	private int fiveDayForecastValue;
	private int low;
	private int high;
	private String forecast;
	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public int getFiveDayForecastValue() {
		return fiveDayForecastValue;
	}
	public void setFiveDayForecastValue(int fiveDayForecastValue) {
		this.fiveDayForecastValue = fiveDayForecastValue;
	}
	public int getLow() {
		return low;
	}
	public int getLowInCelsius() {
		return Forecast.convertFahrenheitToCelsius(getLow());
	}
	public void setLow(int low) {
		this.low = low;
	}
	public int getHigh() {
		return high;
	}
	public int getHighInCelsius() {
		return Forecast.convertFahrenheitToCelsius(getHigh());
	}
	public void setHigh(int high) {
		this.high = high;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	public String getImageName() {
		Weather weather = Weather.getWeatherByDescription(forecast);
		if( weather == null ) {
			return "";
		}
		return weather.getImageName();
	}
	
	public static int convertFahrenheitToCelsius(int temp) {
		return (int)((temp * 9.0 / 5.0) + 32.0);
	}
	
	public static String[] getAdvisory(Weather weather, int highF, int lowF) {
		if( weather == null ) {
			return new String[] {};
		}
		List<String> advisories = new ArrayList<>();
		
		if( weather == Weather.SNOW ) {
			advisories.add("Pack Snowshoes");
		}
		if( weather == Weather.RAIN ) {
			advisories.add("Pack Rain Gear and Wear Waterproof Shoes");
		}
		if( weather == Weather.THUNDERSTORMS ) {
			advisories.add("Seek Shelter and Avoid Hiking on Exposed Ridges");
		}
		if( weather == Weather.SUNNY ) {
			advisories.add("Pack Sunblock");
		}
		
		if( highF > 75 ) {
			advisories.add("Bring an Extra Gallon of Water");
		}
		if( highF - lowF > 20 ) {
			advisories.add("Wear Breathable Layers");
		}
		if( lowF < 20 ) {
			advisories.add("Beware of the Dangers of Exposure to Frigid Temperatures");
		}
		
		return advisories.toArray(new String[advisories.size()]);
	}
	public String[] getAdvisory() {
		return Forecast.getAdvisory(Weather.getWeatherByDescription(this.forecast), this.high, this.low);
	}
}
