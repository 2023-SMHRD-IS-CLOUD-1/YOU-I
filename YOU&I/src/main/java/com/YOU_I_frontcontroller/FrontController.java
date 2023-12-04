package com.YOU_I_frontcontroller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.YOU_I.controller.Command;
import com.YOU_I.controller.GroupImageTakeService;
import com.YOU_I.controller.JoinService;
import com.YOU_I.controller.LoginService;
import com.YOU_I.controller.MyGroupService;
import com.YOU_I.controller.SelectAllHobbyNameService;
import com.YOU_I.controller.UpdateMyPageService;
import com.YOU_I.controller.UploadService;
import com.YOU_I.controller.UserMyPageService;
import com.YOU_I.controller.addGroupService;
import com.YOU_I.controller.addScheduleService;
import com.YOU_I.controller.commentService;
import com.YOU_I.controller.communityService;
import com.YOU_I.controller.groupKingService;
import com.YOU_I.controller.joinGroupService;
import com.YOU_I.controller.rankCtService;
import com.YOU_I.controller.rankService;
import com.YOU_I.controller.searchGroupService;
import com.YOU_I.controller.selectAllScheduleService;
import com.YOU_I.controller.selectCommentService;
import com.YOU_I.controller.selectCommunityService;
import com.YOU_I.controller.unregisterService;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HashMap<String, Command> map = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
	
		
		map = new HashMap<String, Command>();
		map.put("Join.do", new JoinService());
		map.put("Login.do", new LoginService());
		map.put("addGroup.do", new addGroupService());
		map.put("addSchedule.do", new addScheduleService());
		map.put("selectAllScheduleService.do", new selectAllScheduleService());
		map.put("rank.do", new rankService());
		map.put("rankCt.do", new rankCtService());
		map.put("Upload.do", new UploadService());
		map.put("community.do", new communityService());
		map.put("SelectAllHobbyName.do", new SelectAllHobbyNameService());
		map.put("searchGroup.do", new searchGroupService());
		map.put("groupKing.do", new groupKingService());
		map.put("GroupImageTake.do", new GroupImageTakeService());
		map.put("selectCommunity.do", new selectCommunityService());
		map.put("comment.do", new commentService());
		map.put("selectComment.do",new selectCommentService());
		map.put("UpdateMyPage.do", new UpdateMyPageService());
		map.put("UserMyPage.do", new UserMyPageService());
		map.put("unregister.do", new unregisterService());
		map.put("MyGroup.do", new MyGroupService());
		map.put("joinGroup.do",new joinGroupService());
		
	}
	
		
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String cp = request.getContextPath();
		
		int cp_lenght = cp.length() + 1;
		String finaluri = uri.substring(cp_lenght);
		
		System.out.println(finaluri);
		String path = null;
		Command com = null;
		
		
		if(finaluri.contains("Go")) {
			
			path = finaluri.substring(2).replaceAll(".do","");
			System.out.println("Go"+path);
		} else {
			com = map.get(finaluri);
			path = com.execute(request, response);
			System.out.println("error");
			System.out.println("NoGo"+path);
		}
		
		if(path == null) {
			System.out.println("ajax");
		} else if (path.contains("redirect:/")) {
			System.out.println(path.substring(10));
			response.sendRedirect(path.substring(10));
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/" + path + ".html");
			rd.forward(request, response);
		}
	}
}
