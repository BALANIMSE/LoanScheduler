package com.schedule.loan.enumerations;

/**
 * The Enum Status. Holds all possible status response status of RESTful
 * services
 */
public enum Status {

	/** The success. */
	SUCCESS("Success"),
	/** The error. */
	ERROR("Error"),
	/** The fatal. */
	FATAL("Fatal");

	/** The value. */
	private String value = null;

	/**
	 * Instantiates a new status.
	 *
	 * @param value the value
	 */
	private Status(String value) {
		this.value = value;
	}

	/**
	 * From value.
	 *
	 * @param value the value
	 * @return the status
	 */
	public static Status fromValue(String value) {
		for (Status element : Status.values()) {
			if (element.toString().equals(value)) {
				return element;
			}
		}
		return null;
	}

}