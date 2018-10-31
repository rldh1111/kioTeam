package payment.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import payment.service.PaymentRequest;
import payment.model.Payment;
import payment.service.PaymentInsertService;
import shopping.model.Shopping;
import user.model.User;
import user.service.UserReadSerivce;

public class PaymentInsertHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ArrayList<Shopping> shoppings = new ArrayList<Shopping>();
		shoppings = (ArrayList<Shopping>) req.getAttribute("shoppingPage");
		User user = (User) req.getSession(false).getAttribute("user");
		UserReadSerivce userReadSerivce = UserReadSerivce.getInstance();
		User userr = userReadSerivce.readUser(user.getUserId());
		ArrayList<PaymentRequest> payments = new ArrayList<PaymentRequest>();
		PaymentInsertService paymentService = PaymentInsertService.getInstance();
		for (int i = 0; i < shoppings.size(); i++) {
			payments.add(new PaymentRequest(shoppings.get(i).getProductId(), shoppings.get(i).getProductname(),
					shoppings.get(i).getCount(), shoppings.get(i).getPrice(), userr.getUserId(),
					shoppings.get(i).getLoginId(), userr.getName(), userr.getAddress(), userr.getPhone()));
		}
		paymentService.payment(payments);

		resp.sendRedirect("main.jsp");
		return null;

	}

}
