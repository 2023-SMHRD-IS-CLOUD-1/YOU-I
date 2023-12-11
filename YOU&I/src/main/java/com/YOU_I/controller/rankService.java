package com.YOU_I.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.YOU_I.model.Group_DAO;
import com.YOU_I.model.Group_DTO;
import com.google.gson.Gson;

public class rankService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		Group_DAO dao = new Group_DAO();
		List<Group_DTO> gr_dto = dao.rank();

		PrintWriter out = response.getWriter();
		
		if (gr_dto.isEmpty()) {
			out.print("false");
		} else {
			Gson gson = new Gson();
			String result= gson.toJson(gr_dto);
			out.print(result);
		}

		return null;
	}
}
