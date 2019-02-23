package com.schedule.loan.helper;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

import com.schedule.loan.dto.LoanRepayRequestDTO;

@Component
public class AdapterHelper {

	public BigDecimal monthlyRepaymentCalc(LoanRepayRequestDTO repayRequestDTO) {

		int repaymentsPerYear = 12;

		BigDecimal interestRate = repayRequestDTO.getNominalRate().divide(new BigDecimal("100.00"),
				MathContext.DECIMAL128);

		BigDecimal totalLoanTermInYears = BigDecimal.valueOf(repayRequestDTO.getDuration()).divide(new BigDecimal("12"),
				MathContext.DECIMAL128);

		BigDecimal r = interestRate.divide(BigDecimal.valueOf(repaymentsPerYear), MathContext.DECIMAL128);

		int n = totalLoanTermInYears.multiply(BigDecimal.valueOf(repaymentsPerYear)).intValue();
		BigDecimal fact1 = (r.add(BigDecimal.ONE)).pow(n);
		BigDecimal fact2 = repayRequestDTO.getLoanAmount().multiply(r).multiply(fact1);
		BigDecimal fact3 = fact1.subtract(BigDecimal.ONE);

		return fact2.divide(fact3, 2, RoundingMode.HALF_EVEN);

	}

	public BigDecimal interestForMonth(BigDecimal nominalRate, BigDecimal principal) {

		BigDecimal interestRate = nominalRate.divide(new BigDecimal("100.00"), MathContext.DECIMAL128);
		BigDecimal interestForMonth = interestRate.multiply(principal).divide(new BigDecimal("12"), 2,
				RoundingMode.HALF_EVEN);
		return interestForMonth;

	}

}
