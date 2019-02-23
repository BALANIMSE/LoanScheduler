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

@Component
public class LoanRepayScheduleMockAdapter {

	LoanRepayResponseDTO loanRepayResponseDTO = null;

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

			Calendar myCal = Calendar.getInstance();
			myCal.setTime(firstInstallemntDate);

			loanRepayResponseDTO = new LoanRepayResponseDTO();

			do {

				LoanRepaySchedule repayForMonth = new LoanRepaySchedule();

				BigDecimal interest = helper.interestForMonth(roi, outstandingLoan);
				BigDecimal principal = monthlyInstallment.subtract(interest);
				BigDecimal remainingOutstandingPrincipal = outstandingLoan.subtract(principal);

				if (remainingOutstandingPrincipal.compareTo(new BigDecimal("0.00")) == -1) {
					repayForMonth.setBorrowerPaymentAmount(monthlyInstallment.add(remainingOutstandingPrincipal));
					repayForMonth.setPrincipal(principal.add(remainingOutstandingPrincipal));
					repayForMonth.setRemainingOutstandingPrincipal(new BigDecimal("0.00"));

				} else {
					repayForMonth.setRemainingOutstandingPrincipal(remainingOutstandingPrincipal);
					repayForMonth.setBorrowerPaymentAmount(monthlyInstallment);
					repayForMonth.setPrincipal(principal);
				}
				repayForMonth.setPrincipal(principal);
				repayForMonth.setInstallmentNumber(counter);
				repayForMonth.setInitialOutstandingPrincipal(outstandingLoan);
				repayForMonth.setInterest(interest);
				repayForMonth.setDate(nextInstallmentDate);

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