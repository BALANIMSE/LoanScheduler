package com.schedule.loan.dto;

import java.io.Serializable;

/**
 * The Class BaseDTO. Base class for each response DTOs, it contains DTO to
 * carry the RESTful service execution response
 */
public class BaseDTO implements Serializable {

	/** The result. */
	private Message result = null;

	/**
	 * Gets the result.
	 *
	 * @return the result
	 */
	public Message getResult() {
		return result;
	}

	/**
	 * Sets the result.
	 *
	 * @param result the new result
	 */
	public void setResult(Message result) {
		this.result = result;
	}

}
