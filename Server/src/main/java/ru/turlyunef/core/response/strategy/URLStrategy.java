package ru.turlyunef.core.response.strategy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ru.turlyunef.core.client.ClientInfo;
import ru.turlyunef.core.response.JSONScheme;
import ru.turlyunef.core.response.ResponseStrategy;
import ru.turlyunef.core.response.uri.URI;
import ru.turlyunef.core.response.uri.URL;
import ru.turlyunef.core.response.uri.URLForm;
import ru.turlyunef.core.response.uri.strategy.Md5OnServerStrategy;

public class URLStrategy implements ResponseStrategy {

	private ClientInfo client;
	private URI uri = new URL();
	
	@Override
	public String doResponse(ClientInfo client) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		this.client = client;
		return mapper.writeValueAsString(new JSONScheme() {

			public String getURL() {
				return createURI(new Md5OnServerStrategy());
			}
		});
	}

	public String createURI(URLForm urlForm) {
		uri.doCreateURI(this, urlForm);
		return uri.getURI();
	}

	public ClientInfo getClient() {
		return client;
	}

}
