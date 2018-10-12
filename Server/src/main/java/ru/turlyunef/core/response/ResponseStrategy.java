package ru.turlyunef.core.response;

import com.fasterxml.jackson.core.JsonProcessingException;

import ru.turlyunef.core.client.ClientInfo;

public interface ResponseStrategy {
	String doResponse(ClientInfo client) throws JsonProcessingException;
}
