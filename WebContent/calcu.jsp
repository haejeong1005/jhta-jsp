<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="calcu" method="post">
		<input type="text" name="x" value="${param.a}"/>
		<div>
			<div>
				<input type="submit" name="num" value="<-" />
				<input type="submit" name="num" value="CE" />
				<input type="submit" name="num" value="C" />
				<input type="submit" name="num" value="+-" />
			</div>

			<div>
				<input type="submit" name="num" value="7" />
				<input type="submit" name="num" value="8" />
				<input type="submit" name="num" value="9" />
				<input type="submit" name="num" value="/" />
			</div>

			<div>
				<input type="submit" name="num" value="4" />
				<input type="submit" name="num" value="5" />
				<input type="submit" name="num" value="6" />
				<input type="submit" name="num" value="*" />
			</div>

			<div>
				<input type="submit" name="num" value="1" />
				<input type="submit" name="num" value="2" />
				<input type="submit" name="num" value="3" />
				<input type="submit" name="num" value="-" />
			</div>

			<div>
				<input type="submit" name="num" value="0" />
				<input type="submit" name="num" value="." />
				<input type="submit" name="num" value="+" />
				<input type="submit" name="num" value="=" />
			
			</div>
		</div>
		<input type="hidden" name="sign" value="${param.sign}"/>
		<input type="hidden" name="buf" value="${param.buf}"/>
	</form>
</body>
</html>