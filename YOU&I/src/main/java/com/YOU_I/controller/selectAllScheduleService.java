package com.YOU_I.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.YOU_I.model.calendar_DAO;
import com.YOU_I.model.calendar_DTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class selectAllScheduleService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin","*");	
	calendar_DAO dao = new calendar_DAO();
	List<calendar_DTO> allSchedules = dao.getSchedules();
	System.out.println(allSchedules);
	Gson gson = new GsonBuilder().serializeNulls().create();
	String allSchedulesJson = gson.toJson(allSchedules);
	System.out.println(allSchedulesJson);
	response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(allSchedulesJson);
		
		
		return null;
	}

}
