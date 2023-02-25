package com.lithan;

public class BillingService{
	private PaymentProcessor paymentProcessor;
	
//	Default Constructur
	public BillingService() {}
//	Constructer
	public BillingService(PaymentProcessor paymentProcessor) {
		super();
		this.paymentProcessor = paymentProcessor;
	}
	public boolean complatePayment() {
		return paymentProcessor.process();
	}
//	Getter
	public PaymentProcessor getPaymentProcessor() {
		return paymentProcessor;
	}
//	Setter
	public void setPaymentProcessor(PaymentProcessor paymentProcessor) {
		this.paymentProcessor = paymentProcessor;
	}

	
}