package com.newlecture.web.controller.customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;

@WebServlet("/customer/notice/list") /*사용자가 서블릿을 이용할 수 있도록 이름을 명령한것*/
public class NoticeListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page_ = req.getParameter("p");	
		int page= 1;
		if(page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);
		
		
		
		String sql = "SELECT * FROM" + 
				"("+
				"SELECT ROWNUM NUM, N.* " + 
				"FROM(SELECT * FROM  NOTICE ORDER BY REGDATE DESC) N" + 
				")" + 
				"WHERE NUM BETWEEN ? AND ?";

		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl"; 
		try {
		
			int start=1+(page-1)*10;
			int end=page*10;
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"c##sist","dclass"); // 괄호안은  아이디/ 비밀번호/ 서버 주소 / 
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, start);
			st.setInt(2, end);
			// 한줄은 레코드 라 표현
			ResultSet rs =st.executeQuery();  
			
			List<Notice>list = new ArrayList<>();
			
			while(rs.next()) {
				Notice n = new Notice(
						rs.getInt("id"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getString("writer_id"),
						rs.getDate("regdate"),
						rs.getInt("hit")
						);
				//n.setId(rs.getString("id"));
				//n.setTitle(rs.getString("title"));
				
				list.add(n);
			}
			
			
			rs.close();
			st.close();
			con.close();
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/customer/notice/list.jsp");
			req.setAttribute("list", list);

			//상태 저장 객체
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
