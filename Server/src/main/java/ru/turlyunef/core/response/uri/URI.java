package ru.turlyunef.core.response.uri;

import ru.turlyunef.core.response.strategy.URLStrategy;

/*
 * URI = [scheme] "://" [host] ":" [port] "/" [ body ]
 */

public interface URI {
	String getScheme();

	String getHost();

	int getPort();

	String getBody();

	String getURI();

	void doCreateURI(URLStrategy strategy, URLForm urlForm);

}
