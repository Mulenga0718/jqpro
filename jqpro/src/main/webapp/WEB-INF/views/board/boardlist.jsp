<%@page import="board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>게시판</h3>
<hr><br><br>
<input type="button" value="게시글 등록" onclick="location.href='regist'">
<table border="1">

<tr>
	<td>번호</td>
	<td>제목</td>
	<td>등록자</td>
	<td>등록일</td>
	<td>조회</td>
</tr>
<%
		List<BoardVO> list = (List<BoardVO>)request.getAttribute("list");
		for(int i=0; i<list.size(); i++){
			application.setAttribute("boardlist", list.get(i));
%>
<tr >
	<td>${boardlist.num }</td>
	<td onclick="location.href='board/detail?num=${boardlist.num }'"  style="cursor: pointer">${boardlist.title }</td>
	<td>${boardlist.writer }</td>
	<td>${boardlist.date}</td>
	<td>${boardlist.count }</td>
</tr>

<%			
		}
%>  
  
</table>
</body>
</html>