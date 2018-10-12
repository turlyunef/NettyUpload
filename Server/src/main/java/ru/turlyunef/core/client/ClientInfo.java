package ru.turlyunef.core.client;

import java.util.Date;

import ru.turlyunef.core.response.Status;

public interface ClientInfo {
	String getMd5Sum();
	String getIp();
	int getPort();
	Status getStatus();
	int getSize();
	Date getUploadTime();
}
