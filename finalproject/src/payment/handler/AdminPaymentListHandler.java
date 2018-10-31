	package payment.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import payment.service.PaymentListService;
import payment.service.PaymentPage;
import user.model.User;

public class AdminPaymentListHandler implements CommandHandler {


	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		String pageNum = req.getParameter("pageNum");

		int pageNo = 1;
		if (pageNum != null) {
			pageNo = Integer.parseInt(pageNum);
		}	
		PaymentListService paymentListService = PaymentListService.getInstance();
		PaymentPage paymentPage = paymentListService.paymentList(pageNo);
		req.setAttribute("paymentPage", paymentPage);

		return "/WEB-INF/admin/paymentList.jsp";
	}

}
