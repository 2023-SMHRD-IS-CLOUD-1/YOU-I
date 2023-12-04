package com.YOU_I.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.YOU_I.model.community_DAO;
import com.YOU_I.model.community_DTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class commentService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		String comment_content = request.getParameter("comment_content");
		String Lastcomm_no = request.getParameter("Lastcomm_no");
		Gson gson = new GsonBuilder().serializeNulls().create();
		String commentJson = gson.toJson(comment_content);
		System.out.println(commentJson);
		System.out.println("hihi"+session.getAttribute("comm_no"));
		int comm_no = (int) session.getAttribute("comm_no");
		int Lastcomm_no1 = Integer.parseInt(Lastcomm_no); 
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(commentJson);
		community_DTO dto = new community_DTO();
		dto.setComment_content(commentJson);
		dto.setComm_no(Lastcomm_no1);
		community_DAO dao = new community_DAO();
		dao.comment(dto);
		//System.out.println(comm_no);
		
		
		return "redirect:/Gocommunity.do";
	}

}