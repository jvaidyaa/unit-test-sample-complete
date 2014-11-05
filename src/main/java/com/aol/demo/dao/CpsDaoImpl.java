package com.aol.demo.dao;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aol.demo.model.CpsProfile;

@Service
public class CpsDaoImpl implements CpsDao {

	@Value("${cps.endpoint}")
	private String cpsEndpoint;

	@Value("${cps.sourceId:53}")
	private String sourceId;

	@Value("${cps.view:infor}")
	private String view;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public CpsProfile getCpsData(final String screenName) {
		final String cpsUrl = getCpsUrl(screenName);
		return restTemplate.getForObject(cpsUrl, CpsProfile.class);
	}


	private String getCpsUrl(final String screenName) {
		String keyName = NumberUtils.toLong(screenName)==0 ? "screenName" : "subAccountNumber";
		return String.format("%s/profile?sourceId=%s&view=%s&%s=%s", 
				cpsEndpoint, sourceId, view, 
				keyName, screenName);
	}

}
