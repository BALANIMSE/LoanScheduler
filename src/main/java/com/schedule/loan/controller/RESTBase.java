package com.schedule.loan.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.schedule.loan.content.AbstractContentPublisher;
import com.schedule.loan.content.ContentPublisherFactory;
import com.schedule.loan.dto.BaseDTO;
import com.schedule.loan.dto.Message;
import com.schedule.loan.enumerations.Status;

public class RESTBase {

	private AbstractContentPublisher<BaseDTO> contentPublisher = null;

	protected ResponseEntity<Object> buildResponse(BaseDTO baseDTO, String mediaType) {

		ResponseEntity<Object> restResponse = null;
		Message successMessage = new Message(Status.SUCCESS, "INFO");

		try {

			if (baseDTO != null && baseDTO.getResult() == null) {

				if (mediaType != null && mediaType.equals("")) {

					baseDTO.setResult(successMessage);
					restResponse = new ResponseEntity<Object>(baseDTO, HttpStatus.OK);

				} else {

					contentPublisher = ContentPublisherFactory.getInstance().getContentPublisher(mediaType.toString());
					if (contentPublisher != null) {
						baseDTO.setResult(successMessage);
						restResponse = contentPublisher.publish(baseDTO, mediaType);
					} else {
						restResponse = buildResponse("LN_DEF_ERROR");
					}

				}
			} else {
				restResponse = new ResponseEntity<Object>(baseDTO, HttpStatus.OK);
			}
		} catch (Exception ex) {
			restResponse = buildResponse("LN_DEF_ERROR");
		}
		if (restResponse == null) {
			successMessage = new Message(Status.SUCCESS, "NORESULT");
			restResponse = new ResponseEntity<Object>(successMessage, HttpStatus.OK);
		}

		return restResponse;
	}

	protected ResponseEntity<Object> buildResponse(String errorCode) {

		Message response = new Message(Status.ERROR, errorCode);

		return new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
