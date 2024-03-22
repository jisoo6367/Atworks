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


 
<section class="main_wrap">
	<main class="main">
		<h3>유저 게시판</h3>
		<table>
			<c:choose>
			<c:when test="${memberList ne null}">
				<tr>
					<th>유저번호</th>
					<th>이름</th>
					<th>비밀번호</th>
					<th>닉네임</th>
					<th>이메일</th>
					<th>휴대폰</th>
				</tr>
				<c:forEach var="member" items="${memberList}">
				<tr class="moveDetail" data-userid="${member.userId }">
					<input type="hidden" id=userId value="${member.userId }">
					<td style="text-align: center;"><c:out value="${member.userId }"/></td>
					<td style="text-align: center;"><c:out value="${member.userNm }"/></td>
					<td style="text-align: center;" ><c:out value="${member.passWd }"/></td>
					<td style="text-align: center;"><c:out value="${member.nick }"/></td>
					<td style="text-align: center;"><c:out value="${member.email }"/></td>
					<td style="text-align: center;"><c:out value="${member.phone }"/></td>
				</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<td>등록된 유저가 없습니다.</td>
			</c:otherwise>
			</c:choose>
			
		</table>




	</main>
</section>



<script>
//var userId = '<c:out value="${member.userId }"/>';

$(".moveDetail").on("click", function(){
	var userId = $(this).data("userid");
	//var userId = $("#userId").val();
	console.log(userId);
	
});

</script>


<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>
