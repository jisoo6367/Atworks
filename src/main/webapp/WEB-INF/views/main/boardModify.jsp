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

<script>



</script>
 
<section class="main_wrap">
	<main class="main">
	<br>
	<h3>게시글 수정</h3>
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
		    		   value="${board.title }">
			</div>

		    <label class="col-sm-2 control-label" style="white-space: nowrap;">내용</label>
		    <div class="custom-input">
		    	<input class="form-control" name="content" id="content" type="text" 
		    		   value="${board.content }">
			</div>

		    <label class="col-sm-2 control-label" style="white-space: nowrap;">작성자 고유번호</label>
		    <div class="custom-input">
		    	<input class="form-control" name="userId" id="userId" type="text" 
		    		   value="${board.userId }" readonly="readonly">
			</div>

		<input type="submit" class="btn_type1" value="게시글 수정하기">
        </form>



	</main>
</section>




<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>
