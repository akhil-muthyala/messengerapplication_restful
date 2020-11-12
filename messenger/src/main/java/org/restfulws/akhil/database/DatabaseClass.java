package org.restfulws.akhil.database;

import java.util.HashMap;
import java.util.Map;

import org.restfulws.akhil.model.Message;
import org.restfulws.akhil.model.Profile;

public class DatabaseClass {
	
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();

	public static Map<Long, Message> getMessage(){
		return messages;
	}
	
	public static Map<String, Profile> getProfiles(){
		return profiles;
	}
}
