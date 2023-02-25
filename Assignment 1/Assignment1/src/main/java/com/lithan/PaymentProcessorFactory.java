package com.lithan;

public class PaymentProcessorFactory {
	private final GooglePayProcessor gpp = new GooglePayProcessor();
	private final CreditCardProcessor ccp = new CreditCardProcessor();
	public PaymentProcessor getPaymentProcessor(String mode) {
		if("gpay".equalsIgnoreCase(mode)) {
			return gpp;
		}else if("credit_card".equalsIgnoreCase(mode)) {
			return ccp;
		}else {
			return null;
		}
	}
}
