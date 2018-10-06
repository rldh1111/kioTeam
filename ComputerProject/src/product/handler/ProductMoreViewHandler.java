package product.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.FormView;

import common.exception.ProductNotFoundException;
import common.handler.CommandHandler;
import product.service.ProductMoreViewService;


public class ProductMoreViewHandler implements CommandHandler{
	static final String FORM_VIEW = "/WEB-INF/view/productMoreView.jsp";
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		try {
			int productId = Integer.parseInt(req.getParameter("productId"));
			ProductMoreViewService productMoreViewService = ProductMoreViewService.getInstance();
			productMoreViewService.moreView(productId);
			return FORM_VIEW;
		}catch(ProductNotFoundException e) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}

}
