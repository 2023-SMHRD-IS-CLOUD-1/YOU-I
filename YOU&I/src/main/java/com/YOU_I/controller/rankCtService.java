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

public class rankCtService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String data = request.getParameter("data");
		System.out.println("요청받은 데이터 >> " + data);
		
		Group_DTO gr_dto = new Group_DTO();
		//gr_dto.setGroupCategory(data);
		
		
		Group_DAO dao = new Group_DAO();
		List<Group_DTO> gr_dto2 = dao.rankCt(gr_dto);
		

		PrintWriter out = response.getWriter();
		
		

		if (gr_dto2.isEmpty()) {
			out.print("false");
		} else {
			Gson gson = new Gson();
			String result= gson.toJson(gr_dto2);
			out.print(result);
		}

		return null;

		
	}

}
