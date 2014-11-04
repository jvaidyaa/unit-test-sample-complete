package com.aol.demo.dao;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

import com.aol.demo.model.OfferRequest;

@Service
public class IaDaoImpl implements IaDao {
	
	@Value("${ia.endpoint}")
	private String iaEndpoint;
	
	@Autowired
	private RestOperations restOperations;
	
	@Override
	public String getOffers(OfferRequest request) {
		URI uri = getUri(iaEndpoint, request);
		return restOperations.getForObject(uri, String.class);
	}

	//Id|Name|15|webmail_lb_careOfferDisplayType|4|HeroAolOfferId|6|IA_662ContentId|15|webmail_lb_care
	
	public URI getUri(String endpoint, OfferRequest request) {
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(endpoint);
		builder.queryParam("Package", request.getPackageName());
		builder.queryParam("Event", request.getEvent());
		builder.queryParam("SessionId", request.getSessionId());
		addFieldValue(builder, "SessionId", request.getSessionId());
		addFieldValue(builder, "ChannelId", request.getChannelId());
		addFieldValue(builder, "RequestData", request.getRequestData());
		addFieldValue(builder, "CustomerData", request.getCustomerData());
		addFieldValue(builder, "OfferContext", request.getOfferContext());
		
		return builder.build().toUri();
	}

	public void addFieldValue(UriComponentsBuilder builder, String key, String value) {
		builder.queryParam("Field", key);
		builder.queryParam("Value", value);
	}
	

}
