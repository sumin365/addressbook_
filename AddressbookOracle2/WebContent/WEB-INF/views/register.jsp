<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주소록 Servlet</title>
</head>
<body>
   <h1>주소록 Servlet</h1>
   <h3>새 주소 등록</h3>
   
   <form action="hs" 
         method="POST">
		<label for="name">이름</label>
		<input type="text" id="name" name="name">
		<br/>
		<label for="tel">휴대전화</label>
		<input type="text" id="tel" name="tel">
		<br/>
		<label for="hp">집전화</label>
		<input type="text" id="hp" name="hp">
		<input type="submit" value="주소등록" />
	</form>

     <p>
		<a href="<c:url value='/addressbook?action=index'/>">목록 보기</a>
	</p>
	
	
	
</body>
</html>