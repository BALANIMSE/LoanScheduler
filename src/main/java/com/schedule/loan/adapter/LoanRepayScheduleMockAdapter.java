package com.schedule.loan.adapter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.schedule.loan.dto.LoanRepayRequestDTO;
import com.schedule.loan.dto.LoanRepayResponseDTO;
import com.schedule.loan.dto.LoanRepaySchedule;
import com.schedule.loan.helper.AdapterHelper;

/**
 * The Class LoanRepayScheduleMockAdapter. This is mock Adapter which generate
 * the Loan repayment schedule in our application it self. However, in another
 * scenario we may get this schedule from core banking application where actual
 * Loan processing happens, this is one of the reasons I gave the name to this
 * class as Mock Apdater.
 */
@Component
public class LoanRepayScheduleMockAdapter {

	/** The loan repay response DTO. */
	LoanRepayResponseDTO loanRepayResponseDTO = null;

	/**
	 * Calculate repay schedule.
	 *
	 * @param repayRequestDTO the repay request DTO
	 * @return the loan repay response DTO
	 */
	public LoanRepayResponseDTO calculateRepaySchedule(LoanRepayRequestDTO repayRequestDTO) {

		try {

			AdapterHelper helper = new AdapterHelper();
			int counter = 1;

			ArrayList<LoanRepaySchedule> repaySchedule = new ArrayList<LoanRepaySchedule>();
			BigDecimal outstandingLoan = repayRequestDTO.getLoanAmount();
			BigDecimal monthlyInstallment = helper.monthlyRepaymentCalc(repayRequestDTO);
			BigDecimal roi = repayRequestDTO.getNominalRate();

			Date firstInstallemntDate = repayRequestDTO.getStartDate();
			Date nextInstallmentDate = repayRequestDTO.getStartDate();

			// First installment date
			Calendar myCal = Calendar.getInstance();
			myCal.setTime(firstInstallemntDate);

			loanRepayResponseDTO = new LoanRepayResponseDTO();

			// Loop to calculate per installment details
			do {

				LoanRepaySchedule repayForMonth = new LoanRepaySchedule();

				BigDecimal interest = helper.interestForMonth(roi, outstandingLoan);
				BigDecimal principal = monthlyInstallment.subtract(interest);
				BigDecimal remainingOutstandingPrincipal = outstandingLoan.subtract(principal);

				/**
				 * Logic to handle principal, borrower pay amount and remaining outstanding
				 * principal for last intallment
				 */

				if (repayRequestDTO.getDuration() == counter) {
					repayForMonth.setBorrowerPaymentAmount(monthlyInstallment.add(remainingOutstandingPrincipal));
					repayForMonth.setPrincipal(principal.add(remainingOutstandingPrincipal));
					repayForMonth.setRemainingOutstandingPrincipal(new BigDecimal("0.00"));

				} else {
					repayForMonth.setRemainingOutstandingPrincipal(remainingOutstandingPrincipal);
					repayForMonth.setBorrowerPaymentAmount(monthlyInstallment);
					repayForMonth.setPrincipal(principal);
				}

				repayForMonth.setInstallmentNumber(counter);
				repayForMonth.setInitialOutstandingPrincipal(outstandingLoan);
				repayForMonth.setInterest(interest);
				repayForMonth.setDate(nextInstallmentDate);

				// Logic to calculate next installment date
				myCal.setTime(firstInstallemntDate);
				myCal.add(Calendar.MONTH, counter);
				nextInstallmentDate = myCal.getTime();

				outstandingLoan = outstandingLoan.subtract(monthlyInstallment.subtract(interest));

				counter++;
				repaySchedule.add(repayForMonth);

			} while (counter <= repayRequestDTO.getDuration());

			loanRepayResponseDTO.setRepaySchedule(repaySchedule);
			loanRepayResponseDTO.setRepayRequestDTO(repayRequestDTO);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}

		return loanRepayResponseDTO;
	}

}