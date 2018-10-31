package product.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import product.service.ProductListService;
import product.service.ProductPage;
import product.service.ProductTypeViewService;

public class ProductTypeViewHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/productView.jsp";

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ProductTypeViewService productTypeViewService = ProductTypeViewService.getInstance();
		String pageNum = req.getParameter("pageNum");
		String productType = req.getParameter("productType");
		int pageNo = 1;
		if (pageNum != null) {
			pageNo = Integer.parseInt(pageNum);
		}
		ProductPage productPage = productTypeViewService.selectType(productType, pageNo);
		req.setAttribute("productPage", productPage);
		return FORM_VIEW;
	}
}
