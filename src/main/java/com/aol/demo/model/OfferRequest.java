package com.aol.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class OfferRequest {
	@JsonProperty("Package")
	private String packageName = "AOL_V1";
	
	@JsonProperty("Event")
	private String event = "GetOffers";
	
	@JsonProperty("SessionId")
	private String sessionId;
	
	@JsonProperty("ChannelId")
	private String channelId;

	@JsonProperty("RequestData")
	private String requestData;
	
	@JsonProperty("OfferContext")
	private String offerContext;
	
	@JsonProperty("CustomerData")
	private String customerData;
	
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public String getRequestData() {
		return requestData;
	}
	public void setRequestData(String requestData) {
		this.requestData = requestData;
	}
	public String getOfferContext() {
		return offerContext;
	}
	public void setOfferContext(String offerContext) {
		this.offerContext = offerContext;
	}
	public String getCustomerData() {
		return customerData;
	}
	public void setCustomerData(String customerData) {
		this.customerData = customerData;
	}
}
