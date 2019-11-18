package com.techelevator.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Page {
	protected WebDriver webDriver;
	
	public Page(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public String getTitle() {
		return webDriver.getTitle();
	}
	public String getCurrentURL() {
		return webDriver.getCurrentUrl();
	}
	
	// header should be on all pages
	public SurveyPage clickSurveyLink() {
		WebElement surveyLink = webDriver.findElement(By.linkText("Survey"));
		surveyLink.click();
		return new SurveyPage(webDriver);
	}
	public HomePage clickHomePageLink() {
		WebElement homeLink = webDriver.findElement(By.linkText("Home"));
		homeLink.click();
		return new HomePage(webDriver);
	}
}