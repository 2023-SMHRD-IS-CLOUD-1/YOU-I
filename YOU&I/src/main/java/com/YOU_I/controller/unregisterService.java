package com.YOU_I.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.YOU_I.model.User_DAO;
import com.YOU_I.model.User_DTO;

public class unregisterService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		String u_id = request.getParameter("id");
		String u_pw = request.getParameter("pw");

		User_DTO u_DTO = new User_DTO();
		u_DTO.setId(u_id);
		u_DTO.setPw(u_pw);

		User_DAO dao = new User_DAO();
		int res = dao.unregister(u_DTO);
		
		if(res>0) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.print("{\"name\":\""+res+"\"}");
			
		}

		return null;
	}

}
