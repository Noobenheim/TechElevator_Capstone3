package com.techelevator.npgeek;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.model.ForecastDAO;
import com.techelevator.npgeek.model.ParkDAO;

@Controller
public class NpGeekController {
	
	@Autowired
	private ParkDAO parkDAO;
	
	@Autowired
	private ForecastDAO forecastDAO;
	
	@Autowired
	private SurveyDAO surveyDAO;
	
	@RequestMapping("/") 
	public String displayHomePage(ModelMap map){
		
		map.put("parks", parkDAO.getAllParks());
		
		return "homepage"; 
	}

	@GetMapping("/details/{code}")
	public String displayDetailsPage(@RequestParam(required=false) String unit, @PathVariable String code, ModelMap map, HttpSession session) {
		if( session.getAttribute("tempInF") == null && unit == null ) {
			session.setAttribute("tempInF", true);
		}
		if( unit != null && (unit.toLowerCase().equals("celsius") || unit.toLowerCase().equals("fahrenheit")) ) {
			session.setAttribute("tempInF", unit.toLowerCase().equals("fahrenheit"));
		} else if( unit != null ) {
			session.setAttribute("tempInF", true);
		}
		
		map.put("park", parkDAO.getParkByParkCode(code));
		map.put("forecasts", forecastDAO.getForecastByParkCode(code));
		boolean tempInF = (boolean)session.getAttribute("tempInF");
		map.put("temperatureUnit", tempInF ? "F" : "C");
		map.put("oppositeTemperature", tempInF ? "Celsius" : "Fahrenheit");
		
		return "details";
	}
	
	@RequestMapping("/survey")
	public String displaySurveyForm() {
		return "surveyForm";
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.POST)
	public String submitSurvey(@Valid @ModelAttribute("survey") Survey survey,
							   BindingResult result, 
							   RedirectAttributes flashScope) {
		if( result.hasErrors() ) {
			flashScope.addFlashAttribute("survey", survey);
			flashScope.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX+"survey", result);
			
			return "redirect:/survey";
		}
		
		
	}
	
	@RequestMapping("/favoriteParks")
	public String displayFavoriteParks() {
		return "favoriteParks";
	}
}
