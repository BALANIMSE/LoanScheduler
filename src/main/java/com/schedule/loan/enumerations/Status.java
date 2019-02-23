package com.schedule.loan.enumerations;

public enum Status {

	SUCCESS("Success"), ERROR("Error"), FATAL("Fatal");
	private String value = null;

	private Status(String value) {
		this.value = value;
	}

	public static Status fromValue(String value) {
		for (Status element : Status.values()) {
			if (element.toString().equals(value)) {
				return element;
			}
		}
		return null;
	}

}