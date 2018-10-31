package shopping.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import product.model.Product;
import product.service.ReadProductService;
import shopping.service.ShoppingInsertService;
import shopping.service.ShoppingRequest;
import user.model.User;
import user.service.UserReadSerivce;

public class ShoppingTypeInsertHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int userId = Integer.parseInt(req.getParameter("userId"));
		int productId = Integer.parseInt(req.getParameter("productId"));
		int count = Integer.parseInt(req.getParameter("count"));
		UserReadSerivce serivce = UserReadSerivce.getInstance();
		User user = serivce.readUser(userId);
		ReadProductService readProductService = ReadProductService.getInstance();
		Product product = readProductService.readProduct(productId);
		String pageNum = req.getParameter("pageNum");
		int pageNo = 1	;
		if (pageNum != null) {
			pageNo = Integer.parseInt(pageNum);
		}
		ShoppingRequest shoppingRequest = new ShoppingRequest(userId, user.getName(), productId, product.getProductType(),
				product.getProductName(), product.getPrice(), count, product.getExplanation(),
				product.getUrl());

		ShoppingInsertService shoppingInsertService = ShoppingInsertService.getInstance();
		shoppingInsertService.insert(shoppingRequest);
		return "typeList?type=" + product.getType() + "&pageNum=" + pageNo;

	}
}
