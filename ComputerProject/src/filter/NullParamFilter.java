package filter;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class NullParamFilter implements Filter {

	private String[] parameterNames = null;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig fc) throws ServletException {
		// TODO Auto-generated method stub
		String names = fc.getInitParameter("parameterNames");
		StringTokenizer st = new StringTokenizer(names, ",");
		parameterNames = new String[st.countTokens()];
		for (int i = 0; st.hasMoreTokens(); i++) {
			parameterNames[i] = st.nextToken();

		}
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		NullParameterRequestWrapper requestWrapper = new NullParameterRequestWrapper((HttpServletRequest) req);
		// web.xml에서 인자로 넣었던 id, name 파라미터가 null인지 check!
		requestWrapper.checkNull(parameterNames);
		// 우리가 변경한 요청정보를 reqeust대신 전달한다.
		chain.doFilter(requestWrapper, resp);

	}

}
