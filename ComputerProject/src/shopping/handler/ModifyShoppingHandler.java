package shopping.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import shopping.service.DeleteRequest;
import shopping.service.DeleteShoppingService;
import shopping.service.ModifyRequest;
import shopping.service.ModifyShoppingService;

public class ModifyShoppingHandler implements CommandHandler {

		private static final String FORM_VIEW = "/Ckpayment.jsp";

		@Override
		public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
			String prStr = req.getParameter("productId");
			String cuStr =req.getParameter("count");
			int pr = Integer.parseInt(prStr);
			int cu = Integer.parseInt(cuStr);
			
			ModifyRequest mr = new ModifyRequest(pr, cu);
			
			ModifyShoppingService modifyShoppingService = ModifyShoppingService.getInstance();
			modifyShoppingService.modify(mr);
			return FORM_VIEW;
			
			
			

		}



	


}
