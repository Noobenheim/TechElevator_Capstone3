package com.techelevator.npgeek.model;

import java.util.List;

public interface SurveyDAO {
	public List<SurveySummary> getSurveySummary();
	public Survey createSurveyResponse(Survey newSurvey); 

}
