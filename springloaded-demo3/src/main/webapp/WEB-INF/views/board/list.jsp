<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Board List </h1>
<c:out value="${boardCount}"/>
<BR/>

<table border="1">
	<tr>
		<td>id</td>
		<td>subject</td>
		<td>content</td>
		<td>email</td>
		<td>crtDt</td>
		<td>mdfyDt</td>
		<td>fileName</td>
		<td>originFileName</td>
	</tr>
<c:forEach items="${getlist}" var="item">
	<tr>
	<td>${item.id}</td>
	<td><a href="detail.do?id=${item.id}">${item.subject}</a></td>
	<td>${item.content}</td>
	<td>${item.email}</td>
	<td>${item.crtDt}</td>
	<td>${item.mdfyDt}</td>
	<td>${item.fileName}</td>
	<td>${item.originFileName}</td>
	</tr>
</c:forEach>
</table>


<a href="write.do">글 작성 </a>