<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
	<title>atworks</title>
</head>
<%@ include file="/WEB-INF/views/include/script.jsp" %>

<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>


<script>

</script>
 
 
<section class="main_wrap">
	<main class="main">
	<br>
	<h3>회원가입 페이지</h3>
	<br>
	
	<form action="/member/join" method="post">
	    <input type="text" name="userId" placeholder="userId"><br>
	    <input type="text" name="userNm" placeholder="userNm"><br>
	    <input type="password" name="passWd" placeholder="passWd"><br>
	    <input type="text" name="nick" placeholder="nick"><br>
	    <input type="email" name="email" placeholder="Email"><br>
	    <input type="text" name="phone" placeholder="phone"><br>
	    <input type="submit" value="가입하기"/>
	</form>
	
	</main>
</section>


<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>
