package org.restfulws.akhil.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
//import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.restfulws.akhil.model.Message;
import org.restfulws.akhil.resources.beans.MessageFilterBeans;
import org.restfulws.akhil.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService mr = new MessageService();
//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public String getMessages() {
//		return "Hello World!";
//	}
		
	@GET
	public List<Message> getMessages(@BeanParam MessageFilterBeans messagefilterbean) {
		if(messagefilterbean.getYear() > 0) {
			return mr.getallyearlyMessages(messagefilterbean.getYear());
		}
		if(messagefilterbean.getStart() >=0 && messagefilterbean.getSize() >=0) {
			
			return mr.getAllPagenated(messagefilterbean.getStart(), messagefilterbean.getSize());
		}
		return mr.getAllMessages();
	}
	
	@GET
	@Path("/{messageID}")
	public Message getMessage(@PathParam("messageID")long id) {
		return mr.getMessage(id);
	}
	
	@POST
	public Message addMessage(Message message) {
		return mr.addMessage(message);
	}
	
	@PUT
	@Path("/{messageID}")
	public Message updateMessage(@PathParam("messageID")long id, Message message) {
		message.setId(id);
		return mr.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageID}")
	public void deleteMesage(@PathParam("messageID") long id) {
		mr.removeMessage(id);
	}
	
	@Path("{messageID}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}

}
