package com.aol.demo.utils;

import static org.junit.Assert.*;

import org.junit.Test;


public class JsonUtilsTest {
	
	@Test
	public void testJsonUtils() {
		new JsonUtils();
	}

	@Test
	public void testToJsonStringNull() {
		assertNull(JsonUtils.toJsonString(null));
	}

	@Test
	public void testToJsonStringException() {
		assertNull(JsonUtils.toJsonString(new NoAccessors()));
	}

	@Test
	public void testToJsonStringNonNul() {
		assertNotNull(JsonUtils.toJsonStringNonNull(""));
	}

	@Test
	public void testToJsonStringNonNullNull() {
		assertNull(JsonUtils.toJsonStringNonNull(null));
	}

	@Test
	public void testToJsonStringNonNullException() {
		assertNull(JsonUtils.toJsonStringNonNull(new NoAccessors()));
	}

	@SuppressWarnings("unused")
	public static class NoAccessors {
		private int a;
		private int b;
	}
}
