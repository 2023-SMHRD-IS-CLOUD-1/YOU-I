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
		System.out.println("사용자 id"+id);
		int groupNO = (int) session.getAttribute("groupNo");
		System.out.println("그룹넘버"+groupNO);
		join_DTO dto = new join_DTO();
		dto.setId(id);
		dto.setGroupNo(groupNO);
		join_DAO dao = new join_DAO();
		
		Gson gson = new Gson();
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    try {
            List<join_DTO> userList = dao.getUserInfo(dto);
            if (userList != null && !userList.isEmpty()) {
                for (join_DTO user : userList) {
                    System.out.println("User ID: " + user.getId());
                    System.out.println("User GroupNo: " + user.getGroupNo());
                    // 나머지 필드에 대한 출력 추가
                }
                String resultJson = gson.toJson(userList);
                System.out.println(resultJson);
                response.getWriter().write(resultJson);
            } else {
                System.out.println("User list is empty.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
		
		
		
	
}
