package product.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import product.service.ProductListService;
import product.service.ProductPage;
import user.model.User;

public class ProductListHandler implements CommandHandler {
	

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		String pageNum = req.getParameter("pageNum");
		int pageNo = 1;
		if (pageNum != null) {
			pageNo = Integer.parseInt(pageNum);
		}
		ProductListService productListService = ProductListService.getInstance();
		ProductPage productPage = productListService.ProductList(pageNo);
		req.setAttribute("productPage", productPage);
		return "/WEB-INF/admin/productList.jsp";
	}

}
