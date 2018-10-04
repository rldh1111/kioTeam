package user.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.exception.UserNotFountException;
import common.handler.CommandHandler;
import user.service.DeleteService;

public class DeleteHandler implements CommandHandler {
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

	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			int userId = Integer.parseInt(req.getParameter("userId"));
			DeleteService deleteService = DeleteService.getInstance();
			deleteService.delete(userId);
			return FORM_VIEW;
		} catch (UserNotFountException e) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse resp) {
		return FORM_VIEW;
	}

}
