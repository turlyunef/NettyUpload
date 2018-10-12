package ru.turlyunef.User;

import ru.turlyunef.core.UserRuntime;

/**
 * @author Turlyun
 * 
 */
public class App {
	public static void main(String[] args) throws Exception {
		UserRuntime userRuntime = new UserRuntime("localhost", 8080);
		userRuntime.run();
		
    }
}
