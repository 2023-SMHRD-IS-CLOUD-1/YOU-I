package com.YOU_I.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.YOU_I.model.Group_DTO;
import com.YOU_I.model.User_DAO;
import com.YOU_I.model.User_DTO;
import com.google.gson.Gson;

public class memberInfoService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		request.setCharacterEncoding("utf-8");

		String groupNo = request.getParameter("groupNo");
		int groupNo1 = Integer.parseInt(groupNo);

		User_DTO dto = new User_DTO();
		dto.setGroupNo(groupNo1);

		User_DAO dao = new User_DAO();
		List<User_DTO> res = dao.member(dto);


		if (res.isEmpty()) {
			out.print("false");
		} else {
			Gson gson = new Gson();
			String result = gson.toJson(res);
			out.print(result);
		}
		return null;
	}

}
