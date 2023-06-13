<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>product 목록</title>
</head>
<body>
<h1> 상품목록 </h1>
<hr>

<table border="1">
<tr><th>번호</th><th>상품명</th><th>제조사</th><th>가격</th></tr>
<c:forEach var="p" varStatus="i" items="${products }">
<tr><td>${i.count}</td><td>
 <a href="/01firstpjt/pcontrol?action=info&id=${p.id}">${p.name}</a></td>
 <td>${p.price}</td></tr>
</c:forEach>
</table>
</body>
</html>