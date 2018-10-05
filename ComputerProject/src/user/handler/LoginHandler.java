package user.handler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.collections.SynchronizedStack;

import common.exception.LoginFailException;
import common.handler.CommandHandler;
import user.model.User;
import user.service.LoginService;

public class LoginHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/loginForm.jsp";

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

	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
		LoginService loginService = LoginService.getInstance();
		String loginId = req.getParameter("loginId").trim();
		String password = req.getParameter("password").trim();
		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		req.setAttribute("errors", errors);
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		try {
			User user = loginService.login(loginId, password);
			req.getSession().setAttribute("user", user);
			resp.sendRedirect("main.jsp");
			return null;
		} catch (LoginFailException e) {
			errors.put("idOrPwNotMatch", true);
			return FORM_VIEW;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse resp) {
		return FORM_VIEW;
	}
}
