package com.techelevator.npgeek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techelevator.npgeek.model.ParkDAO;

@Controller
public class NpGeekController {
	
	@Autowired
	private ParkDAO parkDAO; 
	
	@RequestMapping("/") 
	public String displayHomePage(ModelMap map){
		
		map.put("parks", parkDAO.getAllParks());
		
		return "homepage"; 
	}

	@GetMapping("/details/{code}")
	public String displayDetailsPage(@PathVariable String code, ModelMap map) {
		
		map.put("park", parkDAO.getParkByParkCode(code));
		
		return "details";
	}
}
