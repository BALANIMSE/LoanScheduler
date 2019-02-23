package com.schedule.loan.dto;

import java.io.Serializable;

public class BaseDTO implements Serializable {

	private Message result = null;

	public Message getResult() {
		return result;
	}

	public void setResult(Message result) {
		this.result = result;
	}

}
