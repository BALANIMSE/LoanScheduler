package com.schedule.loan.content;

import org.springframework.http.ResponseEntity;

import com.schedule.loan.dto.BaseDTO;

public abstract class AbstractContentPublisher<T extends BaseDTO> {

	public abstract ResponseEntity<Object> publish(T entity, String mediaType) throws Exception;

}
