import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/add")
public class Add extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		// ������ �Ҷ� utf-8�� �� ������ �Ѵ� �̰͸� ���� ���� utf-8�� ���� �������� �𸥴�.
		resp.setContentType("text/html; charset=UTF-8");
		// �ؽ�Ʈ������ html������°��� ������ �ִ°�. �̰��� ���ؼ� �������� utf-8�� �������ִٴ°��� �ȴ�
		PrintWriter out = resp.getWriter();

		int add = 0;
		int x_ = 0;
		int y_ = 0;

		String add_ = req.getParameter("a"); // ������Ʈ������ ���Ͽ� ª�� ���ش�.
		if (add_ != null) {
			add = Integer.parseInt(add_);
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("add.jsp");
		req.setAttribute("add", add);

		// ���� ���� ��ü
		dispatcher.forward(req, resp);

		/*
		 * out.write("<!DOCTYPE html>"); out.write("<html>"); out.write("<head>");
		 * out.write("<meta charset=\"UTF-8\">");
		 * out.write("<title>Insert title here</title>"); out.write("</head>");
		 * out.write("<body>"); out.write("	<form action=\"add\" method=\"post\">");
		 * out.write("		<div>"); out.write("			<label>x : </label>");
		 * out.write("			<input type=\"text\" name=\"x\" value=\""+x_+"\"/>");
		 * out.write("		</div>"); out.write("		 <div>");
		 * out.write("			<label>y : </label>");
		 * out.write(" 		<input type=\"text\" name=\"y\"  value=\""+y_+"\" />");
		 * out.write("		</div>"); out.write("		<div>");
		 * out.write("			<label>sum: "+add+"</label>");
		 * out.write("			<sapn></span>"); out.write("		</div>");
		 * out.write(" 	<div>");
		 * out.write("			<input type=\"submit\" value=\"����\" />");
		 * out.write("		</div>"); out.write("	</form>");
		 * out.write("	<a href=\"mypage\">����������</a>"); out.write("</body>");
		 * out.write("</html>");
		 */
	}

	@Override // request(req)�� �Է»���
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		resp.setCharacterEncoding("UTF-8");
		// ������ �Ҷ� utf-8�� �� ������ �Ѵ� �̰͸� ���� ���� utf-8�� ���� �������� �𸥴�.
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();

		String cmd = req.getParameter("cmd");
		int add = 0;
		int x_ = 0;
		int y_ = 0;

		switch (cmd) {

		case "add":
			String x = req.getParameter("x");
			String y = req.getParameter("y");

			if (x != null)
				x_ = Integer.parseInt(x);
			if (y != null)
				y_ = Integer.parseInt(y);
			add = x_ + y_;
			break;

		case "session":
			String sum1 = req.getParameter("add");
			HttpSession session = req.getSession();
			session.setAttribute("sum1", sum1);
			break;

		case "application":
			String sum2 = req.getParameter("add");
			ServletContext application = req.getServletContext();
			application.setAttribute("sum2", sum2);
			break;
		}

		/*
		 * �ٸ���ü�� ȣ���ϰ� ���� �� �Ѵ� ���� �������� �ٸ� ������ ��û�ϴ� ��� ����Ʈ (redirect): ���缭���� ó���ϰ�
		 * �ٸ������� �̵� ���ݱ��� ó���� ����� ������� ������ ���ο� ������ ��û�� �� ���� ������ ��û�� ������ �����ؾ� �� ���� ����
		 * ��� ������ (forward): ���� ������ ó���� ���� �޾Ƽ� �̾�� �� �� ���� ������ ���ο� �������� ���ݱ��� ó���� ����
		 * �Ѱ��ָ鼭 �̾�� �Ҷ� ������ ���� post ó�� forward�� �ٽ� post�� ��û�ϰ� �ȴ�. getó�� forward�� get��
		 * ��û�ϰ� postó�� forward�� post�� ��û�ϰ� �ż� ���ѷ����� �ɸ���.
		 */
		/*
		 * RequestDispatcher dispatcher = req.getRequestDispatcher("/add");
		 * req.setAttribute("add", add); //���� ���� ��ü dispatcher.forward(req, resp);
		 */

		resp.sendRedirect("add?a=" + add); // GET ��û�� ����
		// "add?a="+add ������Ʈ������ Ű�� ������� ���� Ű���� �ٿ� ���ִ°� ����.

		/*
		 * out.write("<!DOCTYPE html>"); out.write("<html>"); out.write("<head>");
		 * out.write("<meta charset=\"UTF-8\">");
		 * out.write("<title>Insert title here</title>"); out.write("</head>");
		 * out.write("<body>"); out.write("	<form action=\"add\" method=\"post\">");
		 * out.write("		<div>"); out.write("			<label>x : </label>");
		 * out.write("			<input type=\"text\" name=\"x\" value=\""+x_+"\"/>");
		 * out.write("		</div>"); out.write("		 <div>");
		 * out.write("			<label>y : </label>");
		 * out.write(" 		<input type=\"text\" name=\"y\"  value=\""+y_+"\" />");
		 * out.write("		</div>"); out.write("		<div>");
		 * out.write("			<label>sum: "+add+"</label>");
		 * out.write("			<sapn></span>"); out.write("		</div>");
		 * out.write(" 	<div>");
		 * out.write("			<input type=\"submit\" value=\"����\" />");
		 * out.write("		</div>"); out.write("	</form>"); out.write("</body>");
		 * out.write("</html>");
		 */

	}
	/*
	 * public void service(HttpServletRequest request, HttpServletResponse response)
	 * throws IOException, ServletException //service�� �����ӿ�ũ �츮�� �̰��� ���Ľ�� ���� {
	 * 
	 * response.setCharacterEncoding("UTF-8"); //������ �Ҷ� utf-8�� �� ������ �Ѵ� �̰͸� ���� ����
	 * utf-8�� ���� �������� �𸥴�. response.setContentType("text/html; charset=UTF-8"); //
	 * �ؽ�Ʈ������ html������°��� ������ �ִ°�. �̰��� ���ؼ� �������� utf-8�� �������ִٴ°��� �ȴ� PrintWriter out =
	 * response.getWriter();
	 * 
	 * int add = 0; int x_ =0; int y_ =0;
	 * 
	 * 
	 * if(request.getMethod().equals("POST")) { String x =
	 * request.getParameter("x"); String y = request.getParameter("y");
	 * 
	 * 
	 * if(x != null) x_ = Integer.parseInt(x); if(y != null) y_ =
	 * Integer.parseInt(y); add = x_+y_; }
	 * 
	 * 
	 * out.write("<!DOCTYPE html>"); out.write("<html>"); out.write("<head>");
	 * out.write("<meta charset=\"UTF-8\">");
	 * out.write("<title>Insert title here</title>"); out.write("</head>");
	 * out.write("<body>"); out.write("	<form action=\"add\" method=\"post\">");
	 * out.write("		<div>"); out.write("			<label>x : </label>");
	 * out.write("			<input type=\"text\" name=\"x\" value=\""+x_+"\"/>");
	 * out.write("		</div>"); out.write("		 <div>");
	 * out.write("			<label>y : </label>");
	 * out.write(" 		<input type=\"text\" name=\"y\"  value=\""+y_+"\" />");
	 * out.write("		</div>"); out.write("		<div>");
	 * out.write("			<label>sum: "+add+"</label>");
	 * out.write("			<sapn></span>"); out.write("		</div>");
	 * out.write(" 	<div>");
	 * out.write("			<input type=\"submit\" value=\"����\" />");
	 * out.write("		</div>"); out.write("	</form>"); out.write("</body>");
	 * out.write("</html>");
	 * 
	 * }
	 */
}