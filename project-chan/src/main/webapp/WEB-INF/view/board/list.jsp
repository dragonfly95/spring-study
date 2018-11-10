<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


  <h1>Board 자유게시판</h1>

  <div style="text-align:right;">
      <input type="button" name="btnMoveWriteform" value="글 작성" class="btn btn-primary"/> &nbsp;&nbsp;&nbsp;
      <input type="button" name="btnJoinform" value="회원가입" class="btn btn-default"/>
  </div>
  <hr/>


  <table class="table table-striped table-hover">
    <colgroup>
      <col width="40%" />
      <col width="40%" />
      <col width="5%" />
      <col width="15%" />
    </colgroup>
    <thead>
    <tr>
      <td>제목</td>
      <td>내용</td>
      <td>작성자</td>
      <td>작성일</td>
    </tr>
    </thead>
    <tbody class="list"></tbody>
    <c:forEach var = "list" items = '${boardList}' varStatus = "status">
    <tr>
      <td><a href="/board/view.do?boardNo=${list.boardNo}">${list.title}</a></td>
      <td>${list.content}</td>
      <td>${list.writer}</td>
      <td>${list.regDt}</td>
    </tr>
    </c:forEach>
  </table>

