package ru.turlyunef.core.response.strategy;

import com.fasterxml.jackson.core.JsonProcessingException;

import junit.framework.TestCase;
import ru.turlyunef.core.client.Client;
import ru.turlyunef.core.response.Status;

public class StatusStrategyTest extends TestCase {

	private Client client = new Client();
	private String str = null;

	@Override
	public void setUp() {
		this.client.setStatus(Status.ErrorUpload);
	}

	public void testResponseStrategy() {
		try {
			this.str = this.client.createResponse(new StatusStrategy());
			assertNotNull(str);
			assertEquals("{\"status\":\"error-upload\"}", str);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			assertNull(e.getMessage());
		}
	}
}
