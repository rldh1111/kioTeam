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
		String pageNum = req.getParameter("pageNum");
		int userId = Integer.parseInt(req.getParameter("userId"));
		String sum = req.getParameter("sumprice");
		System.out.println(sum);
		int sumprice = 0;
		if(sum != null ) {
			sumprice = Integer.parseInt(sum);
		}
		int pageNo = 1;
		if(pageNum != null) {
			pageNo = Integer.parseInt(pageNum);
		}
		req.setAttribute("sumPrice", sumprice);
		ShoppingPage shoppingPage = shoppingService.getShoppingPage(pageNo, userId);
		req.getSession().setAttribute("shoppingPage",shoppingPage);
		return "/WEB-INF/view/shoppingList.jsp";
	}

}
