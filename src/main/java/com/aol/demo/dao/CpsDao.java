package com.aol.demo.dao;

import com.aol.demo.model.CpsProfile;

public interface CpsDao {
	CpsProfile getCpsData(String screenName);
}
