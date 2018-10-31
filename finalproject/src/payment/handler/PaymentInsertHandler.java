package payment.handler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import payment.service.PaymentRequest;
import payment.model.Payment;
import payment.service.PaymentInsertService;
import shopping.model.Shopping;
import shopping.service.DeleteAllShoppginService;
import shopping.service.ShoppingPage;
import shopping.service.ShoppingReadService;
import user.model.User;
import user.service.UserReadSerivce;

public class PaymentInsertHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int userId = Integer.parseInt(req.getParameter("userId"));
		ShoppingReadService shoppingReadService = ShoppingReadService.getInstance();
		DeleteAllShoppginService allShoppginService = DeleteAllShoppginService.getInstance();
		UserReadSerivce userReadSerivce = UserReadSerivce.getInstance();
		User user = userReadSerivce.readUser(userId);
		ArrayList<Shopping> shoppings = shoppingReadService.readShopping(userId);
		ArrayList<PaymentRequest> payments = new ArrayList<PaymentRequest>();
		PaymentInsertService paymentService = PaymentInsertService.getInstance();
		for (int i = 0; i < shoppings.size(); i++) {
			payments.add(new PaymentRequest(shoppings.get(i).getUserId(), shoppings.get(i).getUserName(),
					shoppings.get(i).getProductId(), shoppings.get(i).getProductName(), shoppings.get(i).getCount(),
					shoppings.get(i).getPrice(), user.getAddress(), user.getPhone(), shoppings.get(i).getUrl()));
		}
		paymentService.payment(payments);
		allShoppginService.deleteAll(userId);

		return "/WEB-INF/script/paymentSuccess.jsp";

	}

}
