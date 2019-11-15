package com.techelevator.npgeek.model;

public class Park {

	private String parkCode;
	private String parkName;
	private String state;
	private int acreage;
	private int elevationInFeet;
	private double milesOfTrail;
	private int numberOfCampsites;
	private String climate;
	private int yearFounded;
	private int annualVisitorCount;
	private String inspirationalQuote;
	private String inspirationalQuoteSource;
	private String parkDescription;
	private int entryFee;
	private int numberOfAnimalSpecies;

	public String getParkCode() {
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	public String getParkName() {
		return parkName;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getAcreage() {
		return acreage;
	}

	public void setAcreage(int acreage) {
		this.acreage = acreage;
	}

	public int getElevationInFeet() {
		return elevationInFeet;
	}

	public void setElevationInFeet(int elevationInFeet) {
		this.elevationInFeet = elevationInFeet;
	}

	public double getMilesOfTrail() {
		return milesOfTrail;
	}

	public void setMilesOfTrail(double milesOfTrail) {
		this.milesOfTrail = milesOfTrail;
	}

	public int getNumberOfCampsites() {
		return numberOfCampsites;
	}

	public void setNumberOfCampsites(int numberOfCampsites) {
		this.numberOfCampsites = numberOfCampsites;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public int getYearFounded() {
		return yearFounded;
	}

	public void setYearFounded(int yearFounded) {
		this.yearFounded = yearFounded;
	}

	public int getAnnualVisitorCount() {
		return annualVisitorCount;
	}

	public void setAnnualVisitorCount(int annualVisitorCount) {
		this.annualVisitorCount = annualVisitorCount;
	}

	public String getInspirationalQuote() {
		return inspirationalQuote;
	}

	public void setInspirationalQuote(String inspirationalQuote) {
		this.inspirationalQuote = inspirationalQuote;
	}

	public String getInspirationalQuoteSource() {
		return inspirationalQuoteSource;
	}

	public void setInspirationalQuoteSource(String inspirationalQuoteSource) {
		this.inspirationalQuoteSource = inspirationalQuoteSource;
	}

	public String getParkDescription() {
		return parkDescription;
	}

	public void setParkDescription(String parkDescription) {
		this.parkDescription = parkDescription;
	}

	public int getEntryFee() {
		return entryFee;
	}

	public void setEntryFee(int entryFee) {
		this.entryFee = entryFee;
	}

	public int getNumberOfAnimalSpecies() {
		return numberOfAnimalSpecies;
	}

	public void setNumberOfAnimalSpecies(int numberOfAnimalSpecies) {
		this.numberOfAnimalSpecies = numberOfAnimalSpecies;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Park)) {
			return false;
		}
		Park test = (Park) o;

		if (this.getAcreage() != test.getAcreage()) {
			return false;
		}
		if (this.getAnnualVisitorCount() != test.getAnnualVisitorCount()) {
			return false;
		}
		if (!this.getClimate().equals(test.getClimate())) {
			return false;
		}
		if (this.getElevationInFeet() != test.getElevationInFeet()) {
			return false;
		}
		if (this.getEntryFee() != test.getEntryFee()) {
			return false;
		}
		if (!this.getInspirationalQuote().equals(test.getInspirationalQuote())) {
			return false;
		}
		if (!this.getInspirationalQuoteSource().equals(test.getInspirationalQuoteSource())) {
			return false;
		}
		if (this.getMilesOfTrail() != test.getMilesOfTrail()) {
			return false;
		}
		if (this.getNumberOfAnimalSpecies() != test.getNumberOfAnimalSpecies()) {
			return false;
		}
		if (this.getNumberOfCampsites() != test.getNumberOfCampsites()) {
			return false;
		}
		if (!this.getParkCode().equals(test.getParkCode())) {
			return false;
		}
		if (!this.getParkDescription().equals(test.getParkDescription())) {
			return false;
		}
		if (!this.getParkName().equals(test.getParkName())) {
			return false;
		}
		if (!this.getState().equals(test.getState())) {
			return false;
		}
		if (this.getYearFounded() != test.getYearFounded()) {
			return false;
		}

		return true;
	}

}
