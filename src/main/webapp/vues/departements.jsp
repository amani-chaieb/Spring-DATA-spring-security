<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"      uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>departement</title>
</head><
<body>
<sec:authorize access="isAuthenticated()">
Bienvenue <sec:authentication property="name"/>
(<a href="<c:url value="/logout"/>"> Logout</a>)
</sec:authorize>

<h3>Liste des départements</h3>
<table border="1">
<tr><td>ID</td><td>Titre</td></tr>
<c:forEach items="${ld}" var="l">

<tr>
<td>${l.id}</td>
<td>${l.titre}</td>

<sec:authorize access="hasAnyRole('AGENT','ADMIN')"> 
<td><a href="mtrl/${l.id}">Liste des matériels</a></td>
</sec:authorize>
</tr>
</c:forEach>
</table>
</body>
</html>