package model.service;


public interface OnlinePaymentService {
	
	public ContractService contractService = new ContractService();
	public PaypalService paypalServices = new PaypalService();
	
	
	public Double paymentFee(Double amount);
	
	public Double interest(Double amount, Integer months);
}
