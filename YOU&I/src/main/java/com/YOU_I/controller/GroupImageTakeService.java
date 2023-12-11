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

public class GroupImageTakeService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		String data = request.getParameter("data");
		
		String[] Ldata = data.split(",");
		int i = 0;
		for(String a : Ldata) {
			Ldata[i] = "fileS3Group"+a;
			i++;
		}
		
		List<String> LData = new ArrayList<String>();
		LData = Arrays.asList(Ldata);
		
		File_DAO f_dao = new File_DAO();
		List<File_DTO> resultData = new ArrayList<File_DTO>();
		
		for(String a : LData) {
			File_DTO temp_dto = f_dao.GroupImageTake(a); 
			if(temp_dto != null) {
				resultData.add(temp_dto);				
			} else {
				resultData.add(null);								
			}
		}
		
		
		
		Gson gson = new Gson();
		String result= gson.toJson(resultData);
		
		out.print(result);
		
		return null;
	}

}
