package product.handler;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.exception.ProductNotFoundException;
import common.handler.CommandHandler;
import product.model.Product;
import product.service.SearchService;

public class SearchHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/searchList.jsp";

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println();
		try {
			String search = req.getParameter("search");
			SearchService searchService = SearchService.getInstance();
			ArrayList<Product> products = searchService.search(search);
			req.setAttribute("productList", products);
			return FORM_VIEW;
		} catch (ProductNotFoundException e) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
}
