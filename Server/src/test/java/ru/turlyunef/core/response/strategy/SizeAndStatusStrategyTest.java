package ru.turlyunef.core.response.strategy;

import com.fasterxml.jackson.core.JsonProcessingException;

import junit.framework.TestCase;
import ru.turlyunef.core.client.Client;
import ru.turlyunef.core.response.Status;

public class SizeAndStatusStrategyTest extends TestCase {
	private Client client = new Client();
	private String str = null;
	private int size = 121255634;
	Status status = Status.Done;

	@Override
	public void setUp() {
		this.client.setSize(size);
		this.client.setStatus(status);
	}
	
	public void testResponseStrategy() {
		try {
			this.str = this.client.createResponse(new SizeAndStatusStrategy());
			assertNotNull(str);
			assertEquals("{\"size\":"+this.size+",\"status\":\""+this.status.getValue()+"\"}", str);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			assertNull(e.getMessage());
		}
	}
	
}
