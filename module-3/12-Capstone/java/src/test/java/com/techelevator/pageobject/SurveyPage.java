package com.techelevator.pageobject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SurveyPage extends Page {

	public SurveyPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public SurveyPage enterFavoriteNationalPark (String parkName) {
		Select parkNameElement = new Select(webDriver.findElement(By.xpath("//*[@id=\"parkCode\"]")));
		parkNameElement.selectByVisibleText(parkName);
		return this;
	}
	
	public SurveyPage enterEmail (String email) {
		WebElement emailElement = webDriver.findElement(By.xpath("//*[@id=\"emailAddress\"]")); 
		emailElement.sendKeys(email);
		return this;
	}
	
	public SurveyPage enterState (String state) {
		Select stateElement = new Select(webDriver.findElement(By.xpath("//*[@id=\"state\"]")));
		stateElement.selectByVisibleText(state);
		return this;
	}
	
	public SurveyPage enterActivityLevel (String activityLevel) {
		webDriver.findElement(By.xpath("//*[@id=\"survey\"]/div[4]/div/span[3]/label")).click();
		
		return this;
	}
	
	public FavoritesPage submitForm() {
		WebElement submitButton = webDriver.findElement(By.cssSelector("input[type=submit]"));
		submitButton.click();
		return new FavoritesPage(webDriver); 
	}
}
