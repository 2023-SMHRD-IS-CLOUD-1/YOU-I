package com.YOU_I.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.YOU_I.model.Group_DAO;
import com.YOU_I.model.Group_DTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class getGroupNameService implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Group_DTO dto = new Group_DTO();
		String group = request.getParameter("groupNo");
		int groupNo = Integer.parseInt(group);
		dto.setGroupNo(groupNo);
		Group_DAO dao = new Group_DAO();
		Group_DTO dto2 = dao.getGroupName(dto);
		System.out.println("sssssssssssssssssssssss"+groupNo);
		Gson gson = new Gson();
		String result = gson.toJson(dto2);
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(result);
		
		return null;
	}

}
