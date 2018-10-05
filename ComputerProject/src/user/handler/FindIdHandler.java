package user.handler;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import user.model.User;
import user.service.FindIdService;


//Id 찾는 handler
public class FindIdHandler implements CommandHandler {

	private static final String FORM_VIEW = "WEB-INF/view/findId.jsp";
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, resp);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, resp);
		} else {
			resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse resp) {
		return FORM_VIEW;
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) {
		FindIdService findIdService =FindIdService.getInstance();
		try {
			User user = findIdService.FindId(req.getParameter("name"), req.getParameter("phone"), req.getParameter("email"), req.getParameter("question"), req.getParameter("answer"));							
				req.setAttribute("user", user);
				
				return FORM_VIEW;			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
