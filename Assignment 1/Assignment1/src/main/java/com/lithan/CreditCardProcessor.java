package com.lithan;

public class CreditCardProcessor implements PaymentProcessor {

	@Override
	public boolean process() {
		System.out.println("Paying Using Credit Card");
		return true;
	}

}
