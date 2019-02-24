package com.schedule.loan.dto;

import java.util.ArrayList;
import java.util.List;

import com.schedule.loan.enumerations.Status;
import com.schedule.loan.helper.MessageHelper;

/**
 * The Class Message. This is attribute in BaseDTO, holds the final status of
 * RESTful service
 */
public class Message {

	/** The status. */
	private Status status;

	/** The messages. */
	private List<String> messages = null;

	/** The code. */
	private String code;

	/**
	 * Instantiates a new message.
	 */
	public Message() {
		messages = new ArrayList<String>();

	}

	/**
	 * Instantiates a new message.
	 *
	 * @param status the status
	 * @param code   the code
	 */
	public Message(Status status, String code) {
		this.code = code;
		this.status = status;
		this.messages = new ArrayList<String>();
		this.messages.add(MessageHelper.getMessage(code));

	}

	/**
	 * Gets the result.
	 *
	 * @return the result
	 */
	public Status getResult() {
		return status;
	}

	/**
	 * Sets the result.
	 *
	 * @param status the new result
	 */
	public void setResult(Status status) {
		this.status = status;
	}

	/**
	 * Gets the messages.
	 *
	 * @return the messages
	 */
	public List<String> getMessages() {

		return messages;
	}

}
