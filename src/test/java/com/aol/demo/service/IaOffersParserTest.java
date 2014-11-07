package com.aol.demo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aol.demo.exceptions.IaException;
import com.aol.demo.service.IaOffersParser;

public class IaOffersParserTest {

	public static final String iaResponseString = "Id|Name|15|webmail_lb_careOfferDisplayType|4|HeroAolOfferId|6|IA_662ContentId|15|webmail_lb_care";
	private static final Logger LOGGER = LoggerFactory.getLogger(IaOffersParserTest.class);
	private IaOffersParser iaOffersParser;
	
	@Before
	public void setUp() throws Exception {
		iaOffersParser = new IaOffersParser();
	}

	@Test
	public void testParseIAResponse() {
		List<String> productIds = iaOffersParser.toContentIds(iaResponseString);
		LOGGER.debug("Content Ids : {}", productIds);
		assertNotNull(productIds);
	}

	
	@Test
	public void testParseIAResponseMulti() {
		List<String> productIds = iaOffersParser.toContentIds("Id|Name|27|gandalf_adoption_afterstepsLikelihood|1|0AolOfferId|6|IA_490ServerId|12|%%SERVERID%%ContentId|25|infor-cc-adopt-afterstepsScaledScore|2|48Benefit|2|23Id|Name|29|gandalf_adoption_aol_onepointLikelihood|1|0AolOfferId|6|IA_491ServerId|12|%%SERVERID%%ContentId|23|infor-cc-adopt-onepointScaledScore|2|39Benefit|2|21Id|Name|22|gandalf_ls_safecentralLikelihood|1|0AolOfferId|6|IA_483ServerId|12|%%SERVERID%%ContentId|23|infor-cc-ls-safecentralScaledScore|1|1Benefit|2|11DestinationPI|7|1003185");
		LOGGER.debug("Content Ids : {}", productIds);
		assertNotNull(productIds);
	}

	@Test(expected=IaException.class)
	public void testParseIAResponseError() {
		iaOffersParser.validate("Command error: [01003] Command=CDmProcessEventCommand(Event=GetOffers,SessionId=subpsw174)  caused by Campaign error: [10413] Channel Webmai received from GetOffers is not valid");
	}

	@Test(expected=IaException.class)
	public void testParseIAResponseErrorAndCause() {
		try {
			iaOffersParser.validate("Command error: [01003] Command=CDmProcessEventCommand(Event=GetOffers,SessionId=subpsw174)  caused by Campaign error: [10413] Channel Webmai received from GetOffers is not valid");
		} catch (IaException ex) {
			assertNotNull(ex.getMessage());
			throw ex;
		}
	}
}
