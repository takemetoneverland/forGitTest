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
<body>

	<form action="regist" method="post">
		<div id="content">
	        <input type="text" placeholder="작성자" name="writer"> <br>
	        <input type="text" placeholder="제목" name="title">
	         <div>
	            <textarea name="content" cols="30" rows="10" placeholder="내용"></textarea>
	        </div>
	        <div>
	            <button type="submit">등록</button>
	        </div>
	    </div>
    </form>

</body>
</html>