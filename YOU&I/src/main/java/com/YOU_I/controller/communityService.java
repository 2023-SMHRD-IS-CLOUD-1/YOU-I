package com.YOU_I.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.YOU_I.model.community_DAO;
import com.YOU_I.model.community_DTO;

public class communityService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		String result = (String)session.getAttribute("id");
		String group = request.getParameter("groupNo");
		int groupNo = Integer.parseInt(group);
		String commContent = request.getParameter("commContent");
		
		
		community_DTO dto = new community_DTO();
		dto.setId(result);
		dto.setGroupNo(groupNo);
		dto.setCommContent(commContent);
		
		community_DAO dao = new community_DAO();
		dao.commContent(dto);
		
		int generatedKey = dto.getComm_no();
		
		session.setAttribute("comm_no", generatedKey);
		
		return "redirect:/Gocommunity.do?groupNo="+groupNo;
	}
	
	
	
}