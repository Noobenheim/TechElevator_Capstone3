package com.techelevator.npgeek.model;

import java.util.List;

public interface ForcecastDAO {

	public List<Forecast> getForecastByParkCode(String parkCode); 
}
