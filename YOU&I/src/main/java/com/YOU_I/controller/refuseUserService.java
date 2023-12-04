package com.YOU_I.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.YOU_I.model.join_DAO;
import com.YOU_I.model.join_DTO;

public class refuseUserService implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		System.out.println("삭제할 ID"+id);
		String group = request.getParameter("groupNo");
		int groupNo = Integer.parseInt(group);
		join_DTO dto = new join_DTO();
		System.out.println("삭제할ID의그룹넘버"+groupNo);
		dto.setId(id);
		dto.setGroupNo(groupNo);
		join_DAO dao = new join_DAO();
		dao.refuseUser(dto);
		
		
		
		
		return null;
	}

}
