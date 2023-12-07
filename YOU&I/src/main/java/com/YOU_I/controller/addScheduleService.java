package com.YOU_I.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.YOU_I.model.calendar_DAO;
import com.YOU_I.model.calendar_DTO;
import com.google.gson.Gson;

public class addScheduleService implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	
        request.setCharacterEncoding("utf-8");
                                  
        String content = request.getParameter("calendar_content");
        System.out.println(content+"확인용");
        String startDateString = request.getParameter("calendar_start_date");
        System.out.println(startDateString+"확인용");
        String endDateString = request.getParameter("calendar_end_date");
        System.out.println(endDateString+"확인용");
        String memo = request.getParameter("calendar_memo");
        String group = request.getParameter("groupNo");
        int groupNo = Integer.parseInt(group);
        System.out.println("addSchedule그룹넘버 "+groupNo);
        calendar_DTO dto = new calendar_DTO();
        dto.setScheTitle(content);

        if (isValidDateString(startDateString)) {
            dto.setScheStDate(parseDateString(startDateString));
        }

        if (isValidDateString(endDateString)) {
            dto.setScheEndDate(parseDateString(endDateString));
        }

        dto.setScheContent(memo);
        dto.setGroupNo((long) groupNo);
        
        calendar_DAO dao = new calendar_DAO();
        dao.addSchedule(dto);
        
        sendJsonResponse(response, "success");

        return null;
    }

    private boolean isValidDateString(String dateStr) {
        return dateStr != null && dateStr.matches("\\d{4}-\\d{2}-\\d{2}");
    }

    private Date parseDateString(String dateStr) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = dateFormat.parse(dateStr);
            return new java.sql.Date(parsedDate.getTime());
        } catch (ParseException e) {
            // 예외 처리
            e.printStackTrace();
            return null;
        }
    }
    private void sendJsonResponse(HttpServletResponse response, String status) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        Map<String, String> jsonResponse = new HashMap<>();
        jsonResponse.put("status", status);

        response.getWriter().write(new Gson().toJson(jsonResponse));
    }
    
    
}