package com.schedule.loan.content;

import com.schedule.loan.dto.BaseDTO;
import com.schedule.loan.dto.LoanRepayConstant;

/**
 * A factory for creating ContentPublisher objects. Currently CSV class has
 * basic implementation logic for content generation. Just to demonstrate the
 * factory I have defined PDF content generator also
 * 
 */
public class ContentPublisherFactory {

	/** The factory instance. */
	private static ContentPublisherFactory factoryInstance = null;

	/**
	 * Gets the single instance of ContentPublisherFactory.
	 *
	 * @return single instance of ContentPublisherFactory
	 */
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

	/**
	 * Gets the content publisher.
	 *
	 * @param contentType the content type
	 * @return the content publisher
	 */
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
