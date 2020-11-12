package org.restfulws.akhil.service;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.restfulws.akhil.database.DatabaseClass;
import org.restfulws.akhil.model.Comment;
import org.restfulws.akhil.model.Message;

public class CommentService {

	private Map<Long, Message> messages = DatabaseClass.getMessage();
	
	public List<Comment> getAllComments(long MessageID){
		Map<Long, Comment> comments = messages.get(MessageID).getComments();
		return new ArrayList<Comment>(comments.values());
		
	}
	
	public Comment getComment(long MessageID, long CommentID) {
		Map<Long, Comment> comments = messages.get(MessageID).getComments();
		return comments.get(CommentID);
	}
	
	public Comment addComment(long MessageID, Comment comment) {
		Map<Long, Comment> comments = messages.get(MessageID).getComments();
		comment.setId(comments.size()+1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateComment(long MessageID, Comment comment) {
		Map<Long, Comment> comments = messages.get(MessageID).getComments();
		if(comment.getId()<=0) {
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;
		
	}
	
	public Comment removeComment(long MessageID, long CommentID) {
		Map<Long,Comment>comments =messages.get(MessageID).getComments();
		return comments.remove(CommentID);
		 
		
	}
	
}
