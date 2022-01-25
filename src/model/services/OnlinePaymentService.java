package model.services;


public interface OnlinePaymentService {
	/*
	public ContractService contractService = new ContractService();
	public PaypalService paypalServices = new PaypalService();
	*/
	
	public double paymentFee(double amount);
	
	public double interest(double amount, int months);
}
