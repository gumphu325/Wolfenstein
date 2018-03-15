package com.springmvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.model.Voter;
import com.springmvc.service.VoterRegistrationService;

@Controller
public class HomeController {
	private Logger logger = Logger.getLogger(HomeController.class);
	
	@Autowired
	VoterRegistrationService registrationService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Home Page Requested, locale = " + locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		return "home";
	}

	@RequestMapping(value = "/voter", method = RequestMethod.POST)
	public String user(@Validated Voter voter, Model model) {
		logger.info("User Page Requested");
		model.addAttribute("userName", voter.getVoterName());
		registrationService.registerVoter(voter);
		registrationService.readVoter(voter.getVoterName());
		registrationService.readAll().stream().forEach(e -> logger.debug("The entry is " + e.toString()));
		return "voter";
	}

}
