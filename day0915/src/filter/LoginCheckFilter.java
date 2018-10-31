package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {

	// 필터를 초기화 할 때 부르는 아이!
	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("로그인체크 doFilter 시작");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
		boolean isLogin = false;
		if (session != null) {
			if (session.getAttribute("member") != null) {
				isLogin = true;
			}
		}
		if (isLogin) {
			// 처음 요청한 jsp나, 다음 필터로 이동!!
			chain.doFilter(request, response);
		} else {
			// 로그인을 하지 않았으면 로그인을 하는 화면으로 돌려보냄!
			RequestDispatcher dispater = request.getRequestDispatcher("/loginForm.jsp");
			dispater.forward(request, response);
		}
		System.out.println("로그인체크 doFilter 끝");
	}

	// 필터가 삭제될 때 호출되는 아이!
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
}
