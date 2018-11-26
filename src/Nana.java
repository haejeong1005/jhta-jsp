import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello") //루트로부터 시작해야한다. 루트가 없어지면 실행디 되지 않아
public class Nana extends HttpServlet
{
	public void service(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException
	{

		response.setCharacterEncoding("UTF-8");
		//응답을 할때 utf-8로 서 응답을 한다 이것만 쓰면 내가 utf-8로 쓴걸 브라우저는 모른다.
		response.setContentType("text/html; charset=UTF-8");
		// 텍스트문서가 html문서라는것의 정보를 주는것. 이것을 통해서 브라우저가 utf-8로 쓰여져있다는것을 안다
		PrintWriter out = response.getWriter();
  
		String cnt_ = request.getParameter("cnt");
		int cnt = 0;
		if(cnt_ != null && !cnt_.equals(""))
			cnt = Integer.parseInt(cnt_);
		for(int i=0; i<cnt; i++) {
			out.println((i+1)+"안녕 Servlet!<br />");
		}
		
		
	}
} 