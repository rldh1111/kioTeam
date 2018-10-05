package product.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import product.service.ProductViewService;

public class ProductViewHandler implements CommandHandler {
	private static final String FORM_VIEW = "#"; // 어드민 페이지로 이동

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println();
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, resp);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, resp);
		} else {
			resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) {
		ProductViewService productViewService = ProductViewService.getInstance();
		productViewService.selectProduct(Integer.parseInt(req.getParameter("productId")));
		return null;
	}

	private String processForm(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return FORM_VIEW;
	}
}
