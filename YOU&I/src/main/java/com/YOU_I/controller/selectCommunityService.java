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

public class selectCommunityService implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			community_DAO dao = new community_DAO();
			community_DTO dto = new community_DTO();
			
			String group = request.getParameter("groupNo");
			int groupNo = Integer.parseInt(group);
			
			dto.setGroupNo(groupNo);
			List<community_DTO> resultList = dao.selectAll(dto);
			
			Gson gson = new GsonBuilder().serializeNulls().create();
			String selectCommunityJson = gson.toJson(resultList);
			
			request.setAttribute("resultList", resultList);
			response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(selectCommunityJson);
		    
			return null;
		
	
	}
	
}
