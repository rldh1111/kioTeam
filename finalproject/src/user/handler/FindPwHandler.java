package user.handler;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import user.model.User;
import user.service.FindPwService;

//password 찾는 handler
public class FindPwHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/view/findPw.jsp";

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

	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) {
		FindPwService findPwService = FindPwService.getInstance();
		try {
			User user = findPwService.FindPw(req.getParameter("loginId"), req.getParameter("phone"),
					req.getParameter("email"), req.getParameter("question"), req.getParameter("answer"));
			req.setAttribute("user", user);
			return "/WEB-INF/script/findPwSuccess.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
