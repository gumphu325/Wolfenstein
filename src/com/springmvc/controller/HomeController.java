package com.springmvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.model.Voter;
import com.springmvc.service.VoterRegistrationService;

@Controller
public class HomeController {
	private Logger logger = Logger.getLogger(HomeController.class);
	
	@Autowired
	VoterRegistrationService registrationService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String create(Locale locale, Model model) {
		logger.info("Home Page Requested, locale = " + locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		return "home";
	}
	
	@RequestMapping(value = "/voter", method = RequestMethod.POST, params="Search")
	public String search(@Validated Voter voter, Model model, HttpServletRequest request) {
		List<Voter> voterList = registrationService.readVoter(voter);
		model.addAttribute("voterList", voterList);
		return "searchResult";
	}

	@RequestMapping(value = "/voter", method = RequestMethod.POST, params="Login")
	public String user(@Validated Voter voter, Model model,@RequestParam HttpServletRequest servletRequest) {
		logger.info("User Page Requested");
		String action = servletRequest.getParameter("action");
		if (action.equalsIgnoreCase("Search")) {
			logger.debug("Search");
		} else {
			logger.debug("Register");
		}
		try {
		model.addAttribute("voterName", voter.getVoterName());
		registrationService.registerVoter(voter);
		registrationService.readVoter(voter.getVoterName());
		List<Voter> voterList = registrationService.readAll();
		voterList.stream().forEach(e -> logger.debug("The entry is " + e.toString()));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return "error";
		}
		return "confirmation";
	}
}
