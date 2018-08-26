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

		<h1>글 수정 </h1>
		<form method="post" action="${contextPath}/board/modify.do" enctype="multipart/form-data">

			<table width="700">
				<tr>
					<td><label for="title1">제목 </label></td>
					<td>
						<input type="text" name="subject" value="${boardVO1.subject}" placeholder="제목을 입력하세요." id="title1"/>
					</td>
				</tr>
				<tr>
					<td><label for="title2">내용 </label></td>
					<td>
						<textarea name="content" value="${boardVO1.content}" placeholder="내용을 입력하세요." id="title2"></textarea>
					</td>
				</tr>
				<tr>
					<td><label for="title3">첨부파일 </label></td>
					<td>
						<input type="file" name="file" placeholder="파일을 선택하세요" id="title3">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<br>
						<br>
						<input type="submit" value="수정" />
						<a href="list.do">목록</a>
					</td>
				</tr>
			</table>
		</form>
</body>
</html>