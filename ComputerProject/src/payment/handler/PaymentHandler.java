package payment.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import payment.service.PaymentRequest;
import payment.service.PaymentService;
import shopping.model.Shopping;


public class PaymentHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ArrayList<Shopping> shoppings = new ArrayList<Shopping>();
		shoppings = (ArrayList<Shopping>) req.getAttribute("shoppingPage");
		PaymentRequest paymentRequest = new PaymentRequest(Integer.parseInt(req.getParameter("paymentId")), Integer.parseInt(req.getParameter("productId")), req.getParameter("productName"), Integer.parseInt(req.getParameter("numbers")), req.getParameter("loginId"),req.getParameter("userName") , req.getParameter("address"), req.getParameter("phone"), shoppings);
		PaymentService paymentService =PaymentService.getInstance();
		paymentService.payment(paymentRequest);
		
		return null;
		
	}

}
