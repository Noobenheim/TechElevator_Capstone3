package com.techelevator.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FavoritesPage extends Page {

	public FavoritesPage(WebDriver webDriver) {
		super(webDriver);
	}

	public int getFavoriteCount(String parkName) {
		List<WebElement> parks = webDriver.findElements(By.cssSelector(".favorite-parks > div"));
		
		for( int i=3; i<parks.size(); i+=3 ) { // 3 to skip the header
			String park = parks.get(i+1).getText().trim();
			if( park.equals(parkName) ) {
				String[] voteSplit = parks.get(i+2).getText().trim().split(" ");
				return Integer.parseInt(voteSplit[0]);
			}
		}
		return 0; 
	}
}
