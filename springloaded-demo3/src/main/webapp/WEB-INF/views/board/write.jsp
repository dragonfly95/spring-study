<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="contextPath" value="<%= request.getContextPath()%>"></c:set>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  
  <h1>글작성</h1>
	<form method="post" name="boardVO" action="${contextPath}/board/write.do">
    <table width="700">
      <tr>
        <td><label for="title1">제목 </label></td>
        <td>
          <input type="text" name="subject" value="df" placeholder="제목을 입력하세요." id="title1"/>
        </td>
      </tr>
      <tr>
        <td><label for="title2">내용 </label></td>
        <td>
          <textarea name="content" placeholder="내용을 입력하세요." id="title2">12345</textarea>
        </td>
      </tr>
      <tr>
        <td colspan="2">
          <br>
          <br>
          <input type="submit" value="등록" />
          <a href="list.do">목록</a>
        </td>
      </tr>
    </table>
	</form>

</body>
</html>