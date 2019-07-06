<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編輯公佈事項</title>
</head>
<body>
<h1 align="left">編輯公佈事項</h1>
<% request.getParameter("title");
   request.getParameter("author");
   request.getParameter("publishDate");
   request.getParameter("deadDate");
   request.getParameter("content"); %>
<form action="src.service.UpdateInformation">
	<h2>標題:</h2>
	<input type="text" name="title" id="title" value="${title}"><p/>
	<h2>發佈日期:</h2>
	<input type="datetime" name="publishDate" id="publishDate" value="${publishDate}"><p/>
	<h2>截止日期:</h2>
	<input type="datetime" name="deadDate" id="deadDate" value="${deadDate}"><p/>
	<h2>公佈者:${author}</h2><p/>
	<h2>公佈內容</h2>
	<input type="text" name="content" id="content" value="${content}"><p/>
	<input type="submit" value="確認送出">
</form>
</body>
</html>