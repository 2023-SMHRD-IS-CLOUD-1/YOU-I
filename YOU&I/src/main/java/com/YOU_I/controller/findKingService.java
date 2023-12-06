package com.YOU_I.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.YOU_I.model.join_DAO;
import com.YOU_I.model.join_DTO;
import com.google.gson.Gson;

public class findKingService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		join_DTO dto = new join_DTO();
		String group = request.getParameter("groupNo");
		int groupNo = Integer.parseInt(group);
		System.out.println("findkinggroupNo"+groupNo);
		String id = (String) session.getAttribute("id");
		dto.setGroupNo(groupNo);
		dto.setId(id);
		join_DAO dao = new join_DAO();
		dao.findKing(dto);
		join_DTO findKingData = dao.findKing(dto);

	    Gson gson = new Gson();
	    String json = gson.toJson(findKingData);

	    response.setContentType("application/json");
	    response.setCharacterEncoding("utf-8");
	    response.getWriter().write(json);
		
		
		return null;
	}

}
