package ru.turlyunef.Server;
import ru.turlyunef.core.ServerRuntime;

/**
 * @author Turlyun
 *
 */
public class App {
	public static void main(String[] args) {
		int port;
		String host;
		host = "localhost"; //!!!put in a config file with constants
		port = 8080; //!!!put in a config file with constants
		
		try {
			new ServerRuntime(host, port).run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
