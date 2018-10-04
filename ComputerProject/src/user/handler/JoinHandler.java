package user.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import common.exception.DuplicatieException;
import common.handler.CommandHandler;
import user.service.JoinRequest;
import user.service.JoinService;

public class JoinHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/joinForm.jsp";

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

	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		JoinRequest joinRequest = new JoinRequest(req.getParameter("userType"), req.getParameter("loginId"),
				req.getParameter("name"), req.getParameter("password"), req.getParameter("address"),
				req.getParameter("email"), req.getParameter("phone"), req.getParameter("question"),
				req.getParameter("answer"));
		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		req.setAttribute("errors", errors);
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		JoinService joinService = JoinService.getInstance();
		try {
			joinService.join(joinRequest);
			resp.sendRedirect("login");
			return null;
		} catch (DuplicatieException e) {
			errors.put("duplicateId", true);
			return FORM_VIEW;
		}

	}

}
