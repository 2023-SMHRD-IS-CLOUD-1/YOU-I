package com.YOU_I.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.YOU_I.model.join_DAO;
import com.YOU_I.model.join_DTO;

public class groupKingService implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		int groupNo = (int) session.getAttribute("groupNo");
		String id = (String) session.getAttribute("id");
		
		join_DTO dto = new join_DTO();
		dto.setGroupNo(groupNo);
		dto.setId(id);
		
		join_DAO dao = new join_DAO();
		dao.groupKing(dto);
		session.setAttribute("levelNo", 21);
		
		
		return "redirect:/GogroupSchedules.do";
	}

	
	
	
	
}
