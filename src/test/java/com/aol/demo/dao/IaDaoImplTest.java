package com.aol.demo.dao;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.net.URI;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestOperations;

import com.aol.demo.model.OfferRequest;

public class IaDaoImplTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(IaDaoImplTest.class);
	
	private IaDaoImpl iaDaoImpl;
	private RestOperations restOperations;
	
	private String customerData = "{\"isAuthenticated\":true,\"daysSinceQSDownload\":-1,\"onsType\":\"0\",\"freeMonths\":0,\"snType\":\"M\",\"isMFAccount\":true,\"isPendingCancel\":false,\"pmi\":4,\"subs\":{\"subpsw174\":[]},\"osb\":0,\"acctStatus\":\"Active\",\"masterSN\":\"subpsw174\",\"daysSinceMakeAOLMyHomePage\":-1,\"careStatus\":249,\"bid\":1,\"brandi\":265,\"zip\":\"35758\",\"sid\":2,\"sn\":\"subpsw174\",\"subAccountNumber\":565354693,\"categoryId\":50,\"masterAccountNumber\":565354693,\"isFreePI\":false,\"daysSinceFirstMobileIMAPLogin\":-1,\"affinity\":0,\"onsBrandi\":\"265\",\"guid\":\"subpsw174\",\"pendingPI\":0,\"monthlyFee\":2590,\"snList\":[\"subpsw174\"],\"email\":\"subpsw174@aol.com\",\"onsBid\":\"1\",\"tenure\":1046453778000,\"pi\":72,\"daysSinceFirstWin8IMAPLogin\":-1}";

	@Before
	public void setUp() throws Exception {
		iaDaoImpl = new IaDaoImpl();
		ReflectionTestUtils.setField(iaDaoImpl, "iaEndpoint", "does-not-matter");
		
		restOperations = mock(RestOperations.class);
		ReflectionTestUtils.setField(iaDaoImpl, "restOperations", restOperations);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testGetOffers() {
		// Set Expectations
		when(restOperations.getForObject(any(URI.class), (Class)any(Class.class))).thenReturn("abc");
		
		// Test
		iaDaoImpl.getOffers(createIaRequest());
		
		// Verify
		verify(restOperations).getForObject(any(URI.class), (Class)any(Class.class));
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

	@Test
	public void testGetUri() {
		URI uri = iaDaoImpl.getUri("abc", createIaRequest());
		LOGGER.debug("Uri: {}", uri);
		assertNotNull(uri);
	}

}
