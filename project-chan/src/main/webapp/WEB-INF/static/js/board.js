
  var dataObj = {"boardNo":0, "title": "", "content":  "", writer: 1};


  $(document).ready(function () {




    $('[name="btnSave"]').on('click', function() {

      dataObj.title = $('[name="title"]').val();
      dataObj.content = $('[name="content"]').val();

     $.ajax({
       type: "post",
       url: "/api/board",
       contentType: "application/json",
       data: JSON.stringify(dataObj),
       dataType: "json",
       success: function (response) {
         console.log(response);
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


      $('[name="btnMoveWriteform"]').on('click', function() {
        location.href='/board/write.do';
      })

      $('[name="btnModify"]').on('click', function() {
        location.href='/board/modify.do?boardNo=' + $('h2').data('boardno');
      })
  
      $('[name="btnList"]').on('click', function() {
        location.href='/';
      })

      $('[name="btnJoinform"]').on('click', function() {
        location.href='/member.do';
      })

      //////
      $('[name="btnUpdate"]').on('click', function() {
        alert('TODO - 수정완료');
      });
  });


function ajaxList() {
  
  $.ajax({
    url: "/api/board",
    dataType: "json",
    success: function (response) {
      console.log(response);

      var str = '';
      $(response.list).each(function (indexInArray, valueOfElement) {

        str += '<tr>';
        str += '<td>'+ valueOfElement.title +'</td>';
        str += '<td>'+ valueOfElement.content +'</td>';
        str += '<td>'+ valueOfElement.writer +'</td>';
        str += '<td>'+ valueOfElement.regDt +'</td>';
        str += '</tr>';
      });

      if(response.length == 0) {
        str += '<tr><td colspan="2">조회내용없음</td></tr>';
      }
  //     $('tbody.list').html(str);
    }
  });
  /////////////////
}