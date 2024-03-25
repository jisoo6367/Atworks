<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
	<title>atworks</title>
	
		<style>
        .custom-input {
            width: 400px;
        }
	</style>
</head>
<%@ include file="/WEB-INF/views/include/script.jsp" %>

<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

 
<section class="main_wrap">
	<main class="main">
	<br>
	<h3>게시글 상세보기</h3>
	<br>

<form id="frmSendValue" method="post" action="/app/board/modify">
        
		    <label class="col-sm-2 control-label" style="white-space: nowrap;">게시글 번호</label>
		    <div class="custom-input">
		    	<input class="form-control" name="idx" id="idx" type="text" 
		    		   value="${board.idx }" readonly="readonly">
			</div>

		    <label class="col-sm-2 control-label" style="white-space: nowrap;">제목</label>
		    <div class="custom-input">
		    	<input class="form-control" name="title" id="title" type="text" 
		    		   value="${board.title }" readonly="readonly">
			</div>

		    <label class="col-sm-2 control-label" style="white-space: nowrap;">내용</label>
		    <div class="custom-input">
		    	<input class="form-control" name="content" id="content" type="text" 
		    		   value="${board.content }" readonly="readonly">
			</div>

		    <label class="col-sm-2 control-label" style="white-space: nowrap;">작성자 고유번호</label>
		    <div class="custom-input">
		    	<input class="form-control" name="userId" id="userId" type="text" 
		    		   value="${board.userId }" readonly="readonly">
			</div>

		    <label class="col-sm-2 control-label" style="white-space: nowrap;">작성날짜</label>
		    <div class="custom-input">
		    	<input class="form-control" name="insertTime" id="insertTime" type="text" 
		    		   value="${board.insertTime }" readonly="readonly">
			</div><br>
		
		<button type="button" class="btn_type1" id="btnToModify">게시글 수정</button>&nbsp;&nbsp;
		<button type="button" class="btn_type1" id="btnToDelete">삭제</button>

        </form>
        



	</main>
</section>




<script>
var idx = '<c:out value="${board.idx }"/>';

//게시글 수정하러
$("#btnToModify").on("click", function(){
	
	var url = "/app/board/modify?idx=" + encodeURIComponent(idx);
	window.location.href = url;
});

//게시글 삭제
$("#btnToDelete").on("click", function(){
		
 	if(confirm("정말 삭제 하시겠습니까?")){
 		var url = "/app/board/delete?idx=" + encodeURIComponent(idx);
 		window.location.href = url;
	} 

});

</script>




<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>
