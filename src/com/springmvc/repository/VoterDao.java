package com.springmvc.repository;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import com.springmvc.common.DatabaseUtils;

@org.springframework.stereotype.Repository
public class VoterDao implements Repository {

	@Override
	public <T> void create(T voter) {
		MongoOperations mongoOperations = DatabaseUtils.getInstance();
		mongoOperations.save(voter);
	}

	@Override
	public void delete(String key) {
	}

	@Override
	public <T> void update(T entity) {
	}

	@Override
	public <T> List<T> readAll(Class<T> entity) {
		MongoOperations mongoOperations = DatabaseUtils.getInstance();
		return mongoOperations.findAll(entity);
	}

	@Override
	public <T> void deleteAll(T entity) {
	}

	@Override
	public <T> T read(Query query, Class<T> entityClass) {
		MongoOperations mongoOperations = DatabaseUtils.getInstance();
		return (T) mongoOperations.findOne(query, entityClass);
	}

}
