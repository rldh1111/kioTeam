package product.handler;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.exception.ProductNotFoundException;
import common.handler.CommandHandler;
import product.service.ProductListService;
import product.service.ProductPage;
import product.service.SearchService;

public class SearchHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/searchList.jsp";

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String pageNum = req.getParameter("pageNum");
		String search = req.getParameter("search");
		int pageNo = 1;
		if (pageNum != null) {
			pageNo = Integer.parseInt(pageNum);
		}
		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		
		req.setAttribute("errors", errors);
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
	
		try {
			ProductListService productListService = ProductListService.getInstance();
			
			SearchService searchService = SearchService.getInstance();
		
			ProductPage productPage = searchService.search(pageNo, search);
			req.setAttribute("productPage", productPage);
			req.setAttribute("search", search);
			return FORM_VIEW;
		} catch (ProductNotFoundException e) {
			errors.put("noProduct", true);
			return FORM_VIEW;
		}
	}
}
