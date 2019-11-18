package com.techelevator.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;

public class FavoritesPage extends Page {

	public FavoritesPage(WebDriver webDriver) {
		super(webDriver);
	}

	public String getFavoriteCount() { 
		return webDriver.findElement(By.cssSelector("/html/body/section/div/div[15]")).getText().trim(); 
	}

	public String getFavoriteParkName() {
		return webDriver.findElement(By.cssSelector("/html/body/section/div/div[14]")).getText().trim();
	}

}
