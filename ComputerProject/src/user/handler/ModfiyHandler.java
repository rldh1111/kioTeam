package user.handler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.exception.UserNotFountException;
import common.handler.CommandHandler;
import user.model.User;
import user.service.ModifyRequest;
import user.service.ModifyService;
import user.service.UserReadSerivce;

public class ModfiyHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/view/modifyForm.jsp";

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
		int userId = Integer.parseInt(req.getParameter("userId"));
		ModifyRequest modifyRequest = new ModifyRequest(userId, req.getParameter("name").trim(),
				req.getParameter("password").trim(), req.getParameter("address").trim(),
				req.getParameter("email").trim(), req.getParameter("phone").trim(), req.getParameter("question").trim(),
				req.getParameter("answer").trim());
		req.setAttribute("modReq", modifyRequest);
		try {
			ModifyService modifyService = ModifyService.getInstance();
			modifyService.modify(modifyRequest);
			resp.sendRedirect("main.jsp");
			return null;
		} catch (UserNotFountException e) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}

	}

	private String processForm(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
		try {
			int userId = Integer.parseInt(req.getParameter("userId"));
			UserReadSerivce readUserSerivce = UserReadSerivce.getInstance();
			User user = readUserSerivce.readUser(userId);
			ModifyRequest modifyRequest = new ModifyRequest(user.getUserId(), user.getName(), user.getPassword(),
					user.getAddress(), user.getEmail(), user.getPhone(), user.getQuestion(), user.getAnswer());
			req.setAttribute("modReq", modifyRequest);
			return FORM_VIEW;
		} catch (UserNotFountException e) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}

	}
}
