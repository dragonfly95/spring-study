<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Board List</title>
</head>
<body>
<h1>Board List</h1>
<h2>${name}</h2>
<table border="1">
<thead>
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>제목</th>
		<th>조회</th>
		<th>작성일</th>
	</tr>
</thead>
<tbody>
<c:forEach var="item" items="${list}">
	<tr>
		<td>${item.num}</td>
		<td>${item.name}</td>
		<td>${item.title}</td>
		<td>${item.readCount}</td>
		<td>${item.writeDate}</td>
    </tr>
</c:forEach>
</tbody>
</table>
<br />
<button onclick="history.back();">뒤로</button>
</body>
</html>