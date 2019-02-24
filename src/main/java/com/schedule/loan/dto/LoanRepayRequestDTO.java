package com.schedule.loan.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

/**
 * The Class LoanRepayRequestDTO. Request Data Transfer Object to carry the
 * request body parameters through different layers of application
 */
@Component
public class LoanRepayRequestDTO {

	/** The loan amount. */
	@NotNull(message = "loan Amount can not be null")

	private BigDecimal loanAmount;

	/** The nominal rate. */
	@NotNull(message = "nominal rate can not be null")
	private BigDecimal nominalRate;

	/** The duration. */
	@NotNull(message = "duration can not be null")

	private int duration;

	/** The start date. */
	@NotNull(message = "startDate can not be null")
	private Date startDate;

	/**
	 * Gets the loan amount.
	 *
	 * @return the loan amount
	 */
	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	/**
	 * Sets the loan amount.
	 *
	 * @param loanAmount the new loan amount
	 */
	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}

	/**
	 * Gets the nominal rate.
	 *
	 * @return the nominal rate
	 */
	public BigDecimal getNominalRate() {
		return nominalRate;
	}

	/**
	 * Sets the nominal rate.
	 *
	 * @param nominalRate the new nominal rate
	 */
	public void setNominalRate(BigDecimal nominalRate) {
		this.nominalRate = nominalRate;
	}

	/**
	 * Gets the duration.
	 *
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * Sets the duration.
	 *
	 * @param duration the new duration
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDate the new start date
	 */
	public void setStartDate(Date startDate) {

		this.startDate = startDate;
	}

}
