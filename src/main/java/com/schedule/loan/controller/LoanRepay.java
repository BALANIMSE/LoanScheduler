package com.schedule.loan.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.schedule.loan.dto.LoanRepayRequestDTO;
import com.schedule.loan.dto.LoanRepayResponseDTO;
import com.schedule.loan.service.LoanRepayService;

@RestController
@RequestMapping("/loan")
public class LoanRepay extends RESTBase {

	@Autowired
	LoanRepayService loanRepayService = null;

	@PostMapping(value = "/generate-plan")
	public ResponseEntity<Object> create(@Valid @RequestBody LoanRepayRequestDTO repayRequestDTO,
			@RequestParam(value = "mediatype", required = false, defaultValue = "") String mediaType,
			HttpServletRequest request) {

		ResponseEntity<Object> response = null;

		try {
			LoanRepayResponseDTO repayResponse = loanRepayService.generateRepaySchedule(repayRequestDTO);

			response = buildResponse(repayResponse, mediaType);

		} catch (Exception ex) {
			ex.printStackTrace();
			response = buildResponse("LN-RP-001");
		}
		return response;

	}

}
