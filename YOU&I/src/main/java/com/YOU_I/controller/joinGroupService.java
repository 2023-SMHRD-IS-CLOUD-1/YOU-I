package com.YOU_I.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.YOU_I.model.join_DAO;
import com.YOU_I.model.join_DTO;

public class joinGroupService implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		
		String id =request.getParameter("selectGroup");
		String oriId = (String)session.getAttribute("id");
		String group = request.getParameter("groupNo");
		int groupNo = Integer.parseInt(group);
		
		join_DTO dto = new join_DTO();
		dto.setId(id);
		dto.setGroupNo(groupNo);
		
		join_DAO dao = new join_DAO();
		int result = dao.joinGroup(dto);
		
		if(result>0 && oriId.equals(id)) {
			session.setAttribute("levelNo", 22);
			response.setContentType("application/json"); 
		    response.setCharacterEncoding("UTF-8");
			response.getWriter().write("{\"redirectUrl\": \"Gomainpg.do\"}");
			return null;
			
		}else {
				
			return "searchgroup.do";
		}
		
		
		
		
	}

}
