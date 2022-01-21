package model.service;

public class PaypalService {

	public Double paymentFee(Double amount) {
		return amount;
	}
	
	public Double interest(Double amount, Integer months) {
		return amount * months;
		
	}
}
