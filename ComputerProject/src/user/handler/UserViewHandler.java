package user.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.exception.UserNotFoundException;
import user.model.User;
import user.service.UserViewSerivice;

public class UserViewHandler {
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
		return null;
	}

	private String processForm(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			UserViewSerivice userViewSerivice = UserViewSerivice.getInstance();
			int userId = Integer.parseInt(req.getParameter("userId"));
			User user = userViewSerivice.selectUser(userId);
			req.setAttribute("user", user);
		} catch (UserNotFoundException e) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return FORM_VIEW;
	}
}
