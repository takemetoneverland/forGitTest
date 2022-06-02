<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	a{
		font-size: 30px;
	}
</style>
</head>
<body>
	<h1>Hello Web~</h1>
	<a href='<c:url value="/user/joinForm" />'>회원가입</a> <br>
	<a href='<c:url value="/user/loginPage" />'>로그인</a> <br>
	<a href='<c:url value="/user/modify" />'>회원정보수정</a> <br>
	<a href='<c:url value="/board/list" />'>게시판</a> <br>
	<a href='<c:url value="/upload/upload" />'>파일업로드</a> <br>
	<c:if test="${loginSession != null}" >
		<a href='<c:url value="/user/logout" />'>로그아웃</a> <br>
	</c:if>
</body>
</html>