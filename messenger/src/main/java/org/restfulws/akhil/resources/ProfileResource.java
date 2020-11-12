package org.restfulws.akhil.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.restfulws.akhil.model.Profile;
import org.restfulws.akhil.service.ProfileService;

@Path("/profiles")
public class ProfileResource {

	ProfileService pr = new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getAllProfiles() {
		return pr.getallProfiles();		
	}
	
	
	@GET
	@Path("{profilename}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profile getProfile(@PathParam("profilename")String ProfileName) {
		return pr.getProfiles(ProfileName);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profile addProfile(Profile profile) {
		return pr.addProfiles(profile);
	}
	
	@PUT
	@Path("{profilename}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profile updateProfile (@PathParam("profilename") String Profilename ,Profile profile) {
		profile.setProfilename(Profilename);
		return pr.updateProfiles(profile);
		
	}
	
	@DELETE
	@Path("{profilename}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteProfile(@PathParam("profilename") String Profilename) {
		pr.removemessage(Profilename);
	}
}
