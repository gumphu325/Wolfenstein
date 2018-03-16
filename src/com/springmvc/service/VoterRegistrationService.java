package com.springmvc.service;

import java.util.List;

import com.springmvc.model.Voter;

public interface VoterRegistrationService {

	List<Voter> readAll();

	void registerVoter(Voter voter);

	List<Voter> readVoter(Voter voter);
	
	Voter readVoter(String name);

}
