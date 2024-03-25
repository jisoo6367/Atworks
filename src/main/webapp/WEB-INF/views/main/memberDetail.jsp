<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
	<title>atworks</title>

	<style>
        .custom-input {
            width: 200px;
        }
	</style>
	  
</head>
<%@ include file="/WEB-INF/views/include/script.jsp" %>

<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>


 
<section class="main_wrap">
	<main class="main">
		<br>
		<h3>유저 디테일</h3>
		<br>
		
        <form id="frmSendValue" method="post" action="/app/member/modify">
        
		<div class="form-group">
		    <label class="col-sm-2 control-label" style="white-space: nowrap;">고유번호</label>
		    <div class="custom-input">
		    	<input class="form-control" name="userId" id="userId" type="text" 
		    		   value="${member.userId }" readonly="readonly">
			</div>
		</div>
		
		<div class="form-group">
		    <label class="col-sm-2 control-label" style="white-space: nowrap;">이름</label>
		    <div class="custom-input">
		    	<input class="form-control" name="userNm" id="userNm" type="text" 
		    		   value="${member.userNm }" readonly="readonly">
			</div>
		</div>
		
		<div class="form-group">
		    <label class="col-sm-2 control-label" style="white-space: nowrap;">비밀번호</label>
		    <div class="custom-input">
		    	<input class="form-control" name="passWd" id="passWd"
		    		   value="" type="password">
			</div>
		</div>

		<div class="form-group">
		    <label class="col-sm-2 control-label" style="white-space: nowrap;">닉네임</label>
		    <div class="custom-input">
		    	<input class="form-control" name="nick" id="nick" type="text" 
		    		   value="${member.nick }" readonly="readonly">
			</div>
		</div>
		
		<div class="form-group">
		    <label class="col-sm-2 control-label" style="white-space: nowrap;">이메일</label>
		    <div class="custom-input">
		    	<input class="form-control" name="email" id="email" type="text" 
		    		   value="${member.email }" readonly="readonly">
			</div>
		</div>
		<div class="form-group">
		    <label class="col-sm-2 control-label" style="white-space: nowrap;">휴대폰번호</label>
		    <div class="custom-input">
		    	<input class="form-control" name="phone" id="phone" type="text" 
		    		   value="${member.phone }" readonly="readonly">
			</div>
		</div><br>
		<input type="submit" class="btn_type1" value="정보 수정하기">
        </form>




	</main>
</section>



<script>


</script>


<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>
