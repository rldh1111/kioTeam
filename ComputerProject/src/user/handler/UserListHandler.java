package user.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.service.UserListService;

public class UserListHandler {
	private static final String FORM_VIEW = "#";

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

	private String processForm(HttpServletRequest req, HttpServletResponse resp) {
		UserListService listService = UserListService.getInstance();
		//페이지 리스트 가져와야됨 나중에함
		return FORM_VIEW;
	}
}
