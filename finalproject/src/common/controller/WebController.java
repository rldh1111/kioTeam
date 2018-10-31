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
		
		Properties prop = new Properties();
		String configFilePath = getServletContext().getRealPath(getInitParameter("handlerConfigFile"));
		System.out.println(configFilePath);
		try (FileReader fr = new FileReader(configFilePath)) {
			prop.load(fr);
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
		}
		System.out.println("command: " + command);
		if (command == null) {
			handler = new NullHandler();
		} else {
			handler = hMap.get(command);
		}
		String viewPage = null;
		try {
			viewPage = handler.process(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (viewPage != null) {
			RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
			dispatcher.forward(req, resp);
		}

	}

}
