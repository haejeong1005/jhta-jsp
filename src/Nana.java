import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello") //��Ʈ�κ��� �����ؾ��Ѵ�. ��Ʈ�� �������� ����� ���� �ʾ�
public class Nana extends HttpServlet
{
	public void service(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException
	{

		response.setCharacterEncoding("UTF-8");
		//������ �Ҷ� utf-8�� �� ������ �Ѵ� �̰͸� ���� ���� utf-8�� ���� �������� �𸥴�.
		response.setContentType("text/html; charset=UTF-8");
		// �ؽ�Ʈ������ html������°��� ������ �ִ°�. �̰��� ���ؼ� �������� utf-8�� �������ִٴ°��� �ȴ�
		PrintWriter out = response.getWriter();
  
		String cnt_ = request.getParameter("cnt");
		int cnt = 0;
		if(cnt_ != null && !cnt_.equals(""))
			cnt = Integer.parseInt(cnt_);
		for(int i=0; i<cnt; i++) {
			out.println((i+1)+"�ȳ� Servlet!<br />");
		}
		
		
	}
} 