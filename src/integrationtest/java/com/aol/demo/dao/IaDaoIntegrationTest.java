package com.aol.demo.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aol.demo.model.OfferRequest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={IaDaoIntegrationTestConfig.class})
@ActiveProfiles("integrationtesting")
public class IaDaoIntegrationTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(IaDaoIntegrationTest.class);
	private String customerData = "{\"isAuthenticated\":true,\"daysSinceQSDownload\":-1,\"onsType\":\"0\",\"freeMonths\":0,\"snType\":\"M\",\"isMFAccount\":true,\"isPendingCancel\":false,\"pmi\":4,\"subs\":{\"subpsw174\":[]},\"osb\":0,\"acctStatus\":\"Active\",\"masterSN\":\"subpsw174\",\"daysSinceMakeAOLMyHomePage\":-1,\"careStatus\":249,\"bid\":1,\"brandi\":265,\"zip\":\"35758\",\"sid\":2,\"sn\":\"subpsw174\",\"subAccountNumber\":565354693,\"categoryId\":50,\"masterAccountNumber\":565354693,\"isFreePI\":false,\"daysSinceFirstMobileIMAPLogin\":-1,\"affinity\":0,\"onsBrandi\":\"265\",\"guid\":\"subpsw174\",\"pendingPI\":0,\"monthlyFee\":2590,\"snList\":[\"subpsw174\"],\"email\":\"subpsw174@aol.com\",\"onsBid\":\"1\",\"tenure\":1046453778000,\"pi\":72,\"daysSinceFirstWin8IMAPLogin\":-1}";

	@Autowired
	private IaDao iaDao;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetOffers() {
		String offers = iaDao.getOffers(createIaRequest());
		LOGGER.info("Offers: '{}'", offers);
		assertNotNull(offers);
	}

	public OfferRequest createIaRequest() {
		OfferRequest request = new OfferRequest();
		request.setPackageName("AOL_V1");
		request.setEvent("GetOffers");
		request.setSessionId("subpsw174");
		request.setChannelId("Webmail");
		request.setRequestData("{\"pageContext\":\"webmail_lb.jsp\"}");
		request.setOfferContext("{}");
		request.setCustomerData(customerData);

		return request;
	}


}
