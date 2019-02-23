package com.schedule.loan.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class LoanRepayRequestDTO {

	@NotNull(message = "loan Amount can not be null")

	private BigDecimal loanAmount;

	@NotNull(message = "nominal rate can not be null")
	private BigDecimal nominalRate;

	@NotNull(message = "duration can not be null")

	private int duration;

	@NotNull(message = "startDate can not be null")
	private Date startDate;

	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}

	public BigDecimal getNominalRate() {
		return nominalRate;
	}

	public void setNominalRate(BigDecimal nominalRate) {
		this.nominalRate = nominalRate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {

		this.startDate = startDate;
	}

}
