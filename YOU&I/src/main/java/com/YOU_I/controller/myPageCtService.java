package com.YOU_I.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.YOU_I.model.Group_DAO;
import com.YOU_I.model.Group_DTO;
import com.YOU_I.model.Hobby_DAO;
import com.YOU_I.model.Hobby_DTO;
import com.google.gson.Gson;

public class myPageCtService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		Hobby_DAO dao = new Hobby_DAO();
		List<Hobby_DTO> mypg_dto = dao.mypgCt();
		System.out.println(mypg_dto);

		PrintWriter out = response.getWriter();
		

		if (mypg_dto.isEmpty()) {
			out.print("false");
		} else {
			Gson gson = new Gson();
			String result= gson.toJson(mypg_dto);
			System.out.println(result);
			out.print(result);
		}

		return null;

	
	}

}
