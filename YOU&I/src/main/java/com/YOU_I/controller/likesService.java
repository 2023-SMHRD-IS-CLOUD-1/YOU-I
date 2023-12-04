package com.YOU_I.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.YOU_I.model.community_DAO;
import com.YOU_I.model.community_DTO;


public class likesService implements Command {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String likes = request.getParameter("likes");
		String likesNo = request.getParameter("likesNo");
		community_DTO dto = new community_DTO();
		int likesz = Integer.parseInt(likes); 
		int likeszNo = Integer.parseInt(likesNo); 
		dto.setLikes(likesz+1);
		dto.setComm_no(likeszNo);;
		community_DAO dao = new community_DAO();
		int row = dao.likes(dto);
		
		
		
		return null;

	}

}
