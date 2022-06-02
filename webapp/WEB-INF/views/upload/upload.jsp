<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 파일 업로드에서는 enctype을 multipart/form-data로 설정 -->
	<form action="upload_ok" method="post" enctype="multipart/form-data">
		<input type="file" name="file"> <br>
		<input type="submit" value="전송">
	</form>

</body>
</html>