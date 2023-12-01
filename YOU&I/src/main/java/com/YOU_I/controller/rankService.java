package com.YOU_I.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.YOU_I.model.Group_DAO;
import com.YOU_I.model.Group_DTO;
import com.google.gson.Gson;

public class rankService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		Group_DAO dao = new Group_DAO();
		List<Group_DTO> gr_dto = dao.rank();
		System.out.println(gr_dto);

		PrintWriter out = response.getWriter();
		
		
//		Map<String, String> dataMap = new HashMap<>();
//		
//		String data = request.getParameter("data");
//		System.out.println("요청받은 데이터 >> " + data);

		if (gr_dto.isEmpty()) {
			out.print("false");
		} else {
			// Gson객체 생성
			Gson gson = new Gson();
			// 사용
			String result= gson.toJson(gr_dto);
			System.out.println(result);
			out.print(result);
//				// 데이터를 Map 형태로 변환하여 리스트에 추가
//				for (Group_DTO a : gr_dto) {
//					dataMap.put("groupCt", a.getGroupCategory());
//					dataMap.put("groupLikes", String.valueOf(a.getGroupLikes()));
//					dataMap.put("groupName", a.getGroupName());
//					out.print("{\"groupCt\":\""+dataMap.get("groupCt") +"\"," + "\"groupLikes\":\""+dataMap.get("groupLikes") +"\"," + "\"groupName\":\""+dataMap.get("groupName") +"\"}");
//				}
		}

		return null;

//		return "redirect:/Gomain.do";
	}
}
