package com.schedule.loan.content;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.schedule.loan.dto.BaseDTO;
import com.schedule.loan.dto.LoanRepayResponseDTO;
import com.schedule.loan.dto.LoanRepaySchedule;

public class CSVContentPublisher extends AbstractContentPublisher<BaseDTO> {

	@Override
	public ResponseEntity<Object> publish(BaseDTO entity, String mediaType) throws Exception {

		InputStream stream = null;
		InputStreamResource resource = null;

		ResponseEntity<Object> responseEntity = null;
		try {

			HttpHeaders headers = new HttpHeaders();

			StringBuilder csvContent = new StringBuilder(
					"INSTALLAMENT NO, BORROWER PAY AMT, PAY DATE, INIT OUSTANDING PRINCIPAL, INTEREST, PRINCIPAL, REMAIN OUSTSTANDING PRINCIPAL \n ");
			if (entity instanceof BaseDTO) {

				LoanRepayResponseDTO repayResponse = (LoanRepayResponseDTO) entity;
				List<LoanRepaySchedule> schedules = repayResponse.getRepaySchedule();

				schedules.stream().forEach(param -> {
					csvContent.append(param.getInstallmentNumber()).append(",").append(param.getBorrowerPaymentAmount())
							.append(",").append(param.getDate()).append(",")
							.append(param.getInitialOutstandingPrincipal()).append(",").append(param.getInterest())
							.append(",").append(param.getPrincipal()).append(",")
							.append(param.getRemainingOutstandingPrincipal()).append("\n");
				});

			}

			stream = new ByteArrayInputStream(csvContent.toString().getBytes("UTF-8"));

			resource = new InputStreamResource(new BufferedInputStream(stream));
			headers.add("Content-Disposition", String.format("attachment; filename=repaySchedule.csv"));
			headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
			headers.add("Pragma", "no-cache");
			headers.add("Expires", "0");

			responseEntity = ResponseEntity.ok().headers(headers).contentLength(csvContent.toString().getBytes().length)
					.contentType(MediaType.parseMediaType(mediaType)).body(resource);

		} catch (Exception e) {
			responseEntity = new ResponseEntity<Object>("Content Generation Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {

			if (stream != null) {
				stream.close();
			}

		}
		return responseEntity;

	}

}
