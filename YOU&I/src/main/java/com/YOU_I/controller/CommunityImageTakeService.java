package com.YOU_I.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.YOU_I.model.File_DAO;
import com.YOU_I.model.File_DTO;
import com.google.gson.Gson;

public class CommunityImageTakeService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();
		String data = request.getParameter("groupNo");
		System.out.println(data + "---------------커뮤니티 이미지 테이크 서비스");

		File_DAO f_dao = new File_DAO();
		List<File_DTO> resultData = f_dao.CommunityImageTake(data);
		System.out.println(data + "============================foreach List");

		System.out.println(resultData);
		Gson gson = new Gson();
		String result = gson.toJson(resultData);

		out.print(result);

		return null;
	}
}
