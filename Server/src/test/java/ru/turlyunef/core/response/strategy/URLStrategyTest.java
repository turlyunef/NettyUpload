package ru.turlyunef.core.response.strategy;

import com.fasterxml.jackson.core.JsonProcessingException;

import junit.framework.TestCase;
import ru.turlyunef.core.client.Client;

public class URLStrategyTest extends TestCase {
	private Client client = new Client();
	private String str = null;
	private final String md5Sum = "68b329da9893e34099c7d8ad5cb9c940";

	@Override
	public void setUp() {
		this.client.setMd5Sum(md5Sum);
	}

	public void testResponseStrategy() {
		try {
			this.str = this.client.createResponse(new URLStrategy());
			assertNotNull(str);
			assertEquals("{\"url\":\"Http://localhost:8080/upload/68b329da9893e34099c7d8ad5cb9c940\"}", str);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			assertNull(e.getMessage());
		}
	}
}
