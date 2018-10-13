package ru.turlyunef.core.response.uri;

import ru.turlyunef.core.response.strategy.URLStrategy;

/*
 * URI = [scheme] "://" [host] ":" [port] "/" [ body ]
 */
public class URL implements URI {

	private String scheme;
	private String host;
	private int port;
	private String body;

	private URLForm urlForm;
	private URLStrategy responseStrategy;

	@Override
	public void doCreateURI(URLStrategy strategy, URLForm urlForm) {
		this.responseStrategy = strategy;
		this.urlForm = urlForm;
		this.urlForm.doURL(this);
	}

	public URLStrategy getResponseStrategy() {
		return responseStrategy;
	}

	@Override
	public String getURI() {
		return (scheme + "://" + host + ":" + String.valueOf(port) + "/" + body);
	}

	@Override
	public String getScheme() {
		return this.scheme;
	}

	@Override
	public String getHost() {
		return this.host;
	}

	@Override
	public int getPort() {
		return this.port;
	}

	@Override
	public String getBody() {
		return this.body;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
