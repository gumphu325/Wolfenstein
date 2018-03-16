package com.springmvc.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.springmvc.model.Voter;
import com.springmvc.repository.VoterDao;

@Service
public class VoterRegistrationServiceImpl implements VoterRegistrationService {
	private static final Logger logger = Logger.getLogger(VoterRegistrationServiceImpl.class);
	
	@Autowired
	private VoterDao voterDao;

	@Override
	public List<Voter> readAll() {
		return voterDao.readAll(Voter.class);
	}
	
	@Override
	public void registerVoter(Voter voter) {
		voterDao.create(voter);
	}

	@Override
	public Voter readVoter(String name) {
		Query query = new Query(Criteria.where("voterName").is(name));
		Voter voter = voterDao.read(query, Voter.class);
		logger.debug("The Voter details are " + voter.toString());
		return voter;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Voter> readVoter(Voter voter) {
		Query query = new Query(Criteria.where("voterName").is(voter.getVoterName()));
		query.addCriteria(Criteria.where("emailId").is(voter.getEmailId()));
		query.addCriteria(Criteria.where("address.pincode").is(voter.getAddress().getPincode()));
		return (List<Voter>) voterDao.read(query, Voter.class);
	}
}
