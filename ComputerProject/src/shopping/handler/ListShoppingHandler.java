package shopping.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import shopping.service.ListShoppingService;
import shopping.service.ShoppingPage;
import user.model.User;

public class ListShoppingHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ListShoppingService shoppingService = ListShoppingService.getInstance();
		
		String pageNoStr = req.getParameter("pageNo");
		User user = (User) req.getSession(false).getAttribute("user");
		
		
		int pageNo = 1;
		if(pageNoStr != null) {
			pageNo = Integer.parseInt(pageNoStr);
		}
		ShoppingPage shoppingPage = shoppingService.getShoppingPage(pageNo, user.getLoginId());
		req.setAttribute("shoppingPage",shoppingPage);
		return "/shoppinglist.jsp";
	}

}
