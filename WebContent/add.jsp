<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!-- 지시함수 코드로 들어가는것이 아니라 지시로서 들어간다. -->


<% 
/* 이 안은 함수이므로 이안에 함수가 들어갈 수 는 없다 */
//코드 블럭 으로 인식한다.
/* 오류발생 이것이 실행하기 전에 이미out.write이 발생 한다.
 response.setCharacterEncoding("UTF-8"); 
response.setContentType("text/html; charset=UTF-8"); */
int x = 3;
int y =4;
/* int sum = x+y; */
int sum = add(x,y);
%>

<%!

private int add(int x, int y){
	return x+y;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welecome</title>
</head>
<body>
   <form action="add" method="post">
       <div>
           <label>x : </label>
           <input type="text" name="x" />
       </div>
       <div>
           <label>y : </label>
           <input type="text" name="y" />
       </div>
       <div>
           <input type="submit" name="cmd" value="add" />
           <input type="submit" name="cmd" value="application" />
           <input type="submit" name="cmd" value="session" />
           <input type="submit" name="cmd" value="cookie" />
           
       </div>
       <div>
           <label>sum : ${add} - ${param.a}
  		   <input type="hidden" name ="add" value="${add}"/>
           </label>
           
       </div>
   </form>
	<a href="mypage.jsp">마이페이지</a>
</body>
</html>