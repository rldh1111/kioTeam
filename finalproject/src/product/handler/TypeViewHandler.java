package product.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import product.service.ProductListService;
import product.service.ProductPage;
import product.service.TypeViewService;
import user.model.User;

public class TypeViewHandler implements CommandHandler {
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String pageNum = req.getParameter("pageNum");
		String type = req.getParameter("type");
		
		int pageNo = 1;
		if (pageNum != null) {
			pageNo = Integer.parseInt(pageNum);
		}
		TypeViewService typeViewService = TypeViewService.getInstance();
		ProductPage productPage = typeViewService.TypeList(pageNo, type);
		req.setAttribute("productPage", productPage);
		
		return "/WEB-INF/view/typeView.jsp";
	}

}
