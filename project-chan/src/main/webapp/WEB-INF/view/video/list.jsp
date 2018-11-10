<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="/WEB-INF/view/common/layout/layout_header.jsp"></jsp:include>
    	
    	<c:forEach  items="${videoList.groupVideoList}" var="groupVideo">
    	<div class="video-article">
    		<div >
	    		<img class="icon" src="<c:url value='/img/icon.png'/>"/>
	    		${groupVideo.uploaderId}
    		</div>
    		<div>
    			<c:forEach items="${groupVideo.videoList}" var="video">
	    			<article class="video">
	    				<div class="poster">
	    					<a href="<c:url value='/video/detail/${video.videoId }'/>">
							<img src="<c:url value='/video/download/${video.posterPath}'/>">
							</a>
	    				</div>
	    				<div class="title">
	    					${vodeo.title }
	    				</div>
	    				<div>
	    					<article>
	    						<div class="uploader" inline>
	    							${video.uploaderId}
	    						</div>
	    						<div class="uploader-date" inline>
	    						${video.dateDiff}
	    						</div>
	    						<div class="view-count" inline>
	    							${video.viewCount}
	    						</div>
	    					</article>
	    				</div>
	    			
	    			</article>
    			</c:forEach>
    		</div>
    	</div>
    	</c:forEach>
    
    <a href="<c:url value='/video/create'/>">
    	영상업로드
    </a>
    <jsp:include page="/WEB-INF/view/common/layout/layout_footer.jsp"></jsp:include>
    
    
