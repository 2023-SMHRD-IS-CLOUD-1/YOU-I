package com.YOU_I.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.YOU_I.model.Hobby_DAO;
import com.YOU_I.model.Hobby_DTO;
import com.google.gson.Gson;

public class SelectAllHobbyNameService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String data = request.getParameter("data");
		System.out.println("요청옴" + data);
		
		Hobby_DAO h_dao = new Hobby_DAO();
		
		List<Hobby_DTO> h_dto = h_dao.SelectAllHobbyName();
		Gson gson = new Gson();
		String result = gson.toJson(h_dto);
		if(!result.isEmpty()) {
			out.print(result);
		}else {
			System.out.println("실패");
		}
		
		return null;
	}

}
