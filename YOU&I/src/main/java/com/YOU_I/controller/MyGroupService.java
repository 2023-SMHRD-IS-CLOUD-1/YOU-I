package com.YOU_I.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.YOU_I.model.Group_DAO;
import com.YOU_I.model.Group_DTO;
import com.YOU_I.model.User_DTO;
import com.google.gson.Gson;

public class MyGroupService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("id");

		User_DTO u_dt = new User_DTO();
		u_dt.setId(user_id);
		
		Group_DAO dao = new Group_DAO();
		List<Group_DTO> myGroup_dto = dao.MyGroup(u_dt);
		
		

		if (myGroup_dto.isEmpty()) {
			out.print("false");
		} else {
			Gson gson = new Gson();
			String result= gson.toJson(myGroup_dto);
			out.print(result);
		}
		return null;
	}

}
