package com.techelevator.npgeek.model;

import java.util.List;

public interface ForecastDAO {

	public List<Forecast> getForecastByParkCode(String parkCode); 
}
