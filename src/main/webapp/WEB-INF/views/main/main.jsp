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
		<c:if test="${nickName ne null}">
			<c:out value="${nickName}"/>님 반갑습니다.
		</c:if>
	</main>
</section>




<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>
