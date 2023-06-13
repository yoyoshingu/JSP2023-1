<%@ page import="java.time.LocalDateTime" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My first jsp file</title>
</head>
<body>
<h1>Hi everybody</h1>
<hr>
<h2> 현재시각은 <%=LocalDateTime.now() %>  입니다 </h2>
<h2> 데이터전송방식 <%=request.getMethod() %>  입니다 </h2>
<h2> URL은 <%=request.getRequestURI() %>  입니다 </h2>
<h2> 프로토콜은 <%=request.getProtocol() %>  입니다 </h2>
<h2> 서버명은 <%=request.getServerName() %>  입니다 </h2>
<h2> 서버포트는 <%=request.getServerPort() %>  입니다 </h2>
<h2> ip주소는 <%=request.getRemoteAddr() %>  입니다 </h2>

</body>
</html>