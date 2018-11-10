<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Welcome~!</title>
</head>
<body>
<h1>환영합니다!</h1>
<ul>
	<li><a href="<c:url value='/boardList.do' />">SELECT 쿼리 사용</a></li>
	<li><a href="<c:url value='/mapProcedureList.do' />">Procedure 사용(값 교환에 HashMap 사용)</a></li>
	<li><a href="<c:url value='/procedureList.do' />">Procedure 사용(값 교환에 VO 사용)</a></li>
	<li><a href="<c:url value='/anonymousBlockList.do' />">Anonymous Block 사용(값 교환에 VO 사용)</a></li>
</ul>
</body>
</html>