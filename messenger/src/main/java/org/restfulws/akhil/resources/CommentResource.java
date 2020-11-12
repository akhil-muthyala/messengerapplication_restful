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

import org.restfulws.akhil.model.Comment;
import org.restfulws.akhil.service.CommentService;

//@Path("/") // optional for sub resource 
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {
	
	private CommentService commentservice = new CommentService();

	@GET
	public List<Comment> getAllCommnets(@PathParam("messageID") long MessageId) {
		return commentservice.getAllComments(MessageId);
	}
	
	@GET
	@Path("/{commentID}")
	public Comment getCommnet(@PathParam("messageID") long messageId,@PathParam("commentID") long commnetId) {
		return commentservice.getComment(messageId, commnetId);
	}
	
	@POST
	public Comment addComment(@PathParam("messageID") long messageId, Comment comment) {
		return commentservice.addComment(messageId, comment);
	}
	
	@PUT
	@Path("/{commentID}")
	public Comment updateComment(@PathParam("messageID") long messageId, @PathParam("commentID") long commnetId, Comment comment) {
		comment.setId(commnetId);
		return commentservice.updateComment(messageId, comment);
	}
	
	@DELETE
	@Path("/{commentID}")
	public Comment deleteComment(@PathParam("messageID") long messageId, @PathParam("commentID") long commnetId) {
		return commentservice.removeComment(messageId, commnetId);
	}
}
