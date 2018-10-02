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
		User user = (User) req.getSession().getAttribute("user");
		ModifyRequest modifyRequest = new ModifyRequest(user.getUserId(), req.getParameter("name").trim(),
				req.getParameter("password").trim(), req.getParameter("address").trim(),
				req.getParameter("email").trim(), req.getParameter("phone").trim(), req.getParameter("question").trim(),
				req.getParameter("answer").trim());
		req.setAttribute("modReq", modifyRequest);
		ModifyService modifyService = ModifyService.getInstance();
		modifyService.modify(modifyRequest);
		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		req.setAttribute("errors", errors);
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		resp.sendRedirect("main.jsp");
		return null;

	}

	private String processForm(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			User user = (User) req.getSession().getAttribute("user");
			ModifyRequest modifyRequest = new ModifyRequest(user.getUserId(), user.getName(), user.getPassword(),
					user.getAddress(), user.getEmail(), user.getPhone(), user.getQuestion(), user.getAnswer());
			req.setAttribute("modReq", modifyRequest);
			System.out.println("form: "+ user);
			return FORM_VIEW;
		} catch (UserNotFountException e) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}

	}
}
