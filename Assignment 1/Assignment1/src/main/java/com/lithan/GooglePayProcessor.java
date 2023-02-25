package com.lithan;

public class GooglePayProcessor implements PaymentProcessor {
	@Override
	public boolean process() {
		System.out.println("Paying Using GooglePay");
		return true;
	}
}
