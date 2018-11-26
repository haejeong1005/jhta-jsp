package com.newlecture.web.controller.customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;

@WebServlet("/customer/notice/detail")
public class NoticeDetailController extends HttpServlet {
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	 //1.����ڰ� ������ id���� �о�´�
	 int id = Integer.parseInt(req.getParameter("id"));
	 String sql = "SELECT * FROM NOTICE WHERE ID="+id;

	 String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl"; 
	 try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		 Connection con = DriverManager.getConnection(url,"c##sist","dclass"); // ��ȣ����  ���̵�/ ��й�ȣ/ ���� �ּ� / 
		 Statement st = con.createStatement();  // select * from notices
		 // ������ ���ڵ� �� ǥ��
		 ResultSet rs =st.executeQuery(sql); 
		 rs.next();
			

			
			//2. �����ͺ��̽����� id=?�� ���ڵ带 ������ jdbc �ڵ带 �ۼ��Ѵ�.
		/*	String title = rs.getString("title");
			String content = rs.getString("content");
			String writerID = rs.getString("WRITER_ID");
			String regdate = rs.getString("REGDATE");
			int hit = rs.getInt("HIT");*/
			
		
		
			Notice n = new Notice(
					rs.getInt("id"),
					rs.getString("title"),
					rs.getString("content"),
					rs.getString("writer_id"),
					rs.getDate("regdate"),
					rs.getInt("hit")
					);
			
			rs.close();
			st.close();
			con.close();
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/customer/notice/detail.jsp");
			req.setAttribute("n", n);
			
			//���� ���� ��ü
			dispatcher.forward(req, resp);
			
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
