import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calcu")
public class Caclu extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();

		RequestDispatcher dispatcher = req.getRequestDispatcher("calcu.jsp");
		// 상태 저장 객체
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("UTF-8");
		// 응답을 할때 utf-8로 서 응답을 한다 이것만 쓰면 내가 utf-8로 쓴걸 브라우저는 모른다.
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();

		String num = req.getParameter("num");
		String x = req.getParameter("x");
		String buf = req.getParameter("buf");
		String sign = req.getParameter("sign");
		switch (num) {

		case "+":
			buf= x;
			sign="plus";
			x="";
			
			break;
		case "-":
			buf= x;
			sign="-";
			x="";
			break;
		case "*":
			buf= x;
			sign="*";
			x="";
			break;

		case "/":
			buf= x;
			sign="/";
			x="";
			break;
			
		case "C":
			buf= "";
			x="";
			break;
		
		case "<-":
			
			x = x.substring(0, x.length()-1);
			buf = x.substring(0, x.length()-1);

		case "=":
			 System.out.println(sign.equals("+"));
			if(sign.equals("plus"))
				x =(Integer.parseInt(buf) + Integer.parseInt(x))+"";
			if(sign.equals("-"))
				x =(Integer.parseInt(buf) - Integer.parseInt(x))+""; 
			if(sign.equals("*"))
				x =(Integer.parseInt(buf) * Integer.parseInt(x))+""; 
			if(sign.equals("/"))
				x =(Integer.parseInt(buf) / Integer.parseInt(x))+""; 
			break;
		default:
			x = x + num;
			break;
		}
		resp.sendRedirect("calcu?a=" +x+"&buf="+buf+"&sign="+sign);
		

	}
}
