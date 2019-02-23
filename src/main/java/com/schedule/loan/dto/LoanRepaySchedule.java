package com.schedule.loan.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class LoanRepaySchedule {

	private int installmentNumber;

	private BigDecimal borrowerPaymentAmount;
	private Date date;
	private BigDecimal initialOutstandingPrincipal;
	private BigDecimal interest;
	private BigDecimal principal;
	private BigDecimal remainingOutstandingPrincipal;

	public int getInstallmentNumber() {
		return installmentNumber;
	}

	public void setInstallmentNumber(int installmentNumber) {
		this.installmentNumber = installmentNumber;
	}

	public BigDecimal getBorrowerPaymentAmount() {
		return borrowerPaymentAmount;
	}

	public void setBorrowerPaymentAmount(BigDecimal borrowerPaymentAmount) {
		this.borrowerPaymentAmount = borrowerPaymentAmount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getInitialOutstandingPrincipal() {
		return initialOutstandingPrincipal;
	}

	public void setInitialOutstandingPrincipal(BigDecimal initialOutstandingPrincipal) {
		this.initialOutstandingPrincipal = initialOutstandingPrincipal;
	}

	public BigDecimal getInterest() {
		return interest;
	}

	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}

	public BigDecimal getPrincipal() {
		return principal;
	}

	public void setPrincipal(BigDecimal principal) {
		this.principal = principal;
	}

	public BigDecimal getRemainingOutstandingPrincipal() {
		return remainingOutstandingPrincipal;
	}

	public void setRemainingOutstandingPrincipal(BigDecimal remainingOutstandingPrincipal) {
		this.remainingOutstandingPrincipal = remainingOutstandingPrincipal;
	}

}
