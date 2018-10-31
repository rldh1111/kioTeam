package payment.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import payment.service.PaymentRequest;
import payment.service.PaymentService;
import product.model.Product;
import product.service.ProductReadSerivce;
import user.model.User;
import user.service.UserReadSerivce;

public class PaymentHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int userId = Integer.parseInt(req.getParameter("userId"));
		int productId = Integer.parseInt(req.getParameter("productId"));
		int count = Integer.parseInt(req.getParameter("count"));
		String pageNum = req.getParameter("pageNum");
		int pageNo = 1;
		if(pageNum != null) {
			pageNo = Integer.parseInt(pageNum);
		}
		UserReadSerivce userReadSerivce = UserReadSerivce.getInstance();
		User user = userReadSerivce.readUser(userId);
		ProductReadSerivce productReadSerivce = ProductReadSerivce.getInstance();
		Product product = productReadSerivce.readProduct(productId);
		PaymentService paymentService = PaymentService.getInstance();
		PaymentRequest paymentRequest = new PaymentRequest(userId, user.getName(), productId, product.getProductName(),
				count, product.getPrice() * count, user.getAddress(), user.getPhone(), product.getUrl());
		paymentService.payment(paymentRequest);
		return "/WEB-INF/script/buySuccess.jsp";
	}

}
