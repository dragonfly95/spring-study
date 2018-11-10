<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>
</head>
<body>

  <h1>사이트 등록 </h1>
  <table>
    <tr>
      <td>사이트명</td>
      <td>
        <input type="text" date-siteId="" name="siteName" value="">
      </td>
      <td>
        <input type="button" name="btn-insert" value="저장" />
      </td>
    </tr>
  </table>

  <hr>
  <table border="1">
    <tr>
      <td>id</td>
      <td>사이트명</td>
    </tr>
    <tbody class="list"></tbody>
  </table>

  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script>

    $(document).ready(function () {

      ajaxList();


      $('[name="btn-insert"]').on('click', function() {

          if($('[name="siteName"]').val() == '') {
            alert('사이트명을 입력해주세요.');
            return ;
          }

          $.ajax({
            type: "post",
            url: "/site",
            data: JSON.stringify({"siteName": $('[name="siteName"]').val() }),
            dataType: "json",
            contentType: "application/json",
            success: function (response) {
              console.log(response);
              ajaxList();
            }
          });
      });

     // 삭제
     $(document).on('click','[name="btnDelete" ]', function(e) {

       var siteId = $(e.target).attr('data-siteId');
       $.ajax({
        type: "delete",
        url: "/site/"+siteId,
        dataType: "json",
        contentType: "application/json",
        success: function (response) {
          console.log(response);
          console.log('삭제처리 되었음.');
          ajaxList();
        }
       });
     });


     // 1건 불러오기
     $(document).on('click','[name="btnDetail" ]', function(e) {

       var siteId = $(e.target).attr('data-siteId');

       $.ajax({
         url: "/site/"+siteId,
         dataType: "json",
         success: function (response) {
           console.log('상세 조회 ');
           $('[name="siteName"]').attr('data-siteId', response.siteName);
           $('[name="siteName"]').val(response.siteName);
         }
       });
     });


   });  // end document ready

   function ajaxList() {


      $.ajax({
        url: "/site",
        dataType: "json",
        success: function (response) {
          console.log(response);

          var str = '';
          $(response).each(function (indexInArray, valueOfElement) {

            str += '<tr>';
            str += '<td>'+ valueOfElement.siteId +'</td>';
            str += '<td>'+ valueOfElement.siteName +'</td>';
            str += '<td><input type="button" data-siteId="'+ valueOfElement.siteId +'" name="btnDetail" value="수 정"/></td>';
            str += '<td><input type="button" data-siteId="'+ valueOfElement.siteId +'" name="btnDelete" value="삭 제"/></td>';
            str += '</tr>';
          });

          if(response.length == 0) {
            str += '<tr><td colspan="2">조회내용없음</td></tr>';
          }
          $('tbody.list').html(str);
        }
      });

   }
  </script>
</body>
</html>