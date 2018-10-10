package shopping.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import shopping.service.DeleteRequest;
import shopping.service.DeleteShoppingService;

public class DeleteShoppingHandler implements CommandHandler {

		private static final String FORM_VIEW = "/shoppinglist.jsp";

		@Override
		public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
			String prStr = req.getParameter("productId");
			int pr = Integer.parseInt(prStr);
			
			DeleteRequest delReq =
					new DeleteRequest(pr);
			req.setAttribute("delReq", delReq);
			
			System.out.println(pr);
			
			DeleteShoppingService deleteShoppingService = DeleteShoppingService.getInstance();
			deleteShoppingService.delete(delReq);
			return FORM_VIEW;

		}



	


}
