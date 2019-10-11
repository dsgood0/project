package com.khrd.handler;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khrd.controller.CommandHandler;
import com.khrd.dao.ProjectDAO;
import com.khrd.dto.Project;
import com.khrd.jdbc.ConnectionProvider;
import com.khrd.jdbc.JDBCUtil;

public class DeleteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String sNo = request.getParameter("no");
		int no = Integer.parseInt(sNo);

		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			ProjectDAO dao = ProjectDAO.getInstance();
			dao.delete(conn, no);

			response.sendRedirect(request.getContextPath() + "/list.do");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn);
		}

		return null;
	}

}
