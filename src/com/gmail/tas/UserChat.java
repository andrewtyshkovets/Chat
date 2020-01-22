package com.gmail.tas;

import java.util.ArrayList;

public class UserChat {
	
	private int ChatID;
	
	private ArrayList<String> messages;
	
	
	public UserChat() {
		super();
	}
	
	public UserChat(int chatID) {
		super();
		ChatID = chatID;
	}

	public int getChatID() {
		return ChatID;
	}


	public ArrayList<String> getMessages() {
		return messages;
	}
	
	public void addMessage(String str) {
		messages.add(str);
	}
	
}
