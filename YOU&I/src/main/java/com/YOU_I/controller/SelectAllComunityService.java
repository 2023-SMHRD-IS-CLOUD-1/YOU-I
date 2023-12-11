package com.YOU_I.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.YOU_I.model.community_DAO;
import com.YOU_I.model.community_DTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SelectAllComunityService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		community_DAO dao = new community_DAO();
		int resultList = dao.GetlastCommNo();
		
		Gson gson = new GsonBuilder().serializeNulls().create();
		String selectCommunityJson = gson.toJson(resultList);
		
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(selectCommunityJson);
		return null;
		
	}

}
