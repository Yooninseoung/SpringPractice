<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<title>JSONTest</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>  
<script>
  $(function() {
      $("#checkJson").click(function() {
      	var member = { id:"park", 
  			    name:"사용자",
  			    pwd:"1234", 
  			    email:"user@test.com" };
  	$.ajax({
        type:"post", //GET,POST,PUT,DELETE등의 rest 방식으로 uri표현
        url:"${contextPath}/test/info", //책 1063page 참고. -> /작업명/기본키 + 메서드 + 데이터
        contentType: "application/json", 
        data :JSON.stringify(member), //회원정보를 JSON 문자열로 변환.
     success:function (data,textStatus){
     },
     error:function(data,textStatus){
        alert("에러가 발생했습니다.");
     },
     complete:function(data,textStatus){
     }
  });  	

   });
});
</script>
</head>
<body>
  <input type="button" id="checkJson" value="회원 정보 보내기"/><br><br>
  <div id="output"></div>
</body>
</html>