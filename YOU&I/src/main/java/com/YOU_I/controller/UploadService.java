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
				
		
		File_DTO f_dto = new File_DTO();
		
		System.out.println(fileOriRoot+".jpg 자르기 시작");
		int fileIndex = fileOriRoot.indexOf('.');
		System.out.println(fileIndex);
		int fileEndIndex = fileOriRoot.length();
		System.out.println(fileEndIndex);
		String fileExtension = fileOriRoot.substring(fileIndex, fileEndIndex);
		System.out.println(".jpg 자름");
		
		System.out.println("파일루트 자르기시작");
		int ThumFileIndex = fileRoot.indexOf('/');
		int ThumFileEndIndex = fileRoot.length();
		String ThumFileRoot = fileRoot.substring(ThumFileIndex, ThumFileEndIndex);
		System.out.println("파일루트 자름");
		
		f_dto.setCommNo(14);
		f_dto.setFileName(fileRoot);
		f_dto.setFileOriName(fileOriRoot);
		f_dto.setFileThumb(ThumFileRoot);
		f_dto.setFileS3Path(fileS3Root);
		f_dto.setFileSize(0);
		f_dto.setExt(fileExtension);
		f_dto.setUploadedAt(fileDate);
		
		
		System.out.println(f_dto.getCommNo());
		System.out.println(f_dto.getFileName());
		System.out.println(f_dto.getFileOriName());
		System.out.println(f_dto.getFileThumb());
		System.out.println(f_dto.getFileS3Path());
		System.out.println(f_dto.getFileSize());	
		System.out.println(f_dto.getExt());
		System.out.println(f_dto.getUploadedAt());

		
		File_DAO f_dao = new File_DAO();
		
		int result = f_dao.fileUpload(f_dto);
		System.out.println(result);
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
