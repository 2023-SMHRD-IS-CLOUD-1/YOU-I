package com.YOU_I.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.YOU_I.model.Group_DAO;
import com.YOU_I.model.Group_DTO;

public class addGroupService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String groupName = request.getParameter("groupName");
		String groupInfo = request.getParameter("groupInfo");
		String hobby = request.getParameter("hobbyName");
		int hobbyNo = Integer.parseInt(hobby);
		System.out.println(hobby);
		System.out.println(hobbyNo);
		Group_DTO dto = new Group_DTO();
		dto.setGroupName(groupName);
		dto.setGroupInfo(groupInfo);
		dto.setHobbyNo(hobbyNo);
		
		Group_DAO dao = new Group_DAO();
		
		dao.addGroup(dto);
		int generatedKey = dto.getGroupNo();
		HttpSession session = request.getSession();
		session.setAttribute("groupNo", generatedKey);
		System.out.println(generatedKey);
		
		return "redirect:/groupKing.do";
		
	}
	

}
