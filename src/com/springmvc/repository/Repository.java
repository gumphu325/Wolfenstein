package com.springmvc.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

public interface Repository {

	<T> void create(T entity);

	<T> void update(T entity);
	
	<T> List<T> readAll(Class<T> entity);
	
	<T> T read(Query query, Class<T> entityClass);

	void delete(String key);
	
	<T> void deleteAll(T entity);

	
}
