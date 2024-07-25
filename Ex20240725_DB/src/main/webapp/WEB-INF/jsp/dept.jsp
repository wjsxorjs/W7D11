<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서목록</title>

</head>
<body>
	<header>
        <h2>목록</h2>
    </header>
    <article>
        <ul>
            <c:forEach var="dvo" items="${d_ar}">
                <li>${dvo.deptno} || ${dvo.dname} || ${dvo.loc_code}</li>
            </c:forEach>
        </ul>
    </article>
	
</body>
</html>