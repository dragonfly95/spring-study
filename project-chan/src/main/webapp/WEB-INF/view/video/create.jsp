<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="/WEB-INF/view/common/layout/layout_header.jsp"/>
<script type="text/javascript">
	$().ready(function() {
		$("#upload").click(function() {

			if ($("#video").val() == "") {
				alert("비디오를 선택해주세요")
				$("#video").focus()
				return;
			} else if ($("#title").val() == "") {
				alert("title  입력주세요")
				$("#title").focus()
				return;
			} else if ($("#uploaderId").val() == "") {
				alert("uploaderId 입력주세요")
				$("#uploaderId").focus()
				return;
			} else if ($("#poster").val() == "") {
				alert("poster 선택해주세요")
				$("#poster").focus()
				return;
			}


			$("#videoUploadForm").attr({
				"method" : "post",
				"action" : "/Youtube/video/create",
			}).submit()


		})
	})
</script>

				<h1>Video Upload</h1>
				<form id="videoUploadForm" enctype="multipart/form-data">
					<div>
						<input type="file" id="video" name="video"
							accept=".mp4,.mp3, .avi" />
					</div>
					<div>
						<input type="text" id="title" name="title">
					</div>
					<div>
						<input type="text" id="uploaderId" name="uploaderId" />
					</div>
					<div>
						<input type="file" id="poster" name="poster"
							accept=".jsp, .png , .jpeg" />
					</div>
					<div>
						<input type="button" id="upload" value="Upload" />
					</div>


				</form>
<jsp:include page="/WEB-INF/view/common/layout/layout_footer.jsp"/>