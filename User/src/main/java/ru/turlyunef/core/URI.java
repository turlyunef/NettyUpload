package ru.turlyunef.core;

import java.io.BufferedReader;
import java.net.URL;

/*
 * URI = [Scheme] "://" [IP] ":" [Port] "/" [ Request ]
 */

public interface URI {
	String getScheme();
	String getIP();
	String getPort();
	String getRequest();
	
	
}
