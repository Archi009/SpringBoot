<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl(Java  Standard Tag Library)</title>
</head>
<body>
	<% List<String> list = Arrays.asList("사과","바나나","포도"); 
	request.setAttribute("list",list);
	%>
	<%=request.getContextPath() %><br>
	${pageContext.request.getContextPath() }<br>
	${pageContext.request.contextPath }
	<a href="${pageContext.request.contextPath }/board">게시판</a>
	<ul>
	총 갯수 : ${fn:length(list) }<br> 
	<c:forEach items="${list}" var="fruit" varStatus="st"  >
		<li>${st.count } ${fruit } <c:if test="${st.last}"> end</c:if> </li>
	</c:forEach>
	
	<c:forEach begin="10" end="15" var="item" varStatus="st">
		${st.index } ${st.count } <br>
	</c:forEach>
	</ul>
</body>
</html>