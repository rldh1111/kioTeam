package product.handler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.exception.ProductNotFoundException;
import common.handler.CommandHandler;
import product.model.Product;
import product.service.SearchService;

public class SearchHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/searchList.jsp"; // 어드민 페이지로 이동

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

	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {

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

	private String processForm(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.sendRedirect("main.jsp");
		return null;
	}
}
