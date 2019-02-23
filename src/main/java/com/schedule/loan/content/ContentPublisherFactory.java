package com.schedule.loan.content;

import com.schedule.loan.dto.BaseDTO;
import com.schedule.loan.dto.LoanRepayConstant;

public class ContentPublisherFactory {

	private static ContentPublisherFactory factoryInstance = null;

	public static ContentPublisherFactory getInstance() {

		if (factoryInstance == null) {
			synchronized (ContentPublisherFactory.class) {
				if (factoryInstance == null) {
					factoryInstance = new ContentPublisherFactory();
				}
			}
		}
		return factoryInstance;
	}

	public AbstractContentPublisher<BaseDTO> getContentPublisher(String contentType) {

		AbstractContentPublisher<BaseDTO> contentPublisher = null;
		switch (contentType) {
		case LoanRepayConstant.PDF:
			contentPublisher = new PDFContentPublisher();

			break;

		case LoanRepayConstant.CSV:
			contentPublisher = new CSVContentPublisher();

			break;

		default:
			break;
		}
		return contentPublisher;

	}

}
