package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entityes.Contract;
import model.entityes.Installment;

public class ContractService {
	
/*	private PaypalService paymentService = new PaypalService();
	 AUTO ACOPLAMENTO*/
	
	private OnlinePaymentService onlinePaymentService;
	
	// INJEÇÃO DE DEPEDENCIA ( inversao de controle)
	public ContractService(OnlinePaymentService onlinePaymentService ) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContract(Contract contract, int months) {
		double basicQuota = contract.getTotalValue() / months;
		// basicQuota = 200
		for(int i = 1; i <= months; i++) {
			Date dueDate = addMonths(contract.getDate(), i);
			double updateQuota = basicQuota + onlinePaymentService.interest(basicQuota, i);
			// updateQuota = 202
			double fullQuota = updateQuota + onlinePaymentService.paymentFee(updateQuota);
			// 206.04
		
			contract.getInstallment().add(new Installment(dueDate, fullQuota) );
			
		}
	}
	private Date addMonths(Date date, int N) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, N);
		return calendar.getTime();
		
	}
}
