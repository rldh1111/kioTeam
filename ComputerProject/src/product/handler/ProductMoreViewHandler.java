/*package product.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import product.service.productMoreViewService;

public class ProductMoreViewHandler implements CommandHandler{
	static final String FORM_VIEW = "/WEB-INF/view/productMoreView.jsp";
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		try {
			int productId = Integer.parseInt(req.getParameter("productId"));
			productMoreViewService productMoreViewService =productMoreViewService.getInstance();
			productMoreViewService.moreView(productId);
		}
	}

}
*/