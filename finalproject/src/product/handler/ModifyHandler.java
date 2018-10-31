package product.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.exception.DuplicatieException;
import common.exception.ProductNotFoundException;
import common.handler.CommandHandler;
import product.dao.ProductDao;
import product.model.Product;
import product.service.ModifyRequest;
import product.service.ModifyService;
import product.service.ProductReadSerivce;

public class ModifyHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/admin/productModifyForm.jsp"; // 어드민 페이지로 이동

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

	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		int productId = Integer.parseInt(req.getParameter("productId"));
		ModifyRequest modifyRequest = new ModifyRequest(productId, req.getParameter("type"), req.getParameter("productName"),
				req.getParameter("productType"), Integer.parseInt(req.getParameter("price")),
				req.getParameter("explanation"), req.getParameter("url"));
		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		req.setAttribute("errors", errors);
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		try {
			ModifyService modifyService = ModifyService.getInstance();
			modifyService.modify(modifyRequest);
			return "/WEB-INF/script/productModifySuccess.jsp";
		} catch (DuplicatieException e) {
			errors.put("duplicateName", true);
			return "productList";
		} catch (ProductNotFoundException e) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return FORM_VIEW;
		}

	}

	private String processForm(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int productId = Integer.parseInt(req.getParameter("productId"));
		try {
			ProductReadSerivce productReadSerivce = ProductReadSerivce.getInstance();
			
			Product product = productReadSerivce.readProduct(productId);

			ModifyRequest modifyRequest = new ModifyRequest(productId,product.getType(), product.getProductName(), product.getProductType(),
					product.getPrice(), product.getExplanation(), product.getUrl());
			req.setAttribute("modReq", modifyRequest);
		} catch (ProductNotFoundException e) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return FORM_VIEW;
	}
}
