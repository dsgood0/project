package com.khrd.handler;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khrd.controller.CommandHandler;
import com.khrd.dao.ProjectDAO;
import com.khrd.dto.Project;
import com.khrd.jdbc.ConnectionProvider;
import com.khrd.jdbc.JDBCUtil;

public class ListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			ProjectDAO dao = ProjectDAO.getInstance();
			ArrayList<Project> list = dao.List(conn);
			request.setAttribute("list", list);
			
			return "/WEB-INF/view/list.jsp";	
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn);
		}
		return null;
	}

}
