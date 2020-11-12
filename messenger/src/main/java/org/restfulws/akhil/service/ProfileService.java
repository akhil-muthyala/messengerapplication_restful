package org.restfulws.akhil.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.restfulws.akhil.database.DatabaseClass;
import org.restfulws.akhil.model.Profile;

public class ProfileService {
	
	public ProfileService() {
		profiles.put("akhil", new Profile(1L, "akhil", "Akhil", "Muthyala"));
	}
	
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	
	public List<Profile> getallProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}

	public Profile getProfiles(String profilename) {
		return profiles.get(profilename);
		
	}
	
	public Profile addProfiles(Profile profile) {
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfilename(), profile);
		return profile;
		
	}
	
	public Profile updateProfiles(Profile profile) {
		if(profile.getProfilename().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfilename(), profile);
		return profile;
	}
	
	public Profile removemessage(String profilename) {
		return profiles.remove(profilename);
	}
}
