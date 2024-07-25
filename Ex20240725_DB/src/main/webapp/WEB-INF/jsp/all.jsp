<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원목록</title>

</head>
<body>
	<header>
        <h2>목록</h2>
    </header>
    <article>
        <ul>
            <c:forEach var="evo" items="${e_ar}">
                <li>${evo.empno},${evo.ename},${evo.job},${evo.deptno}</li>
            </c:forEach>
        </ul>
    </article>
	
</body>
</html>