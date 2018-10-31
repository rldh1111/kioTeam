package user.handler;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.exception.UserNotFountException;
import common.handler.CommandHandler;
import user.service.DeleteService;

public class DeleteHandler implements CommandHandler {
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		try {
			int userId = Integer.parseInt(req.getParameter("userId"));
			String pageNum = req.getParameter("pageNum");
			int pageNo = 1;
			if(pageNum != null) {
				pageNo = Integer.parseInt(pageNum);
			}
			DeleteService deleteService = DeleteService.getInstance();
			deleteService.delete(userId);
			return "userList?pageNum="+pageNo;
		} catch (UserNotFountException e) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}

}
