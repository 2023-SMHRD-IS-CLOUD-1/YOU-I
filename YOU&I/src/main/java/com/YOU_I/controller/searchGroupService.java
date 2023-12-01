package com.YOU_I.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.YOU_I.model.Group_DAO;
import com.YOU_I.model.Group_DTO;
import com.google.gson.Gson;

public class searchGroupService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		response.setContentType("text/html;charset=utf-8");
		
		String sendGroupName= request.getParameter("sendGroupName");
		Group_DTO dto = new Group_DTO() ;
		dto.setGroupName(sendGroupName);
		System.out.println(sendGroupName);
		Group_DAO dao = new Group_DAO();
		List<Group_DTO> allGroups = dao.searchGroup(dto);
		Gson gson = new Gson();
		String allgroupJson = gson.toJson(allGroups);
		System.out.println(allgroupJson);
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(allgroupJson);
		
		return null;
	}

}
