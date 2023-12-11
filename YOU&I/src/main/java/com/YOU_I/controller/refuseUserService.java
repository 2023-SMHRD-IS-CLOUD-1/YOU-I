package com.YOU_I.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.YOU_I.model.join_DAO;
import com.YOU_I.model.join_DTO;
import com.google.gson.Gson;

public class refuseUserService implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String group = request.getParameter("groupNo");
		int groupNo = Integer.parseInt(group);
		
		join_DTO dto = new join_DTO();
		dto.setId(id);
		dto.setGroupNo(groupNo);
		
		join_DAO dao = new join_DAO();

		Gson gson = new Gson();
		String jsonResponse = gson.toJson(dao.refuseUser(dto));
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		try (PrintWriter out = response.getWriter()) {
			out.print(jsonResponse);
			out.flush();
		}
		
		
		
		return null;
	}

}
