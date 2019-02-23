package com.schedule.loan.content;

import org.springframework.http.ResponseEntity;

import com.schedule.loan.dto.BaseDTO;

public class PDFContentPublisher extends AbstractContentPublisher<BaseDTO> {

	@Override
	public ResponseEntity<Object> publish(BaseDTO entity, String mediaType) throws Exception {

		return null;

	}

}
