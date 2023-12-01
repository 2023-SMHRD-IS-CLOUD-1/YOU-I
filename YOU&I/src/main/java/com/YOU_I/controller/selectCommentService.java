package com.YOU_I.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.YOU_I.model.community_DAO;
import com.YOU_I.model.community_DTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class selectCommentService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		community_DAO dao = new community_DAO();
		List<community_DTO>selectComment = dao.selectComment();
		Gson gson = new GsonBuilder().serializeNulls().create();
		String selectcommentJson = gson.toJson(selectComment);
		request.setAttribute("selectComment", selectComment);
		response.setContentType("application/json");
		response.getWriter().write(selectcommentJson);
		System.out.println("댓글리스트");
		//for(int i =0; i<selectComment.size(); i++) {
		//	System.out.println(selectComment.get(i).getCommentContent());
		//}
		
		return null;

	}

}