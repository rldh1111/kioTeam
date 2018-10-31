package product.handler;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.exception.DuplicatieException;
import common.handler.CommandHandler;
import product.service.RegisterRequest;
import product.service.RegisterService;

public class RegisterHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/admin/productRegisterForm.jsp"; // 어드민 페이지로 이동

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

	private String processForm(HttpServletRequest req, HttpServletResponse resp) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
		RegisterRequest registerRequest = new RegisterRequest(req.getParameter("name"),req.getParameter("type"), req.getParameter("productType"),
		Integer.parseInt(req.getParameter("price")), req.getParameter("explanation"),"img/"+req.getParameter("url"));
		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		req.setAttribute("errors", errors);
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		try {

			RegisterService registerService = RegisterService.getInstance();
			registerService.insert(registerRequest);
			return "/WEB-INF/script/productRegisterSuccess.jsp";
		} catch (DuplicatieException e) {
			errors.put("sameProduct", true);
			return FORM_VIEW;
		}

	}
}
