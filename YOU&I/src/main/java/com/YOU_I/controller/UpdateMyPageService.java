package com.YOU_I.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.YOU_I.model.User_DAO;
import com.YOU_I.model.User_DTO;


public class UpdateMyPageService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession(); 
		String user_id = (String) session.getAttribute("id");
		String nick =request.getParameter("nick");
		String phone =request.getParameter("phone");
		String region =request.getParameter("region");
		String ct1 =request.getParameter("ct1");
		String user_profile =request.getParameter("userprofile");
		
		User_DTO u_dt = new User_DTO();
		u_dt.setId(user_id);
		u_dt.setNick(nick);
		u_dt.setPhone(phone);
		u_dt.setRegion(region);
		u_dt.setHobby(ct1);
		u_dt.setProfileImg(user_profile);
		
		User_DAO dao = new User_DAO();
		int row = dao.update(u_dt);
		
		
		
		if(row > 0 ) {
			return "redirect:/Gomypg.do";
		}
		else {
			return "redirect:/Gomypg.do";
		}
		

		
	}

}
