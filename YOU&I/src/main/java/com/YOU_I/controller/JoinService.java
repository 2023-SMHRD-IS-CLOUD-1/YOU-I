package com.YOU_I.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.YOU_I.model.User_DAO;
import com.YOU_I.model.User_DTO;

public class JoinService implements Command {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String user_id = request.getParameter("userId");
		String user_pw = request.getParameter("password");
		String user_nick = request.getParameter("nickname");
		String user_gend = request.getParameter("gender");
		String user_dob = request.getParameter("dob");
		String user_phone = request.getParameter("phone");
		String user_hobby = request.getParameter("hobbies");
		String user_area = request.getParameter("area");
		String UserProfileS3root = request.getParameter("UserProfileS3root");
		
		System.out.println(user_gend);
		
		User_DTO u_dto = new User_DTO();
		u_dto.setProfileImg(UserProfileS3root);
		u_dto.setId(user_id);
		u_dto.setPw(user_pw);
		u_dto.setNick(user_nick);
		u_dto.setGender(user_gend);
		u_dto.setJoinedAt(user_dob);
		u_dto.setTutorialSt("0");
		u_dto.setUserRole("0");
		u_dto.setPhone(user_phone);
		u_dto.setHobby(user_hobby);
		u_dto.setRegion(user_area);
		
		
		User_DAO u_dao = new User_DAO();
		int result = u_dao.user_Join(u_dto);
		
		System.out.println("service 접속");
		
		if(result > 0) {
			System.out.println("로그인성공");
			return "redirect:/Gologin.do";
		} else {
			System.out.println("로그인실패");
			return "redirect:/Gologin.do";
			
		}
			
		
	}

}
