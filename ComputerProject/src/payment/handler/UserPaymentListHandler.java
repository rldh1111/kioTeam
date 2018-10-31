package payment.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import payment.service.PaymentListService;
import payment.service.PaymentPage;
import payment.service.UserPaymentListService;
import user.model.User;

public class UserPaymentListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String pageNum = req.getParameter("pageNum");
		User user = (User) req.getSession(false).getAttribute("user");
		int pageNo = 1;
		if (pageNum != null) {
			pageNo = Integer.parseInt(pageNum);
		}
		UserPaymentListService userPaymentListService = UserPaymentListService.getInstance();
		PaymentPage paymentPage = userPaymentListService.userPaymentList(user.getUserId(), pageNo);
		req.setAttribute("paymentPage", paymentPage);

		return "/WEB-INF/view/paymentList.jsp";
	}

}
