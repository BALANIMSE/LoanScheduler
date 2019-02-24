package com.schedule.loan.dto;

import java.util.List;

/**
 * The Class LoanRepayResponseDTO. Response Data Transfer Object to carry the
 * response body parameters through different layers of application in back
 * journey
 */
public class LoanRepayResponseDTO extends BaseDTO {

	/** The repay request DTO. */
	private LoanRepayRequestDTO repayRequestDTO;

	/** The repay schedule. */
	private List<LoanRepaySchedule> repaySchedule;

	/**
	 * Gets the repay request DTO.
	 *
	 * @return the repay request DTO
	 */
	public LoanRepayRequestDTO getRepayRequestDTO() {
		return repayRequestDTO;
	}

	/**
	 * Sets the repay request DTO.
	 *
	 * @param repayRequestDTO the new repay request DTO
	 */
	public void setRepayRequestDTO(LoanRepayRequestDTO repayRequestDTO) {
		this.repayRequestDTO = repayRequestDTO;
	}

	/**
	 * Gets the repay schedule.
	 *
	 * @return the repay schedule
	 */
	public List<LoanRepaySchedule> getRepaySchedule() {
		return repaySchedule;
	}

	/**
	 * Sets the repay schedule.
	 *
	 * @param repaySchedule the new repay schedule
	 */
	public void setRepaySchedule(List<LoanRepaySchedule> repaySchedule) {
		this.repaySchedule = repaySchedule;
	}

}
