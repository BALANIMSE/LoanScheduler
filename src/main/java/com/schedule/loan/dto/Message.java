package com.schedule.loan.dto;

import java.util.ArrayList;
import java.util.List;

import com.schedule.loan.enumerations.Status;
import com.schedule.loan.helper.MessageHelper;

public class Message {

	private Status status;

	private List<String> messages = null;

	private String code;

	public Message() {
		messages = new ArrayList<String>();

	}

	public Message(Status status, String code) {
		this.code = code;
		this.status = status;
		this.messages = new ArrayList<String>();
		this.messages.add(MessageHelper.getMessage(code));

	}

	public Status getResult() {
		return status;
	}

	public void setResult(Status status) {
		this.status = status;
	}

	public List<String> getMessages() {

		return messages;
	}

}
