package com.gmail.tas;

import java.util.ArrayList;
import java.util.Map;

public class Storage {
	
	private static Map<Integer, ArrayList<String>> storage;

	public static Map<Integer, ArrayList<String>> getStorage() {
		return storage;
	}

	public static void addChat(int userID, UserChat userChat) {
		Integer key = userID;
		ArrayList<String> value = userChat.getMessages();
		storage.put(key, value);
	}
}
