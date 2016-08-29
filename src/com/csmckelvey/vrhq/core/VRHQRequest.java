package com.csmckelvey.vrhq.core;

public class VRHQRequest {

	private int id = -1;
	private int command = -1;
	private String message = null;
	private String options = null;
	
	public VRHQRequest(int id, int command, String message, String options) {
		this.id = id;
		this.command = command;
		this.message = message;
		this.options = options;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}
	
	public int getCommand() {
		return command;
	}

	public void setCommand(int command) {
		this.command = command;
	}
	
	@Override
	public String toString() {
		return "VRHQRequest | id: " + this.id + " | message: " + this.message + " | options: " + this.options;
	}
	
}
