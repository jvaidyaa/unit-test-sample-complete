package com.aol.demo.dao;

import com.aol.demo.model.profile.CpsProfile;

public interface CpsDao {
	CpsProfile getCpsData(String screenName);
}
