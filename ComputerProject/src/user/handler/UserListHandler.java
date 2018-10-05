package user.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import product.service.ProductListService;
import product.service.ProductPage;
import user.service.UserListService;
import user.service.UserPage;

public class UserListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println();
		UserListService userListService = UserListService.getInstance();
		String pageNum = req.getParameter("pageNum");
		int pageNo = 1;
		if (pageNum != null) {
			pageNo = Integer.parseInt(pageNum);
		}
		UserPage userPage = userListService.UserList(pageNo);
		req.setAttribute("userPage", userPage);
		return "/WEB-INF/admin/userList.jsp";
	}

}
