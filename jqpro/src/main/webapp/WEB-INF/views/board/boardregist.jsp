<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>게시글 등록</h3>
<hr>
<br>
<div style="margin: 5px">
<form action="<%=request.getContextPath()%>/board/regist" method="post">
<label>제목: </label><input type ="text" name ="title" style="width: 300px; heigth:30px;">
<p>내용</p>
<textarea rows="4" cols="48" name="content" style="resize: none"></textarea><br>
<input type="submit">
</form>
</div>
</body>
</html>