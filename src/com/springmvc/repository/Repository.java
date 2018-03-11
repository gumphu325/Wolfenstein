package com.springmvc.repository;

public interface Repository {

	<T> T create(T entity);

	<T> T uodate(T entity);

	<T> T read(String key);

	void delete(String key);

}
