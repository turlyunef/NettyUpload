package ru.turlyunef.core.response.strategy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.turlyunef.core.client.ClientInfo;
import ru.turlyunef.core.response.JSONScheme;
import ru.turlyunef.core.response.ResponseStrategy;

public class StatusStrategy implements ResponseStrategy {

	@Override
	public String doResponse(ClientInfo client) throws JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(new JSONScheme() {
			public String getStatus() {
				return client.getStatus().getValue();
			}
		});
	}
}
