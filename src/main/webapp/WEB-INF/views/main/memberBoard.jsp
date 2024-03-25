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
		<h3>유저 게시판</h3>
		<br>
		
		<form id="frmSendValue">
		<table>
			<c:choose>
			<c:when test="${memberList ne null}">
				<tr>
					<th><input type="checkbox" id="allcheck" onclick="allCheck()"></th>
					<th>유저번호</th>
					<th>이름</th>
					<th>비밀번호</th>
					<th>닉네임</th>
					<th>이메일</th>
					<th>휴대폰</th>
				</tr>
				<c:forEach var="member" items="${memberList}">
				<tr class="moveDetail" data-userid="${member.userId }">
					<td style="text-align: center;" onclick="event.stopPropagation()" >
						<input type="checkbox" id="rowcheck" value="${member.userId } "></td>
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
		<button type="button" id="btnToDelete">삭제</button> 
		</form>






	</main>
</section>



<script>
var frmSendValue = $("#frmSendValue");

var result = '<c:out value="${result }"/>';
console.log(result);

//정보 수정 결과 띄우기
	if ( result == "1" ) {
		alert("비밀번호가 수정되었습니다.");
	}  





// 특정 회원 상세 정보 detail로 
$(".moveDetail").on("click", function(){
	var userId = $(this).data("userid");
	var url = "/app/member/detail?userId=" + encodeURIComponent(userId);
	
	window.location.href = url;
});


//체크박스 전체선택
function allCheck(){
	
    var checkboxes = document.querySelectorAll('input[id=rowcheck]');
    var allCheck = document.getElementById('allcheck');
    
	for( i=0; i< checkboxes.length; i++){
		checkboxes[i].checked = allCheck.checked;
	}
}


//체크된 회원 삭제
$("#btnToDelete").on("click", function(){
	
    var selectedUserIds = [];
    
    // 체크된 체크박스를 찾아서 값을 배열에 저장
    $(".moveDetail input[type=checkbox]:checked").each(function() {
        selectedUserIds.push($(this).val().trim());
    });
    
    console.log(selectedUserIds);
    
    // AJAX 요청
    $.ajax({
        type: "POST",
        url: "/app/member/delete",
        data: JSON.stringify({ selectedUserIds: selectedUserIds }), // 데이터 전송
        contentType: "application/json",
        success: function(response) {
            console.log("서버 응답:", response);
             if(response !== null && response !== 0) {
            	alert("삭제 성공");
            	document.location.reload();
            } 
        },
        error: function(xhr, status, error) {
            console.error("에러:", error);
            // 에러 발생 시 실행할 코드 작성
        }
    });

	
});
	








</script>


<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>
