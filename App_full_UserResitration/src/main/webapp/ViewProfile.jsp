<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import= "Test.UserBean"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String fName = (String)request.getAttribute("fname");
UserBean ub = (UserBean)application.getAttribute("ubean");
out.println("Page belongs to User : "+fName+"<br>");
out.println(ub.getfName()+"&nbsp&nbsp"+ub.getlName()+"&nbsp&nbsp"+ub.getAddr()+
		"&nbsp&nbsp"+ub.getmId()+"&nbsp&nbsp"+ub.getphNo()+
		"&nbsp&nbsp"+"<a href='edit'>Edit</a>"+"<br>");
%>
<a href="logout">Logout</a>


</body>
</html>