<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el(Expression Language)</title>
</head>
<body>
<%
	session.setAttribute("name","session_홍길동");
	request.setAttribute("name","session_홍길동");
// 	Cookie cookie = new Cookie("pupup","yes");
// 	response.addCookie(cookie);
%>


<!-- scope(session,request,application)기본값은 requestScope라서 생략 -->
<%= session.getAttribute("name") %> => ${sessionScope.name} <br>
<%= request.getAttribute("name") %> => ${name} <br>
<%= request.getParameter("name") %> => ${param.name} <br>
<%-- <%자바에서는 전체 쿠키를 불러와서 for문을 돌려 찾고자 하는 쿠키를 매치해서 가져왔지만 el에서는 아래같이 쉽게 표현된다  %> --%> 
${cookie.popup.value }<br>

<!-- param 매핑된 내장 객체 -->
<%= request.getHeader("User-Agent")  %> <hr> => ${header["User-Agent"] }<br>
</body>
</html>