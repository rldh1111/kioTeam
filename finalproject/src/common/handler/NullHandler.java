package common.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NullHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		return null;
	}

}
