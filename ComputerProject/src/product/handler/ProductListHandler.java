package product.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import product.service.ProductListService;
import product.service.ProductPage;

public class ProductListHandler implements CommandHandler {
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ProductListService productListService = ProductListService.getInstance();
		String pageNum = req.getParameter("pageNum");
		int pageNo = 1;
		if (pageNum != null) {
			pageNo = Integer.parseInt(pageNum);
		}

		ProductPage productPage = productListService.ProductList(pageNo);
		req.setAttribute("productPage", productPage);
		return "/WEB-INF/admin/productList.jsp";
	}

}
