package com.YOU_I.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.YOU_I.model.calendar_DAO;
import com.YOU_I.model.calendar_DTO;

public class addScheduleService implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.addHeader("Access-Control-Allow-Origin","*");
        request.setCharacterEncoding("utf-8");
        String content = request.getParameter("calendar_content");
        String startDateString = request.getParameter("calendar_start_date");
        String endDateString = request.getParameter("calendar_end_date");
        String memo = request.getParameter("calendar_memo");

        calendar_DTO dto = new calendar_DTO();
        dto.setScheTitle(content);

        if (isValidDateString(startDateString)) {
            dto.setScheStDate(parseDateString(startDateString));
        }

        if (isValidDateString(endDateString)) {
            dto.setScheEndDate(parseDateString(endDateString));
        }

        dto.setScheContent(memo);
        
        calendar_DAO dao = new calendar_DAO();
        dao.addSchedule(dto);

        return "calendar";
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
    
    
}