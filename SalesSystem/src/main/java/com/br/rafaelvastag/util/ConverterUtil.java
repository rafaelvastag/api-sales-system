package com.br.rafaelvastag.util;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class ConverterUtil {
	

	public BigDecimal stringToBigDecimal(String value) {
		
		try {
			value = value.replace(".", "").replace(",", ".");

			return new BigDecimal(value);
		} catch (Exception e) {

			return null;
		}
	}
	
}
