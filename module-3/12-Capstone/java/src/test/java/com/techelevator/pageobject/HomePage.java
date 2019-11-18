package com.techelevator.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends Page {
	public HomePage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public List<WebElement> getParkListElement() {
		return webDriver.findElements(By.cssSelector("div.park-list > a"));
	}
	
	public DetailsPage goToParkDetails(String parkName) {
		List<WebElement> elements = webDriver.findElements(By.className("park-name"));
		for( WebElement element : elements ) {
			if( element.getText().equals(parkName) ) {
				element.click();
				return new DetailsPage(webDriver);
			}
		}
		return null;
	}
}
