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
	session.setAttribute("name","session_ȫ�浿");
	request.setAttribute("name","session_ȫ�浿");
// 	Cookie cookie = new Cookie("pupup","yes");
// 	response.addCookie(cookie);
%>


<!-- scope(session,request,application)�⺻���� requestScope�� ���� -->
<%= session.getAttribute("name") %> => ${sessionScope.name} <br>
<%= request.getAttribute("name") %> => ${name} <br>
<%= request.getParameter("name") %> => ${param.name} <br>
<%-- <%�ڹٿ����� ��ü ��Ű�� �ҷ��ͼ� for���� ���� ã���� �ϴ� ��Ű�� ��ġ�ؼ� ���������� el������ �Ʒ����� ���� ǥ���ȴ�  %> --%> 
${cookie.popup.value }<br>

<!-- param ���ε� ���� ��ü -->
<%= request.getHeader("User-Agent")  %> <hr> => ${header["User-Agent"] }<br>
</body>
</html>