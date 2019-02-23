package com.schedule.loan.dto;

import java.util.List;

public class LoanRepayResponseDTO extends BaseDTO {

	private LoanRepayRequestDTO repayRequestDTO;

	private List<LoanRepaySchedule> repaySchedule;

	public LoanRepayRequestDTO getRepayRequestDTO() {
		return repayRequestDTO;
	}

	public void setRepayRequestDTO(LoanRepayRequestDTO repayRequestDTO) {
		this.repayRequestDTO = repayRequestDTO;
	}

	public List<LoanRepaySchedule> getRepaySchedule() {
		return repaySchedule;
	}

	public void setRepaySchedule(List<LoanRepaySchedule> repaySchedule) {
		this.repaySchedule = repaySchedule;
	}

}
