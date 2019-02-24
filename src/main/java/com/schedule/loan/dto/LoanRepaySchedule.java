package com.schedule.loan.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * The Class LoanRepaySchedule. This is inner object in Response DTO, which
 * holds the repayment schedules
 */
@Component
public class LoanRepaySchedule {

	/** The installment number. */
	private int installmentNumber;

	/** The borrower payment amount. */
	private BigDecimal borrowerPaymentAmount;

	/** The date. */
	private Date date;

	/** The initial outstanding principal. */
	private BigDecimal initialOutstandingPrincipal;

	/** The interest. */
	private BigDecimal interest;

	/** The principal. */
	private BigDecimal principal;

	/** The remaining outstanding principal. */
	private BigDecimal remainingOutstandingPrincipal;

	/**
	 * Gets the installment number.
	 *
	 * @return the installment number
	 */
	public int getInstallmentNumber() {
		return installmentNumber;
	}

	/**
	 * Sets the installment number.
	 *
	 * @param installmentNumber the new installment number
	 */
	public void setInstallmentNumber(int installmentNumber) {
		this.installmentNumber = installmentNumber;
	}

	/**
	 * Gets the borrower payment amount.
	 *
	 * @return the borrower payment amount
	 */
	public BigDecimal getBorrowerPaymentAmount() {
		return borrowerPaymentAmount;
	}

	/**
	 * Sets the borrower payment amount.
	 *
	 * @param borrowerPaymentAmount the new borrower payment amount
	 */
	public void setBorrowerPaymentAmount(BigDecimal borrowerPaymentAmount) {
		this.borrowerPaymentAmount = borrowerPaymentAmount;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Gets the initial outstanding principal.
	 *
	 * @return the initial outstanding principal
	 */
	public BigDecimal getInitialOutstandingPrincipal() {
		return initialOutstandingPrincipal;
	}

	/**
	 * Sets the initial outstanding principal.
	 *
	 * @param initialOutstandingPrincipal the new initial outstanding principal
	 */
	public void setInitialOutstandingPrincipal(BigDecimal initialOutstandingPrincipal) {
		this.initialOutstandingPrincipal = initialOutstandingPrincipal;
	}

	/**
	 * Gets the interest.
	 *
	 * @return the interest
	 */
	public BigDecimal getInterest() {
		return interest;
	}

	/**
	 * Sets the interest.
	 *
	 * @param interest the new interest
	 */
	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}

	/**
	 * Gets the principal.
	 *
	 * @return the principal
	 */
	public BigDecimal getPrincipal() {
		return principal;
	}

	/**
	 * Sets the principal.
	 *
	 * @param principal the new principal
	 */
	public void setPrincipal(BigDecimal principal) {
		this.principal = principal;
	}

	/**
	 * Gets the remaining outstanding principal.
	 *
	 * @return the remaining outstanding principal
	 */
	public BigDecimal getRemainingOutstandingPrincipal() {
		return remainingOutstandingPrincipal;
	}

	/**
	 * Sets the remaining outstanding principal.
	 *
	 * @param remainingOutstandingPrincipal the new remaining outstanding principal
	 */
	public void setRemainingOutstandingPrincipal(BigDecimal remainingOutstandingPrincipal) {
		this.remainingOutstandingPrincipal = remainingOutstandingPrincipal;
	}

}
