<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	#content{
	    margin-top: 15%;
	    margin-left: 40%;
	    border: 1px solid black;
	    display: inline-block;            
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<body>

	<form action="update">
		<div id="content">
			<input type="hidden" value="${article.bno}" name="bno">
	                작성자: <input type="text" value="${article.writer}" name="writer"> <br>
	                제목: <input type="text" value="${article.title}" name="title">
	         <div>
	            <textarea name="content" cols="30" rows="10">${article.content}</textarea>
	        </div>
	        <div>
	            <button type="submit">수정</button>
	            <button type="button" id="cancelBtn">취소</button>
	        </div>
	    </div>
    </form>
    
    <script>
    	$(document).ready(function() {
    		
    		//취소 버튼 이벤트 처리
    		$('#cancelBtn').click(function() {
    			console.log('취소버튼눌림');
				history.back();
			});
    		
		});
    </script>

</body>
</html>