package com.schedule.loan.content;

import org.springframework.http.ResponseEntity;

import com.schedule.loan.dto.BaseDTO;

/**
 * The Class PDFContentPublisher extends abstract class Content publisher. Just
 * declaration, but it can have logic to implement the PDF content generator
 * using XSLT and XML transformation
 */
public class PDFContentPublisher extends AbstractContentPublisher<BaseDTO> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.schedule.loan.content.AbstractContentPublisher#publish(com.schedule.loan.
	 * dto.BaseDTO, java.lang.String)
	 */
	@Override
	public ResponseEntity<Object> publish(BaseDTO entity, String mediaType) throws Exception {

		return null;

	}

}
