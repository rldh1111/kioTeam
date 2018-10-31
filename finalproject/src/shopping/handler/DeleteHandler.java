package shopping.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import shopping.service.DeleteRequest;
import shopping.service.DeleteShoppingService;

public class DeleteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int productId = Integer.parseInt(req.getParameter("productId"));
		int userId =  Integer.parseInt(req.getParameter("userId"));
		DeleteShoppingService deleteShoppingService = DeleteShoppingService.getInstance();
		deleteShoppingService.delete(productId, userId);
		return "basket";

	}

}
