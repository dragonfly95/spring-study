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


  <h1>아이템 관리</h1>
  <table>
    <tr>
      <td>아이템 이름</td>
      <td>
        <input type="text" data-itemId="" name="itemName" value="" />
      </td>
    </tr>
    <tr>
      <td>사진</td>
      <td>
        <input type="file" name="imagePath" value="" />
        <input type="button" id="btn_submit" value="전송" />
      </td>
    </tr>
    <tr>
      <td>
        <input type="button" name="btnSave" value="저장" />
      </td>
    </tr>
  </table>

  <hr>
  <table border="1">
    <tr>
      <td>id</td>
      <td>아이템 이름 </td>
      <td>이미지 </td>
    </tr>
    <tbody class="list"></tbody>
  </table>


  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script>

    var dataObj = {"itemId":0, "itemName": "", "imagePath":  ""};

    $(document).ready(function () {



      ajaxList();  // 목록 불러오기

      $('[name="btnSave"]').on('click', function() {

          if($('[name="itemName"]').val() == '') {
            alert('아이템 이름을 입력해주세요.');
            return ;
          }


          dataObj.itemName = $('[name="itemName"]').val();
          if(dataObj.itemId == 0) {  // 신규입력
              $.ajax({
                type: "post",
                url: "/item",
                data: JSON.stringify(dataObj),
                contentType: "application/json",
                dataType: "json",
                success: function (response) {
                  alert('저장 완료');
                  ajaxList();  // 목록 불러오기
                }
              });
          } else {
              $.ajax({
                type: "put",
                url: "/item/"+ dataObj.itemId,
                data: JSON.stringify(dataObj),
                dataType: "json",
                contentType: "application/json",
                success: function (response) {
                  alert('저장 완료');
                  ajaxList();  // 목록 불러오기
                }
              });
          }


      });


     // 삭제
     $(document).on('click','[name="btnDelete" ]', function(e) {

       var itemId = $(e.target).attr('data-itemId');
       $.ajax({
        type: "delete",
        url: "/item/"+itemId,
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

       var itemId = $(e.target).attr('data-itemId');

       $.ajax({
         url: "/item/"+itemId,
         dataType: "json",
         success: function (response) {
           console.log('상세 조회 ');
           $('[name="itemName"]').attr('data-itemId', response.itemName);
           $('[name="itemName"]').val(response.itemName);
           dataObj.imagePath = response.imagePath;
           dataObj.itemName = response.itemName;
           dataObj.itemId   = response.itemId;
         }
       });
     });



      // 사진 업로드
      $('#btn_submit').click(function(){
          ajaxFileUpload($('input:file'), '/file/upload.do', function(result){
            var res = JSON.parse(result);
            dataObj.imagePath = res.destFileName;
          });
      });
    });  // end document ready



   function ajaxList() {

      $.ajax({
        url: "/item",
        dataType: "json",
        success: function (response) {
          console.log(response);

          var str = '';
          $(response).each(function (indexInArray, valueOfElement) {

            str += '<tr>';
            str += '<td>'+ valueOfElement.itemId +'</td>';
            str += '<td>'+ valueOfElement.itemName +'</td>';
            str += '<td><img src="/uploads/'+ valueOfElement.imagePath +'" alt="'+ valueOfElement.itemName +'" width="150"></td>';
            str += '<td><input type="button" data-itemId="'+ valueOfElement.itemId +'" name="btnDetail" value="수 정"/></td>';
            str += '<td><input type="button" data-itemId="'+ valueOfElement.itemId +'" name="btnDelete" value="삭 제"/></td>';
            str += '</tr>';
          });

          if(response.length == 0) {
            str += '<tr><td colspan="2">조회내용없음</td></tr>';
          }
          $('tbody.list').html(str);
        }
      });

   }


  // files, action URL, response를 받을 callback을 지정
  function ajaxFileUpload(files, action, callback)
  {
      // iframe의 name이자, form의 target
      var target_name = 'iframe_upload';

      // form 생성
      var form = $('<form action="'+action+'" method="post" enctype="multipart/form-data" style="display:none;" target="'+target_name+'"></form>');
      $('body').append(form);
      // 전송할 file element를 갖다 붙임
      files.appendTo(form);

      // iframe 생성
      var iframe = $('<iframe src="javascript:false;" name="'+target_name+'" style="display:none;"></iframe>');
      $('body').append(iframe);

      // onload 이벤트 핸들러
      // action에서 파일을 받아 처리한 결과값을 텍스트로 출력한다고 가정하고 iframe의 내부 데이터를 결과값으로 callback 호출
      iframe.load(function(){
          var doc = this.contentWindow ? this.contentWindow.document : (this.contentDocument ? this.contentDocument : this.document);
          var root = doc.documentElement ? doc.documentElement : doc.body;
          var result = root ? root.textContent : root.innerText;
          callback(result);

          // 전송처리 완료 후 생성했던 form, iframe 제거
          form.remove();
          iframe.remove();
      });
      form.submit();
  }


  </script>
</body>
</html>