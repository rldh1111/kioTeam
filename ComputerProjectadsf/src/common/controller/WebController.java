package common.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.handler.CommandHandler;
import common.handler.NullHandler;

public class WebController extends HttpServlet {
	private Map<String, CommandHandler> hMap = new HashMap<>();

	public void init() throws ServletException {
		// 핸들러와 커맨드 명령어 정보가 있는 프로퍼티 파일을 프로퍼티 객체에 담기
		Properties prop = new Properties();
		String configFilePath = getServletContext().getRealPath(getInitParameter("handlerConfigFile"));
		System.out.println(configFilePath);
		try (FileReader fr = new FileReader(configFilePath)) {
			prop.load(fr);
			// 프로퍼티에 담긴 아이를 hMap에 객체로 만들어서 담음
			for (Object key : prop.keySet()) {
				Class cl = Class.forName(prop.getProperty((String) key));
				hMap.put((String) key, (CommandHandler) cl.getDeclaredConstructor().newInstance());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

	// 여기서는 get,post를 하나로 통합해서 작업을 하고
	// 추후에 핸들러에서 구분을 하여 로직을 분기처리 할 예정.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);

	}

	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String command = req.getRequestURI();
		System.out.println(command);
		CommandHandler handler = null;
		if (command.indexOf(req.getContextPath()) == 0) {
			command = command.substring(req.getContextPath().length());
			// substring(시작, 인덱스) -> 시작인덱스부터~끝까지를 반환.
		}
		System.out.println("command: " + command);
		// 핸들러 객체를 담을 핸들러 변수
		if (command == null) {
			// 명령어가 없을 때 NullHandler를 통해 처리!
			handler = new NullHandler();
		} else {
			// 명령어가 들어오면 해당 명령어를 키로하는 맵에서 핸들러 객체를 받아옴!
			handler = hMap.get(command);
		}
		// 핸들러를 통해 요청에 해당되는 작업를 하고 결과 화면 주소를 받아옴.
		String viewPage = null;
		try {
			viewPage = handler.process(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 결과 페이지로 전환시킴
		if (viewPage != null) {
			RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
			dispatcher.forward(req, resp);
		}

	}

}
