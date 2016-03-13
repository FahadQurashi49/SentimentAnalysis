package com.fahad.example.model;

/*
 * POJO class for fb comments
 */
public class Comment {
	private String id;
	private String message;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return message + "\n";
	}
	
}
