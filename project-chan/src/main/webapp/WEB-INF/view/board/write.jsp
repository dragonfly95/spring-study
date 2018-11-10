<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

  <h1>Board 자유게시판 - 신규작성 </h1>
  <table class="table">
    <tr>
      <td>제목:</td>
      <td>
        <input type="text" name="title" value="" />
      </td>
    </tr>
    <tr>
      <td>내용:</td>
      <td>
        <textarea name="content"></textarea>
      </td>
    </tr>
    <tr>
      <td>작성자:</td>
      <td>
        <input type="text" name="writer" value="" />
      </td>
    </tr>
    <tr>
      <td>사진</td>
      <td>
        <input type="file" name="imagePath" value="" />
        <input type="button" id="btn_submit" value="전송" />
      </td>
    </tr>
    <tr align="center">
      <td colspan="2">
        <input type="button" name="btnSave" value="저장" />
        <input type="button" name="btnList" value="목록으로 이동 " />
      </td>
    </tr>
  </table>


