package com.YOU_I.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.YOU_I.model.User_DAO;
import com.YOU_I.model.User_DTO;
import com.google.gson.Gson;

public class UserMyPageService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(); 
		String user_id = (String)session.getAttribute("id");
		User_DTO u_dt = new User_DTO();
		u_dt.setId(user_id);
		
		User_DAO dao = new User_DAO();
		User_DTO result =dao.userMypg(u_dt);
		
		Gson gson = new Gson();
		String res = gson.toJson(result);
		out.print(res);
		
		
		return null;
	}

}
