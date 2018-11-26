package com.newlecture.web.controller.customer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/customer/notice/reg")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024,
		maxFileSize = 1024 * 1024 * 10 , //5메가 
		maxRequestSize = 1024 * 1024 * 10 * 5 //5메가 5개까지
		)
public class NoticeRegController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/customer/notice/reg.jsp");
		//상태 저장 객체
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		
		String path = req.getServletContext().getRealPath("/upload");
		System.out.println(path);
		
		String filePath = path+ File.separator +"aa.jpg";
		// File.separator: 윈도우나 유닉스에서의 구분자를 알맞게 해주는것
		
		String title = req.getParameter("title"); 
		String content = req.getParameter("content");
		Part part= req.getPart("file");
		InputStream fis= part.getInputStream();
		OutputStream fos = new FileOutputStream(filePath);
		
		byte[] buf = new byte[1024];
		int size= 1024;
		
		while((size = fis.read(buf)) >= 0) 
			//size = fis.read(buf);
			fos.write(buf, 0, size);
		
		
		System.out.println(title);
		
		
		
		String sql = "INSERT INTO NOTICE(ID, TITLE, WRITER_ID, CONTENT) "
				+ "VALUES(NOTICE_SEQ.NEXTVAL,?,?,?)";
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl"; 
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"c##sist","dclass");
			 PreparedStatement st = con.prepareStatement(sql);
			 st.setString(1, title);
			 st.setString(2, "hyejeong");
			 st.setString(3, content);
			 int affected = st.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		resp.sendRedirect("list");
	}
}
