<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


  <h1>Board 자유게시판</h1>
  <div>
    <h2 data-boardno=${boardDto.boardNo} >${boardDto.title}</h2>
  </div>
  <div>
      작성자:${boardDto.writer},
    작성일자: ${boardDto.regDt}
  </div>
  <table class="table">
    <tr>
      <td colspan="2">
        <br/>
      ${boardDto.content}
        <br/>
        <br/>
      </td>
    </tr>
    <tr>
      <td>
        <input type="button" name="btnModify" value="글 수정" />
        <input type="button" name="btnList" value="글 목록" />
      </td>
      <td></td>
    </tr>
  </table>

  <h3>댓글</h3>
  <table class="table">
    <colgroup>
      <col width="90%"/><col width="10%"/>
    </colgroup>
    <tr>
      <td><textarea name="content" style="width:99%"></textarea></td>
      <td>
      <input type="button" name="btnReplyInsert" value="댓글 저장"/>
      </td>
    </tr>
  </table>
  <hr>
  <table class="table">
    <colgroup>
      <col width="60%"/><col width="*"/>
    </colgroup>
    <tbody class="list">
    <c:forEach var = "list" items = '${replyList}' varStatus = "status">
      <tr data-replyno=${list.replyNo}>
        <td>${list.content}</td>
        <td>${list.writer}, ${list.regDt}</td>
        <td>
          <input type="button" name="replyDelete" value="삭제">
          <input type="button" name="replyModify" value="수정"/>
        </td>
      </tr>
    </c:forEach>

    <c:choose>
      <c:when test="${empty replyList}"> 댓글이 없음니다.</c:when>
    </c:choose>

    </tbody>
  </table>


  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="/js/board.js"></script>
  <script>
  var replyObj = { replyNo: 0, content: "", writer: 1, boardNo: 5};

  $(document).ready(function () {



    // 댓글 저장
    $('[name="btnReplyInsert"]').on('click', function() {
      if($('[name="content"]').val() == '') {
        alert('댓글에 내용을 입력해주세요.');
        return ;
      }

      replyObj.content = $('[name="content"]').val();
      replyObj.boardNo = $('h2').data('boardno');
      $.ajax({
        type: "post",
        url: "/api/reply",
        data: JSON.stringify(replyObj),
        contentType: "application/json",
        dataType: "json",
        success: function (response) {
          ajaxService(replyList2, 'SELECT');
          $('[name="content"]').val('');
        }
      });

    });
    //////////////////////

    // 댓글삭제
    $(document).on('click','[name="replyDelete"]', function() {
      replyObj.replyNo = $('[name="replyDelete"]').data('replyno');
      replyObj.content = $('[name="content"]').val();
      replyObj.boardNo = $('tr').data('boardno');
      ajaxService(null, "DELETE")
    });  // end replyDelete click


    // 댓글 수정
    $(document).on('click','[name="btnReplyInsert1"]', function() {
      if($('[name="content1"]').val() == '') {
        alert('댓글에 내용을 입력해주세요.');
        return ;
      }

      replyObj.replyNo = $('tr').data('replyno');
      replyObj.content = $('[name="content1"]').val();
      replyObj.boardNo = $('h2').data('boardno');
      $.ajax({
        type: "PUT",
        url: "/api/reply/"+replyObj.replyNo,
        data: JSON.stringify(replyObj),
        contentType: "application/json",
        dataType: "json",
        success: function (response) {
          ajaxService(replyList2, 'SELECT');
          $('[name="content"]').val('');
        }
      });

    });


    // 수정폼
    $(document).on('click','[name="replyModify"]', function(e) {
      var str = '';
          str += '<tr>';
          str += '<td><textarea name="content1" style="width:99%"></textarea></td>';
          str += '<td>';
          str += '<input type="button" name="btnReplyInsert1" value="댓글 저장"/>';
          str += '</td>';
          str += '</tr>';
      $(e.target).parent().parent().html(str);
    });
  });

  function replyList() {
    $.ajax({
      url: "/api/reply/${boardDto.boardNo}",
      dataType: "json",
      success: function (response) {

        var str = '';
        $(response.list).each(function (indexInArray, valueOfElement) {

          str += '<tr data-replyno='+ valueOfElement.replyNo +'>';
          str += '<td>'+ valueOfElement.content +'</td>';
          str += '<td>'+ valueOfElement.writer +'</td>';
          str += '<td>'+ valueOfElement.regDt +'</td>';
          str += '<td>';
          str += '  <input type="button" name="replyDelete" value="삭제">';
          str += '  <input type="button" name="replyModify" value="수정"/>';
          str += '</td>';
          str += '</tr>';
        });

        if(response.length == 0) {
          str += '<tr><td colspan="2">조회내용없음</td></tr>';
        }
         $('tbody.list').html(str);
      }
    });
  }

var ajaxService = function (callback, crud) {

    console.log("Start todo...............");

    if(crud == 'SELECT') {
      $.ajax({ //ajax 실행
          url: '/api/reply/'+replyObj.boardNo,
          dataType: "json",
          success: function (result) {
            if(callback) {
                  callback(result);
            }
          }
      });
    } // END IF

    if(crud == 'UPDATE') {
      dataObj.boardNo = $('h2').data('boardno');
      dataObj.title   = $('[name="title"]').val();
      dataObj.content = $('[name="content"]').val();
      $.ajax({
        type: "put",
        url: "/api/board/" + dataObj.boardNo,
        data: JSON.stringify(replyObj),
        contentType: "application/json",
        dataType: "json",
        success: function (response) {
          if(callback) {
                callback(result);
          }
        }

      });
    }

    if(crud == 'DELETE') {
      $.ajax({
        type: "delete",
        url: "/api/reply/${boardDto.boardNo}/" + replyObj.replyNo,
        data: JSON.stringify(replyObj),
        contentType: "application/json",
        dataType: "json",
        success: function (response) {
          ajaxService(replyList2, 'SELECT', '/api/reply/'+replyObj.boardNo);
        }

      });
    }

};


  function replyList2(response) {

    var str = '';
    $(response.list).each(function (indexInArray, valueOfElement) {

      str += '<tr>';
      str += '<td>'+ valueOfElement.content +'</td>';
      str += '<td>'+ valueOfElement.writer +'</td>';
      str += '<td>'+ valueOfElement.regDt +'</td>';
      str += '<td>';
      str += '  <input type="button" name="replyDelete" value="삭제">';
      str += '  <input type="button" name="replyModify" value="수정"/>';
      str += '</td>';
      str += '</tr>';
    });

    if(response.length == 0) {
      str += '<tr><td colspan="2">조회내용없음</td></tr>';
    }
      $('tbody.list').html(str);
  }



  </script>
