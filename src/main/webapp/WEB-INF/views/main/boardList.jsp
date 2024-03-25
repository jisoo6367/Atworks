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
	<br>
	<h3>게시판 리스트</h3>
	<br>

<form id="frmSendValue">
		<table>
			<c:choose>
			<c:when test="${boardList ne null}">
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>내용</th>
					<th>회원고유번호</th>
					<th>조회수</th>
					<th>등록일</th>
					<th>수정일</th>
				</tr>
				<c:forEach var="board" items="${boardList}">
				<tr class="moveDetail" data-idx="${board.idx }">
					<td style="text-align: center;"><c:out value="${board.idx }"/></td>
					<td style="text-align: center;"><c:out value="${board.title }"/></td>
					<td style="text-align: center;"><c:out value="${board.content }"/></td>
					<td style="text-align: center;"><c:out value="${board.userId }"/></td>
					<td style="text-align: center;"><c:out value="${board.viewCnt }"/></td>
					<td style="text-align: center;"><c:out value="${board.insertTime }"/></td>
					<td style="text-align: center;"><c:out value="${board.updateTime }"/></td>
				</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<td>등록된 게시글이 없습니다.</td>
			</c:otherwise>
			</c:choose>
			</table>
			<br>
			<button type="button" class="btn_type1" id="btnToRegister">게시글 등록</button> 
		</form>



	</main>
</section>

<script>

var result = '<c:out value="${result }"/>';
console.log(result);

//결과 띄우기
if ( result == "successRegister" ) {
	alert("게시글이 수정되었습니다.");
} else if ( result == "failRegister" ) {
	alert("게시글이 수정에 실패하였습니다.");
} else if ( result == "successModify" ) {
	alert("게시글이 수정되었습니다.");
} else if ( result == "failModify" ) {
	alert("게시글 수정에 실패하였습니다.");
} else if ( result == "successDelete" ) {
	alert("게시글이 삭제되었습니다.");
} else if ( result == "failDelete" ) {
	alert("게시글 삭제에 실패하였습니다.");
}



// 특정 게시물 detail로
$(".moveDetail").on("click", function(){
	var idx = $(this).data("idx");
	var url = "/app/board/detail?idx=" + encodeURIComponent(idx);
	
	window.location.href = url;
});


// 게시글 등록
$("#btnToRegister").on("click", function(){
	window.location.href = "/app/board/register";
});

</script>


<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>
