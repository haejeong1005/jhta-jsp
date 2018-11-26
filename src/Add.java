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
		// 응답을 할때 utf-8로 서 응답을 한다 이것만 쓰면 내가 utf-8로 쓴걸 브라우저는 모른다.
		resp.setContentType("text/html; charset=UTF-8");
		// 텍스트문서가 html문서라는것의 정보를 주는것. 이것을 통해서 브라우저가 utf-8로 쓰여져있다는것을 안다
		PrintWriter out = resp.getWriter();

		int add = 0;
		int x_ = 0;
		int y_ = 0;

		String add_ = req.getParameter("a"); // 쿼리스트링으로 인하여 짧게 써준다.
		if (add_ != null) {
			add = Integer.parseInt(add_);
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("add.jsp");
		req.setAttribute("add", add);

		// 상태 저장 객체
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
		 * out.write("			<input type=\"submit\" value=\"덧셈\" />");
		 * out.write("		</div>"); out.write("	</form>");
		 * out.write("	<a href=\"mypage\">마이페이지</a>"); out.write("</body>");
		 * out.write("</html>");
		 */
	}

	@Override // request(req)는 입력상자
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		resp.setCharacterEncoding("UTF-8");
		// 응답을 할때 utf-8로 서 응답을 한다 이것만 쓰면 내가 utf-8로 쓴걸 브라우저는 모른다.
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
		 * 다른객체를 호출하고 싶을 때 둘다 현재 서블릿에서 다른 서블릿을 요청하는 방법 리디렉트 (redirect): 현재서블릿을 처리하고
		 * 다른곳으로 이동 지금까지 처리한 내용과 상관없이 완전히 새로운 서블릿을 요청할 때 지금 서블릿과 요청될 서블릿이 공유해야 할 것이 없는
		 * 경우 포워드 (forward): 지금 서블릿이 처리한 것을 받아서 이어가야 할 때 지금 서블릿이 새로운 서블릿에게 지금까지 처리한 것을
		 * 넘겨주면서 이어가야 할때 포워드 단점 post 처리 forward는 다시 post를 요청하게 된다. get처리 forward는 get을
		 * 요청하고 post처리 forward는 post만 요청하게 돼서 무한루프에 걸린다.
		 */
		/*
		 * RequestDispatcher dispatcher = req.getRequestDispatcher("/add");
		 * req.setAttribute("add", add); //상태 저장 객체 dispatcher.forward(req, resp);
		 */

		resp.sendRedirect("add?a=" + add); // GET 요청만 가능
		// "add?a="+add 쿼리스트링에서 키와 밸류값을 쓸때 키값을 줄여 써주는게 좋다.

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
		 * out.write("			<input type=\"submit\" value=\"덧셈\" />");
		 * out.write("		</div>"); out.write("	</form>"); out.write("</body>");
		 * out.write("</html>");
		 */

	}
	/*
	 * public void service(HttpServletRequest request, HttpServletResponse response)
	 * throws IOException, ServletException //service는 프레임워크 우리는 이것을 고쳐썼던 것임 {
	 * 
	 * response.setCharacterEncoding("UTF-8"); //응답을 할때 utf-8로 서 응답을 한다 이것만 쓰면 내가
	 * utf-8로 쓴걸 브라우저는 모른다. response.setContentType("text/html; charset=UTF-8"); //
	 * 텍스트문서가 html문서라는것의 정보를 주는것. 이것을 통해서 브라우저가 utf-8로 쓰여져있다는것을 안다 PrintWriter out =
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
	 * out.write("			<input type=\"submit\" value=\"덧셈\" />");
	 * out.write("		</div>"); out.write("	</form>"); out.write("</body>");
	 * out.write("</html>");
	 * 
	 * }
	 */
}