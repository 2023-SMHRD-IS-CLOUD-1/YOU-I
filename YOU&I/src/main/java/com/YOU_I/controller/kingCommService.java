package com.YOU_I.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.YOU_I.model.join_DAO;
import com.YOU_I.model.join_DTO;
import com.google.gson.Gson;


public class kingCommService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("id");
		String group= request.getParameter("groupNo");
		int groupNo = Integer.parseInt(group);
		
		join_DTO dto = new join_DTO();
		dto.setId(id);
		dto.setGroupNo(groupNo);
		
		join_DAO dao = new join_DAO();
		
		Gson gson = new Gson();
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    
	    try {
            List<join_DTO> userList = dao.getUserInfo(dto);
            if (userList != null && !userList.isEmpty()) {
                String resultJson = gson.toJson(userList);
                response.getWriter().write(resultJson);
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
		
		
		
	
}
