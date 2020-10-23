<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>
	<c:if test="${empty authInfo }">
	    <p><spring:message code="main.welcome" /> </p>
	    <p>
	    	<a href="<c:url value="/register/step1" />">[<spring:message code="member.register" />]</a>
	    	<a href="<c:url value="/login" />">[<spring:message code="login.btn" />]</a>
	    </p>
    </c:if>
    
    <c:if test="${!empty authInfo }">
	    <p><spring:message code="main.done" arguments="${authInfo.name }" /></p>
	    <p>
	    	<a href="<c:url value="/edit/changePassword" />">[<spring:message code="change.pwd.title" />]</a>
	    	<a href="<c:url value="/logout" />">[<spring:message code="main.logout" />]</a>
	    </p>
    </c:if>
</body>
</html>