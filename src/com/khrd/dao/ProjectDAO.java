package com.khrd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.khrd.dto.Project;
import com.khrd.jdbc.JDBCUtil;

public class ProjectDAO {
	private static final ProjectDAO dao = new ProjectDAO();
	
	public static ProjectDAO getInstance() {
		return dao;
	}
	
	private ProjectDAO() {
		
	}
	
	public ArrayList<Project> List(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from management;";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			ArrayList<Project> list = new ArrayList<>();
			while(rs.next()) {
				Project project = new Project(rs.getInt("no"), rs.getString("title"), rs.getString("content"),
												rs.getTimestamp("start_date"), rs.getTimestamp("end_date"), rs.getString("state"));
				list.add(project);
			}
			return list;
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt);
			JDBCUtil.close(rs);
		}
		
		return null;
	}
	
	public int insert(Connection conn, Project project) {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into management values (null, ?, ?, ?, ?, ?);";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, project.getTitle());
			pstmt.setString(2, project.getContent());
			pstmt.setTimestamp(3, new Timestamp(project.getStart_date().getTime()));
			pstmt.setTimestamp(4, new Timestamp(project.getEnd_date().getTime()));
			pstmt.setString(5, project.getState());
			return pstmt.executeUpdate();		
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt);
		}
		
		return -1;
	}
	
	public int update(Connection conn, Project project) {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update management set name=?, content=?, start_date=?, end_date=?, state=? where no = ?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, project.getTitle());
			pstmt.setString(2, project.getContent());
			pstmt.setTimestamp(3, new Timestamp(project.getStart_date().getTime()));
			pstmt.setTimestamp(4, new Timestamp(project.getEnd_date().getTime()));
			pstmt.setString(5, project.getState());
			pstmt.setInt(6, project.getNo());
			return pstmt.executeUpdate();		
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt);
		}
		
		return -1;
	}
	
	public int delete(Connection conn, int no) {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "delete from management where no = ?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			return pstmt.executeUpdate();		
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt);
		}
		
		return -1;
	}
	
	public Project SelectById(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from management where no = ?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Project project = new Project(rs.getInt("no"), rs.getString("title"), rs.getString("content"),
												rs.getTimestamp("start_date"), rs.getTimestamp("end_date"), rs.getString("state"));
				return project;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt);
			JDBCUtil.close(rs);
		}
		
		return null;
	}
}
