package shopping.handler;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import shopping.model.Shopping;
import shopping.service.ShoppingRequest;
import shopping.service.ShoppingService;
import user.model.User;

public class ShoppingHandler implements CommandHandler {

	private static final String FORM_VIEW = "/main.jsp";

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, resp);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, resp);
		} else {
			resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) {
		User user = (User) req.getSession(false).getAttribute("user");
		ShoppingRequest shoppingRequest = new ShoppingRequest(Integer.parseInt(req.getParameter("productId")),
				req.getParameter("productType"),user.getLoginId(), req.getParameter("productName"), Integer.parseInt(req.getParameter("price")),
				Integer.parseInt(req.getParameter("count")));

		ShoppingService shoppingService = ShoppingService.getInstance();
		shoppingService.insert(shoppingRequest);
		return FORM_VIEW;
	}

}
