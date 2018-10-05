package product.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.exception.ProductNotFoundException;
import common.handler.CommandHandler;
import product.service.DeleteService;

public class DeleteHandler implements CommandHandler {
	private static final String FORM_VIEW = "productList"; // 어드민 페이지로 이동

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		try {
			System.out.println();
			int userId = Integer.parseInt(req.getParameter("userId"));
			DeleteService deleteService = DeleteService.getInstance();
			deleteService.delete(userId);
			return FORM_VIEW;
		} catch (ProductNotFoundException e) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return FORM_VIEW;
		}
	}
}
