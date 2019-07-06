<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>公佈欄</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<c:if test="${LoginOK == null}">
		<c:set var="userName" value="訪客" />
	</c:if>
	<c:if test="${LoginOK != null}">
		<c:set var="userName" value="${LoginOK.userId}" />
	</c:if>
	<h1 align="left">您好，${userName}</h1><br>
	<s:a href="create"><input type="button" value="新增事項"/></s:a>
	<div id="content" class="container">
		<table>
			<tr>
				<th>
					瀏覽公佈欄事項
				</th>
			</tr>
			<tr>
				<td>標題</td>
				<td>公佈者</td>
				<td>發布日期</td>
				<td>截止日期</td>
				<td>修改</td>
				<td>刪除</td>
			</tr>
			<c:forEach varStatus="information" var="BoardBean" items="InformationList">
				<tr>
					<td>${BoardBean.title}</td>
					<td>${BoardBean.author}</td>
					<td>${BoardBean.publishDate}</td>
					<td>${BoardBean.deadDate}</td>
					<td>
						<form action="update" method="post">
							<input type="hidden" name="userId" value="${LoginOK.userId}">
							<input type="hidden" name="no" value="${BoardBean.no}">
							<input type="hidden" name="title" value="${BoardBean.title}">
							<input type="hidden" name="author" value="${BoardBean.author}">
							<input type="hidden" name="publishDate" value="${BoardBean.publishDate}">
							<input type="hidden" name="deadDate" value="${BoardBean.deadDate}">
							<input type="hidden" name="content" value="${BoardBean.content}">
							<input type="submit" value="修改">
						</form>
					</td>
					<td>
						<form action="delete" method="post">
							<input type="hidden" name="userId" value="${LoginOK.userId}">
							<input type="hidden" name="no" value="${BoardBean.no}">
							<input type="hidden" name="title" value="${BoardBean.title}">
							<input type="hidden" name="author" value="${BoardBean.author}">
							<input type="hidden" name="publishDate" value="${BoardBean.publishDate}">
							<input type="hidden" name="deadDate" value="${BoardBean.deadDate}">
							<input type="hidden" name="content" value="${BoardBean.content}">
							<input type="submit" value="刪除">
						</form>
					</td>		
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="page">
		<table>
			<tr>
				<td width="76">
					<c:if test="${pageNo > 1}">
						<div id="pageFirst">
							<a href="<c:url value='DisplayInformation?pageNo=1' />">
								第一頁
							</a>
							&nbsp;&nbsp;&nbsp;
						</div>
					</c:if>
				</td>
				<td width="76">
					<c:if test="${pageNo > 1}">
						<div id="pagePrev">
							<a href="<c:url value='DisplayInformation?pageNo=${pageNo - 1}' />">
								上一頁
							</a>
							&nbsp;&nbsp;&nbsp;
						</div>
					</c:if>	
				</td>
				<td width="76">
					<c:if test="${pageNo != totalPages}">
						<div id="pageNext">
							<a href="<c:url value='DisplayInformation?pageNo=${pageNo + 1}' />">
								下一頁
							</a>
							&nbsp;&nbsp;&nbsp;
						</div>
					</c:if>
				</td>
				<td width="76">
					<c:if test="${pageNo != totalPages}">
						<div id="pageLast">
							<a href="<c:url value='DisplayInformation?pageNo=${totalPages}' />">
								最末頁
							</a>
							&nbsp;&nbsp;&nbsp;	
						</div>
					</c:if>	
				</td>
				<td width="176" align="center">
					第${pageNo}頁/共${totalPages}頁
				</td>
			</tr>				
		</table>
	</div>
</body>
</html>