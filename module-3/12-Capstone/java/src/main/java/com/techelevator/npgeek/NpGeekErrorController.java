package com.techelevator.npgeek;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NpGeekErrorController {
	@RequestMapping(value="/error", method=RequestMethod.GET)
	public String errorHandler(HttpServletRequest httpRequest) {
		int code = (int)httpRequest.getAttribute("javax.servlet.error.status_code");
		
		switch( code ) {
			case 404: // not found
				return "error/404";
		}
		
		return "error/default";
	}
}
