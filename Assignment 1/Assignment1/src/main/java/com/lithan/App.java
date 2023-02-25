package com.lithan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
	private static ApplicationContext context =new ClassPathXmlApplicationContext("config.xml");
	
    public static void main( String[] args )
    {
    	BillingService bs= (BillingService) context.getBean("billingService");
    	bs.complatePayment();
    }
}
