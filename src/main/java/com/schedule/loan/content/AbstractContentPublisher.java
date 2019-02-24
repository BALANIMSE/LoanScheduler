package com.schedule.loan.content;

import org.springframework.http.ResponseEntity;

import com.schedule.loan.dto.BaseDTO;

/**
 * The Class AbstractContentPublisher. Abstract class for content generation.
 *
 * @param <T> the generic type
 */
public abstract class AbstractContentPublisher<T extends BaseDTO> {

	/**
	 * Publish.
	 *
	 * @param entity    the entity
	 * @param mediaType the media type
	 * @return the response entity
	 * @throws Exception the exception
	 */
	public abstract ResponseEntity<Object> publish(T entity, String mediaType) throws Exception;

}
