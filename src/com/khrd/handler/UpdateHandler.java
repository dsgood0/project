package com.khrd.handler;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khrd.controller.CommandHandler;
import com.khrd.dao.ProjectDAO;
import com.khrd.dto.Project;
import com.khrd.jdbc.ConnectionProvider;
import com.khrd.jdbc.JDBCUtil;

public class UpdateHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equalsIgnoreCase("get")) {
			String sNo = request.getParameter("no");
			int no = Integer.parseInt(sNo);
			
			Connection conn = null;
			
			try {
				conn = ConnectionProvider.getConnection();
				ProjectDAO dao = ProjectDAO.getInstance();
				Project project = dao.SelectById(conn, no);
				request.setAttribute("project", project);
				
				return "/WEB-INF/view/updateForm.jsp";
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn);
			}
			
			return null;
			
		} else if(request.getMethod().equals("post")) {
			request.setCharacterEncoding("utf-8");
			String sNo = request.getParameter("no");
			int no = Integer.parseInt(sNo);
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String Start_date = request.getParameter("start_date");
			String End_date = request.getParameter("end_date");
			String state = request.getParameter("state");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			Date start_date = sdf.parse(Start_date);
			Date end_date = sdf.parse(End_date);
			
			Connection conn = null;
			
			try {
				conn = ConnectionProvider.getConnection();
				ProjectDAO dao = ProjectDAO.getInstance();
				Project project = new Project(no, title, content, start_date, end_date, state);
				dao.update(conn, project);
				
				response.sendRedirect(request.getContextPath() + "/list.do");
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn);
			}
		}
		return null;
	}

}
