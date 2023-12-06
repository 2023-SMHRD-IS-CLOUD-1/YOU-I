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
		System.out.println(fileRoot);
		System.out.println(fileOriRoot);
		System.out.println(fileDate);
		System.out.println(fileS3Root);		
		
		int commNo = 14;
		try {
			String tempcommNo = request.getParameter("commNo");
			if(!tempcommNo.isEmpty()) {
			System.out.println(tempcommNo + "commNo 값 받아옴");
			commNo = Integer.parseInt(tempcommNo);
			commNo += 1;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		
		File_DTO f_dto = new File_DTO();
		
		int fileIndex = 0;
		int fileEndIndex = 0;
		int ThumFileIndex = 0;
		int ThumFileEndIndex = 0;
		String fileExtension = "";
		String ThumFileRoot = "";
		try {
		System.out.println(fileOriRoot+".jpg 자르기 시작");
		fileIndex = fileOriRoot.indexOf('.');
		System.out.println(fileIndex);
		fileEndIndex = fileOriRoot.length();
		System.out.println(fileEndIndex);
		
		System.out.println("파일루트 자르기시작");
		ThumFileIndex = fileRoot.indexOf('/');
		ThumFileEndIndex = fileRoot.length();
		fileExtension = fileOriRoot.substring(fileIndex, fileEndIndex);
		System.out.println(".jpg 자름");
		ThumFileRoot = fileRoot.substring(ThumFileIndex, ThumFileEndIndex);
		System.out.println("파일루트 자름");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		f_dto.setCommNo(commNo);
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
