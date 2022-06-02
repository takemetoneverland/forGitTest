<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#content {
		margin-top: 15%;
		margin-left: 40%;
		border: 1px solid black;
		display: inline-block;
	}
	form {
		display: inline-block;	
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

	<div id="content">
		<input type="hidden" value="${article.bno}">
		작성자: <input type="text" value="${article.writer}" readonly> <br>
		제목: <input type="text" value="${article.title}" readonly> <br>
		작성일: <fmt:formatDate value="${article.regdate}" pattern="yyyy-MM-dd hh:mm:ss"/>
		<div>
			<textarea cols="30" rows="10" readonly>${article.content}</textarea>
		</div>
		<div>
			<form action="list" method="post">
            <button type="button" id="listBtn">목록</button>                           
            </form>
            <button type="button" id="modBtn">수정</button>                
            <button type="button" id="delBtn">삭제</button>
        </div>
	</div>
	
	<script>
		$(document).ready(function() {
			//목록 버튼 이벤트 처리
			$('#listBtn').click(function() {
				location.href='list';
			});
			
			//삭제 버튼 이벤트 처리
			$('#delBtn').click(function() {
				location.href='delete?bno=' + ${article.bno};
			});
			
			//수정 버튼 이벤트 처리
			$('#modBtn').click(function() {
				location.href='modify?bno=' + ${article.bno};
			});
		});
	</script>	

</body>
</html>







