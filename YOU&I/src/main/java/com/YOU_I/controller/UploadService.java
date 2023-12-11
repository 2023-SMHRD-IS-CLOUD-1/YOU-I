package com.YOU_I.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.YOU_I.model.File_DAO;
import com.YOU_I.model.File_DTO;
import com.google.gson.Gson;

public class UploadService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String fileRoot = request.getParameter("filename");
		String fileOriRoot = request.getParameter("fileOriName");
		String fileDate = request.getParameter("fileDate");
		String fileS3Root = request.getParameter("fileS3root");
		
		int commNo = 14;
		try {
			String tempcommNo = request.getParameter("commNo");
			if(!tempcommNo.isEmpty()) {
			commNo = Integer.parseInt(tempcommNo);
			commNo += 1;
			}
		} catch (Exception e) {
		}	
		
		File_DTO f_dto = new File_DTO();
		
		int fileIndex = 0;
		int fileEndIndex = 0;
		int ThumFileIndex = 0;
		int ThumFileEndIndex = 0;
		String fileExtension = "";
		String ThumFileRoot = "";
		
		try {
		fileIndex = fileOriRoot.indexOf('.');
		fileEndIndex = fileOriRoot.length();
		
		ThumFileIndex = fileRoot.indexOf('/');
		ThumFileEndIndex = fileRoot.length();
		fileExtension = fileOriRoot.substring(fileIndex, fileEndIndex);
		ThumFileRoot = fileRoot.substring(ThumFileIndex, ThumFileEndIndex);
		}
		catch (Exception e) {
		}
		
		f_dto.setCommNo(commNo);
		f_dto.setFileName(fileRoot);
		f_dto.setFileOriName(fileOriRoot);
		f_dto.setFileThumb(ThumFileRoot);
		f_dto.setFileS3Path(fileS3Root);
		f_dto.setFileSize(0);
		f_dto.setExt(fileExtension);
		f_dto.setUploadedAt(fileDate);
		
		File_DAO f_dao = new File_DAO();
		
		int result = f_dao.fileUpload(f_dto);
		if(result >0) {
			Gson gson = new Gson();
			String jsonresult= gson.toJson(result);
			out.print(jsonresult);
			return null;
		} else {
			return null;
		}
			
		
	}

}
