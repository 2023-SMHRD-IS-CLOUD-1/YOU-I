package com.YOU_I.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.YOU_I.model.community_DAO;
import com.YOU_I.model.community_DTO;

public class communityService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
		 System.out.println("oo");
		String commContent = request.getParameter("commContent");
		community_DTO dto = new community_DTO();
		dto.setCommContent(commContent);
		community_DAO dao = new community_DAO();
		dao.commContent(dto);
		return "redirect:/Gocommunity.do";
	}

}