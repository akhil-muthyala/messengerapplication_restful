package org.restfulws.akhil.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.restfulws.akhil.database.DatabaseClass;
import org.restfulws.akhil.model.Message;

public class MessageService {
	
	public MessageService() {
		messages.put(1L,new Message(1L,"Hello World !", "Akhil"));
		messages.put(2L,new Message(2L, "Hello Jersey!", "AkhilJersey"));
	}
	
	private Map<Long, Message> messages =  DatabaseClass.getMessage();
 
	public List<Message> getAllMessages() {
		
//		Message m1 = new Message(1L,"Hello World !", "Akhil");
//		Message m2 = new Message(2L, "Hello Jersey!", "AkhilJersey");
//		List<Message> list = new ArrayList<>();
//		list.add(m1);
//		list.add(m2);
//		return list;
		
		return new ArrayList<Message>(messages.values());
		
	}
	
	public List<Message> getallyearlyMessages(int year){
		List<Message> list = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for(Message mess: messages.values()){
			cal.setTime(mess.getCreated());
			if(cal.get(Calendar.YEAR)==year) {
				list.add(mess);
			}
		}
		return list;
		
	}
	
	public List<Message> getAllPagenated(int start, int size){
		List<Message> listpg = new ArrayList<Message>(messages.values());
		return listpg.subList(start, start+size);
		
	}
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}
