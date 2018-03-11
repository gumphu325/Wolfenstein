package com.springmvc.common;

import java.net.UnknownHostException;

import org.apache.log4j.Logger;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public final class DatabaseUtils {
	private static DB instance = null;
	private Logger logger = Logger.getLogger(DatabaseUtils.class);

	protected DatabaseUtils() {
		// To prevent instantiation.
	}

	public DB getInstance() {
		if (instance == null) {
			instance = getDatabaseInstance();
		}
		return instance;

	}

	private DB getDatabaseInstance() {
		DB db = null;
		try {
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			db = mongoClient.getDB("voter_database");
		} catch (UnknownHostException e) {
			logger.error("Failed to initialize database connection " + e.getMessage(), e);
		}
		return db;
	}

}
