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

@Service
public class LoanRepayService {

	@Autowired
	private LoanRepayScheduleMockAdapter repayAdapter = null;

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

	private boolean validatePositiveAmount(BigDecimal amount) {
		boolean flag = false;

		if (amount != null
				&& (amount.compareTo(new BigDecimal("0.00")) == -1 || amount.compareTo(new BigDecimal("0.00")) == 0))
			flag = true;

		return flag;

	}

}
