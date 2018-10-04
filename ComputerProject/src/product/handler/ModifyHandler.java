package product.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.exception.DuplicatieException;
import common.exception.ProductNotFoundException;
import product.service.ModifyRequest;
import product.service.ModifyService;

public class ModifyHandler {
	private static final String FORM_VIEW = "#"; // 어드민 페이지로 이동

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

	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) {
		return FORM_VIEW;
	}

	private String processForm(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int productId = Integer.parseInt(req.getParameter("productId"));
		ModifyRequest modifyRequest = new ModifyRequest(productId, req.getParameter("name"),
				req.getParameter("productType"), Integer.parseInt(req.getParameter("price")),
				req.getParameter("explanation"));
		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		req.setAttribute("errors", errors);
		try {
			ModifyService modifyService = ModifyService.getInstance();
			modifyService.modify(modifyRequest);
		} catch (ProductNotFoundException e) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		} catch (DuplicatieException e) {
			errors.put("duplicateName", true);
			return FORM_VIEW;
		}
		return FORM_VIEW;
	}
}
