<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<%
  request.setCharacterEncoding("UTF-8");
%>    


<html>
<head>
<meta charset=UTF-8">
<title>결과창</title>
</head>
<body>
<h1>아이디 : ${infoEX.userID }</h1>
<h1>이름   : ${infoEX.userName }</h1>
</body>
</html>
