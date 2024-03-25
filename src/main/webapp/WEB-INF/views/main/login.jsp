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
	
	    <h2>Login 페이지</h2>
	    <form action="/app/login" method="post">
	        <div>
	            <label for="username">userNm : </label>
	            <input type="text" id="username" name="userNm"/>
	        </div>
	        <div>
	            <label for="password">Password:</label>
	            <input type="password" id="password" name="passWd"/>
	        </div>
	        <div>
	            <button type="submit">Login</button>
	        </div>
	    </form>
	    
	</main>
</section>




<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>
