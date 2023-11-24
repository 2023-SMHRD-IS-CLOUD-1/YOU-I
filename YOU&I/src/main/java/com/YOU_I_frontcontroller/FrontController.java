package com.YOU_I_frontcontroller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.YOU_I.controller.Command;
import com.YOU_I.controller.JoinService;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HashMap<String, Command> map = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
	
		map = new HashMap<String, Command>();
		map.put("Join.do", new JoinService());
		
		
	}
	
		
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String cp = request.getContextPath();
		
		int cp_lenght = cp.length() + 1;
		String finaluri = uri.substring(cp_lenght);
		
		String path = null;
		
		Command com = null;
		
		if(finaluri.contains("Go")) {
			
			path = finaluri.substring(2).replaceAll(".do","");
		} else {
			com = map.get(finaluri);
			path = com.execute(request, response);
			
		}
		
		if(path == null) {
		} else if (path.contains("redirect:/")) {
			response.sendRedirect(path.substring(10));
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/" + path + ".html");
			rd.forward(request, response);
		}
	}
}