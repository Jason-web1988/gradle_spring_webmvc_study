<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${login.loginType},<br>
${login.jobCode },<br>
${login.tool }<br>
${login.favoriteOs }<br>
${login.likeOs }<br>
${login.strSubjects}
<br>
<c:forEach items="${login.subjects }" var="subject" varStatus="idx">
	${subject }
</c:forEach>

</body>
</html>