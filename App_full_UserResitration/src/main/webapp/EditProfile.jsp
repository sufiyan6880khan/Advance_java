<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "Test.UserBean"%>
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
%>
<form action="update" method="post">
Address:<input type="text" name="addr" value=<%=ub.getAddr() %>><br>
MailId:<input type="text" name="mid" value=<%=ub.getmId() %>><br>
PhoneNo:<input type="text" name="phno" value=<%=ub.getphNo() %>><br>
<input type="submit" value="UpdateProfile">
</form>

</body>
</html>