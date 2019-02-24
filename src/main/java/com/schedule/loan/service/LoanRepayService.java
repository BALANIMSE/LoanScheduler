package com.schedule.loan.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schedule.loan.adapter.LoanRepayScheduleMockAdapter;
import com.schedule.loan.dto.LoanRepayRequestDTO;
import com.schedule.loan.dto.LoanRepayResponseDTO;
import com.schedule.loan.dto.Message;
import com.schedule.loan.enumerations.Status;
import com.schedule.loan.helper.MessageHelper;

/**
 * The Class LoanRepayService. This is core business logic class, where business
 * validation of request payload happens. Basis on successful validation this
 * service makes call to Adapter to perform the terminal operation for this API.
 */

@Service
public class LoanRepayService {

	/** The repay adapter. */
	@Autowired
	private LoanRepayScheduleMockAdapter repayAdapter = null;

	/**
	 * Generate repay schedule.
	 *
	 * @param repayRequestDTO the repay request DTO
	 * @return the loan repay response DTO
	 */
	public LoanRepayResponseDTO generateRepaySchedule(LoanRepayRequestDTO repayRequestDTO) {

		LoanRepayResponseDTO repayResponse = null;

		try {
			repayResponse = validateGenerateRepaySchedule(repayRequestDTO);
			if (repayResponse == null)
				repayResponse = repayAdapter.calculateRepaySchedule(repayRequestDTO);

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}

		return repayResponse;
	}

	/**
	 * Validate generate repay schedule.
	 *
	 * @param repayRequestDTO the repay request DTO
	 * @return the loan repay response DTO
	 */
	private LoanRepayResponseDTO validateGenerateRepaySchedule(LoanRepayRequestDTO repayRequestDTO) {

		LoanRepayResponseDTO response = null;
		Message message = new Message();

		try {

			if (repayRequestDTO != null) {

				if (validatePositiveAmount(repayRequestDTO.getLoanAmount())) {

					message.getMessages().add(MessageHelper.getMessage("FLD_LOANAMT"));
				}

				if (validatePositiveAmount(repayRequestDTO.getNominalRate())) {

					message.getMessages().add(MessageHelper.getMessage("FLD_NOMINALRATE"));
				}

				if (repayRequestDTO.getDuration() <= 0) {

					message.getMessages().add(MessageHelper.getMessage("FLD_DURATION"));
				}

			}

			if (message.getMessages().size() > 0) {
				response = new LoanRepayResponseDTO();
				message.setResult(Status.ERROR);
				response.setResult(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
			message.getMessages().add(MessageHelper.getMessage("LN_DEF_ERROR"));
			message.setResult(Status.FATAL);
			throw e;
		}

		return response;
	}

	/**
	 * Validate positive amount.
	 *
	 * @param amount the amount
	 * @return true, if successful
	 */
	private boolean validatePositiveAmount(BigDecimal amount) {
		boolean flag = false;

		if (amount != null && (amount.compareTo(new BigDecimal("0.00")) <= 0))
			flag = true;

		return flag;

	}

}
