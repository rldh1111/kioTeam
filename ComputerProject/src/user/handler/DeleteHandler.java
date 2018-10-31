package user.handler;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.exception.UserNotFountException;
import common.handler.CommandHandler;
import user.service.DeleteService;

public class DeleteHandler implements CommandHandler {
	private static final String FORM_VIEW = "userList"; // 어드민 페이지로 이동

	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		try {
			int userId = Integer.parseInt(req.getParameter("userId"));
			DeleteService deleteService = DeleteService.getInstance();
			deleteService.delete(userId);
			return "/WEB-INF/script/userDeleteSuccess.jsp";
		} catch (UserNotFountException e) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}

}
