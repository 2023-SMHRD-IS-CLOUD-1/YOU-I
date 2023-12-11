package com.YOU_I.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.YOU_I.model.User_DAO;
import com.YOU_I.model.User_DTO;

public class LoginService implements Command {

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");

		String u_id = request.getParameter("userId");
		String u_pw = request.getParameter("password");

		User_DTO u_DTO = new User_DTO();
		u_DTO.setId(u_id);
		u_DTO.setPw(u_pw);

		User_DAO u_DAO = new User_DAO();

		User_DTO result_DTO = u_DAO.user_Login(u_DTO);

		if (result_DTO != null) {
			
			request.setAttribute("Login", result_DTO);
			session.setAttribute("id", u_id);
			String result = (String)session.getAttribute("id");
			
			return "redirect:/Gomainpg.do";
		} else {
			return "redirect:/Gologin.do";
		}

	}

}
