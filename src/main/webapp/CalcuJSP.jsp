<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int n1 = Integer.parseInt(request.getParameter("n1"));
int n2 = Integer.parseInt(request.getParameter("n2"));
String op = request.getParameter("op");

int result = 0;

switch(op){
case "+": result = n1 + n2; break;
case "-": result = n1 - n2; break;
case "*": result = n1 * n2; break;
case "/": result = n1 - n2; break;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>계산결과</h2>
<hr>
<h2>Calculator JSP Display</h2>
결과: <%=n1 %>  <%= op %> <%=n2 %> = <%=result %>
</body>
</html>