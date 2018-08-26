<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>${boardVO1.subject} <span style="font-size: 12pt;">${boardVO1.crtDt}</span></h1>
		<%--<h3> ${boardVO1.memberVO.name} </h3>--%>
		
		<c:if test='${not empty boardVO1.originFileName}'>		<p>
			<a href="/HelloSpring/board/download/${boardVO1.id}">${boardVO1.crtDt}</a>
			${boardVO1.originFileName}</p>
		</c:if>
		<div>
			${boardVO1.content}
		</div>
		<div>
            <a href="modify.do?id=${boardVO1.id}">수정</a>
			<a href="delete/${boardVO1.id}">삭제</a>
			<a href="list.do">목록</a>
		</div>
</body>
</html>