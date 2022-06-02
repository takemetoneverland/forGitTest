<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        table {
            border: 1px solid black;
            margin: auto;
            text-align: center
        }
        th, tr, td {
            border: 1px solid black;
        }
        .thead {
        	margin-top: 20%;
        	width: 35vw;
        }
        .page {
        	margin-top: 1%;
        	width: 10%;
        	border: none;
        }
        .search-box {
        	margin-top: 1%;
        	border: none;
        }
    </style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<table class="thead">
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
        </tr>
        
        <c:forEach varStatus="status" var="b" items="${articles}">
	        <tr>
				<td><c:out value='${pc.articleTotalCount - ((pc.paging.page - 1) * pc.paging.countPerPage + status.index)}' /></td>
	            <td><a href='<c:url value="/board/content?bno=${b.bno}" />'><c:out value='${b.title}' /></a></td>
	            <td>${b.writer}</td>
	            <td>
	            	<fmt:formatDate value="${b.regdate}" pattern="yyyy-MM-dd hh:mm:ss"/>
	            </td>
	        </tr>
        </c:forEach>
     </table>
     
     <table class="search-box">
     	<tr>
     		<td style="border: none;">
     			<select id="condition" name="condition">
     				<option ${(param.condition == "title") ? 'selected' : ''} value="title">제목</option>
     				<option ${(param.condition == "writer") ? 'selected' : ''} value="writer">작성자</option>
     			</select>
				<input type="text" placeholder="검색어를 입력하세요." id="keywordInput">
		        <button type="button" id="searchBtn" name="keyword">검색</button> &nbsp;
		        <button type="button" id="writeBtn">글쓰기</button>
     		</td>
     	</tr>
     </table>
     
     <table class="page">
        <tr class="page">
        	<td class="page">
        		<!-- 이전 버튼 -->
        		<c:if test="${pc.prev}">
		        	<a href='<c:url value="/board/list${pc.makeURI(pc.beginPage-1)}" />'>이전</a>
		        </c:if>
        	</td>
        	
			<c:forEach var="pageNum" begin="${pc.beginPage}" end="${pc.endPage}">
        	<td class="page">
        		<!-- 페이지 번호 -->
	        	<a href='<c:url value="/board/list${pc.makeURI(pageNum)}" />'><c:out value='${pageNum}' /></a>
        	</td>
        	</c:forEach>
        	
        	<td class="page">
        		<!-- 다음 버튼 -->
        		<c:if test="${pc.next}">
		        	<a href='<c:url value="/board/list${pc.makeURI(pc.endPage+1)}" />'>다음</a>
		        </c:if>
        	</td>
	    </tr>
    </table>
    
	<script>
		$(document).ready(function() {
			//검색 버튼 이벤트 처리
			/*
			$('#searchBtn').click(function() {
				console.log('버튼 눌림');
				const keyword = $('#keywordInput').val();
				const condition = $('#condition').val();
				console.log(keyword);
				location.href="/board/list?keyword=" + keyword + "&condition=" + condition;
			});
			*/
			
			//글쓰기 버튼 이벤트 처리(글쓰기 페이지로 이동)
			$('#writeBtn').click(function() {
				location.href='write';
			});
		});	
	</script>

</body>
</html>