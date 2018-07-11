<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Document</title>
</head>
<body>
  
  <div id="boardList"></div>
<script src="https://code.jquery.com/jquery-3.1.0.js"></script>
<script type="text/javascript">

$(document).ready(function() {

    $.ajax({
    url: '/api',
    type: 'GET', dataType: 'json'
  })
  .done(function(result) {
    
    var str = '';
    str += '<ul>';
    $.each(result, function(index, val) {
      str += '<li onclick="displayToggle(this);"><a href="#">'+ val.bbsTitle +' ('+ val.comment.length +' result)</a>';
      str += '  <ul style="display:none;">';
      $.each(val.comment, function(index, val) {
        str += '<li>'+ val.cmtText + '/' + val.userName +'</li>';
      });
      str += '  </ul>';
      str += '</li>';
    });
    str += '</ul>';

    $('#boardList').html(str);
  });


  //------------------------------------

  // $.ajax({
  //   url: '/api/list',
  //   type: 'GET', dataType: 'json',
  //   data: {bbsId: 1}
  // })
  // .done(function(result) {
  //   console.log(result);
  //   console.log("success");
  // });

  //------------------------------------
  $.ajax({
    url: '/api/create',
    type: 'POST', dataType: 'json', contentType: 'application/json',
    data: JSON.stringify({'bbsTitle':'bbsTitle', 'bbsContent':'bbsContent', 'userName': 'userName'})
  })
  .done(function(result) {
    console.log(result);
    console.log("success");
  });

  
});

function displayToggle(div) {
  if($(div).find('ul').css('display') == 'block') {
    $(div).find('ul').css({'display':'none'});
  } else {
    $(div).find('ul').css({'display':'block'});
  }
}
</script>
</body>
</html>
