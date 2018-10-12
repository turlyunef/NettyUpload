package ru.turlyunef.core.client;

import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;

import ru.turlyunef.core.response.ResponseStrategy;
import ru.turlyunef.core.response.Status;

public class Client implements ClientInfo {
	private String md5Sum;
	private String ip;
	private int port;
	private Status status;
	private int size;
	private Date uploadTime;
	
	public String createResponse(ResponseStrategy responseStrategy) throws JsonProcessingException {
		return responseStrategy.doResponse(this);
				
	}
	
	public void setMd5Sum(String md5Sum) {
		this.md5Sum = md5Sum;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	@Override
	public String getMd5Sum() {
		return this.md5Sum;
	}

	@Override
	public String getIp() {
		return this.ip;
	}

	@Override
	public int getPort() {
		return this.port;
	}

	@Override
	public Status getStatus() {
		return this.status;
	}

	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public Date getUploadTime() {
		return this.uploadTime;
	}

}
