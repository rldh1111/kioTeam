package filter;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class NullParameterRequestWrapper extends HttpServletRequestWrapper {
	// 파라미터를 받은 아이들은 검사해서 null 값이 있다면!!
	// 빈 값으로 변경!
	private Map<String, String[]> paramMap = null;

	public NullParameterRequestWrapper(HttpServletRequest request) {
		super(request);
		// 기존 파라미터를 맵으로 받음!
		// 값이 있는 애들만 키와 값이 맵으로 넘어오고
		paramMap = new HashMap<String, String[]>(request.getParameterMap());
	}

	// null값이 있는지 없는지 확인하는 메소드 구현!
	public void checkNull(String[] parameterNames) {
		// parameterNames => id, pwd, email
		// paramMap => id, pwd
		for (int i = 0; i < parameterNames.length; i++) {
			// 파라미터맵에 해당되는 키값을 찾아서 없다면!
			if (!paramMap.containsKey(parameterNames[i])) {
				// 빈문자열을 갖는 1개짜리 배열로 만들어 넣음
				String[] values = new String[] { "" };
				// 파라미터 네임에는 있지만, 맵에 없는 아이의 값을 추가로 넣음.
				paramMap.put(parameterNames[i], values);
			}
		}
	}

	@Override
	public String getParameter(String name) {
		// TODO Auto-generated method stub
		// 파라미터 values에 있는 String 배열에서 index가 0 인 아이를 반환해주면 됨!
		// 우리가 재 정의한 getParameterValues를 이용해서 값을 배열로 받음!
		String[] values = getParameterValues(name);
		if (values != null && values.length > 0) {
			return values[0];
		} else {
			return null;
		}

	}

	@Override
	public Map<String, String[]> getParameterMap() {
		// TODO Auto-generated method stub
		return paramMap;
	}

	@Override
	public Enumeration<String> getParameterNames() {
		// TODO Auto-generated method stub
		return Collections.enumeration(paramMap.keySet());
	}

	@Override
	public String[] getParameterValues(String name) {
		// TODO Auto-generated method stub
		return (String[]) paramMap.get(name);
	}

}
