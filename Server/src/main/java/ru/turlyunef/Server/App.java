package ru.turlyunef.Server;
import ru.turlyunef.core.ServerRuntime;

/**
 * @author Turlyun
 *
 */
public class App {
	public static void main(String[] args) {
		int port;
		if (args.length > 0) {
			port = Integer.parseInt(args[0]);
		} else {
			port = 8080;
		}
		try {
			new ServerRuntime(port).run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
