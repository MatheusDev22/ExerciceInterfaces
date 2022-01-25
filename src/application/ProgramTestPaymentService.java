package application;

import model.services.OnlinePaymentService;
import model.services.PaypalService;

public class ProgramTestPaymentService {

	public static void main (String[] args) {
		
		OnlinePaymentService ps = new PaypalService();
		
		System.out.printf("paymentFee: R$ %.2f", ps.paymentFee(200.00 ) );
		System.out.println();
		System.out.printf("interest..: R$ %.2f", ps.interest(200.00, 3) );
		
		
	}
}
