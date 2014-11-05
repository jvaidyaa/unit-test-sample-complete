package com.aol.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.aol.demo.exceptions.IaException;

public class IaOffersResponse {

	private List<String> contentIds = new ArrayList<String>();

	private static final Pattern ERROR_PATTERN = Pattern.compile(
			"Command\\s*error:[^(]*",
			Pattern.DOTALL);
	
	private static final Pattern CAUSE_PATTERN = Pattern.compile(
			"caused\\s*by[^\\n]*",
			Pattern.DOTALL);
	
	public IaOffersResponse(String offers) {
		parseOffersString(offers);
	}

	public List<String> getContentIds() {
		return contentIds;
	}

	private void parseOffersString(String offers) {
		// Validate
		validate(offers);
		
		// Get the data
		contentIds = parseIAResponseToContentIds(offers);
	}

	private void validate(String offers) {
		// Do validation and throw exception if required
		String errorMessage = getMessage(ERROR_PATTERN, offers);
		if(StringUtils.isEmpty(errorMessage)) {
			return;
		}
		
		
		throw new IaException(errorMessage, getMessage(CAUSE_PATTERN, offers));
	}

	private String getMessage(Pattern pattern, String offers) {
		Matcher errorMatcher = pattern.matcher(offers);
		if(!errorMatcher.find()) {
			return "";
		}
		return errorMatcher.group();
	}

	private List<String> parseIAResponseToContentIds(String string) {
		List<String> offerIds = new ArrayList<String>();
	    for(String rec : string.substring(7).split("Id\\|Name")) {
	    	offerIds.add(getContentId(rec));
		}
	    
	    return offerIds;
	}

	// Name|15|webmail_lb_careOfferDisplayType|4|HeroAolOfferId|6|IA_662ContentId|15|webmail_lb_care	
	private String getContentId(String rec1) {
		String subStr = rec1.substring(rec1.indexOf("ContentId|"));
		String[] tokens = subStr.split("\\|");
		int length = Integer.parseInt(tokens[1]);
		return tokens[2].substring(0, length);
	}
	
}
