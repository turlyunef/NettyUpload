package ru.turlyunef.core.response.uri.strategy;

import ru.turlyunef.core.response.uri.URL;
import ru.turlyunef.core.response.uri.URLForm;

public class Md5OnServerStrategy implements URLForm {
	private final String serverHost = "localhost"; //!!!put in a config file with constants
	private final String serverScheme = "Http"; //!!!put in a config file with constants
	private final int serverPort = 8080; //!!!put in a config file with constants

	@Override
	public void doURL(URL url) {
		url.setScheme(this.serverScheme);
		url.setHost(this.serverHost);
		url.setPort(this.serverPort);
		url.setBody("upload/" + getMd5Sum(url));
	}

	public String getMd5Sum(URL url) {
		return url.getResponseStrategy().getClient().getMd5Sum();

	}

}
