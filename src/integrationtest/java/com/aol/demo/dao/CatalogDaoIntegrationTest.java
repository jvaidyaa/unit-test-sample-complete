package com.aol.demo.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aol.demo.model.ecommerce.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={CatalogDaoIntegrationTestConfig.class})
@ActiveProfiles("integrationtesting")
public class CatalogDaoIntegrationTest {

	@Autowired
	private CatalogDao catalogDao;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetProduct() {
		final Product product = catalogDao.getProduct("redbox-dvd-rental");
		Assert.assertNotNull(product);
	}

}
