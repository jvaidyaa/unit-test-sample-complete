package com.aol.demo.model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aol.demo.model.IaOffersResponse;

public class IaOffersResponseTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(IaOffersResponseTest.class);
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testParseIAResponse() {
		IaOffersResponse response = new IaOffersResponse("Id|Name|15|webmail_lb_careOfferDisplayType|4|HeroAolOfferId|6|IA_662ContentId|15|webmail_lb_care");
		List<String> productIds = response.getContentIds();
		LOGGER.debug("Content Ids : {}", productIds);
		assertNotNull(productIds);
	}

	
	@Test
	public void testParseIAResponseMulti() {
		IaOffersResponse response = new IaOffersResponse("Id|Name|27|gandalf_adoption_afterstepsLikelihood|1|0AolOfferId|6|IA_490ServerId|12|%%SERVERID%%ContentId|25|infor-cc-adopt-afterstepsScaledScore|2|48Benefit|2|23Id|Name|29|gandalf_adoption_aol_onepointLikelihood|1|0AolOfferId|6|IA_491ServerId|12|%%SERVERID%%ContentId|23|infor-cc-adopt-onepointScaledScore|2|39Benefit|2|21Id|Name|22|gandalf_ls_safecentralLikelihood|1|0AolOfferId|6|IA_483ServerId|12|%%SERVERID%%ContentId|23|infor-cc-ls-safecentralScaledScore|1|1Benefit|2|11DestinationPI|7|1003185");
		List<String> productIds = response.getContentIds();
		LOGGER.debug("Content Ids : {}", productIds);
		assertNotNull(productIds);
	}

}
